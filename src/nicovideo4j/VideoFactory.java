package nicovideo4j;

import http.ConnectionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author shinya-m
 *
 */
public class VideoFactory extends DefaultHandler{

	private static VideoFactory factory;
	private Map<String,String> map;
	private String currentElement;
	private String currentDomain;
	private List<String> tags;
	private Map<String,List<String>> tagMap;
	private NicoVideo video;
	
	private VideoFactory(InputStream source) throws ParserConfigurationException, SAXException, IOException{
		map=new TreeMap<String, String>();
		tagMap=new TreeMap<String, List<String>>();
		video=new NicoVideo();
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		parser.parse(source,this);
	}
	/**
	 * ログイン必要なし
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static NicoVideo getVideo(String id) throws IOException, ParserConfigurationException, SAXException{
		URLConnection con=ConnectionUtil.getConnection("http://ext.nicovideo.jp/api/getthumbinfo/"+id);
		factory=new VideoFactory(con.getInputStream());
		factory.setInfo();
		return factory.video;
	}
	/**
	 * 
	 */
	private void setInfo(){
		video.setId(map.get("video_id"));
		video.setTitle(map.get("title"));
		video.setDescription(map.get("description"));
		video.setThumbnailUrl(map.get("thumbnail_url"));
		video.setFirstRetrive(map.get("first_retrieve"));
		video.setLength(map.get("length"));
		video.setMovieType(map.get("movie_type"));
		video.setSizeHigh(Long.parseLong(map.get("size_high")));
		video.setSizeLow(Long.parseLong(map.get("size_low")));
		video.setViewCounter(Long.parseLong(map.get("view_counter")));
		video.setCommentNum(Long.parseLong(map.get("comment_num")));
		video.setMyListCounter(Long.parseLong(map.get("mylist_counter")));
		video.setLastResBody(map.get("last_res_body"));
		video.setWatchUrl(map.get("watch_url"));
		video.setThumbType(map.get("thumb_type"));
		video.setEmbeddable(Integer.parseInt(map.get("embeddable")));
		video.setNoLivePlay(Integer.parseInt(map.get("no_live_play")));
		video.setTags(tagMap);
		video.setUserId(map.get("user_id"));
	}
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("startDocument");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentElement=qName;
		if(currentElement.equals("nicovideo_thumb_response")){
			video.setStatus(attributes.getValue("status").equals("ok")?true:false);
		}else if(currentElement.equals("tags")){
			currentDomain=attributes.getValue("domain");
			tags=new ArrayList<String>();
		}
		//System.out.println("startElement("+uri+","+localName+","+qName+","+attributes.getValue("status")+")");
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(ch[start]!='\n'){
			if(currentElement.equals("tag")){
				tags.add(new String(ch,start,length));
			}
			else{
				map.put(currentElement,new String(ch,start,length));
				//System.out.println("put("+currentElement+","+new String(ch,start,length)+")");
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals("tags")){
			tagMap.put(currentDomain,tags);
		}
		//System.out.println("endElement("+uri+","+localName+","+qName+")");
	}
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("endDocument");
	}
}
