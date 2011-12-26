package nicovideo4j;

import http.ConnectionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import nicovideo4j.util.HtmlUtil;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSReader extends DefaultHandler{

	private List<RSSInfo> list;
	private List<String> tags;
	private RSSInfo info;
	private Map<String,String> map;
	
	public RSSReader(InputStream source) throws ParserConfigurationException, SAXException, IOException{
		list=new ArrayList<RSSInfo>();
		tags=new LinkedList<String>();
		map=new TreeMap<String, String>();
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		parser.parse(HtmlUtil.formHtml(source),this);
	}
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static List<RSSInfo> getList(String url) throws IOException, ParserConfigurationException, SAXException{
		URLConnection con=ConnectionUtil.getConnection(url+"?rss=2.0");
		RSSReader rss=new RSSReader(con.getInputStream());
		return rss.list;
	}
	private void setInfo(){
		info.setTitle(map.get("title"));
		info.setLink(map.get("link"));
		info.setGuid(map.get("guid"));
		info.setPubDate(map.get("pubDate"));
		String[] tmp=map.get("description").split("</p>");
		info.setThumbnailUrl(tmp[0].substring(tmp[0].indexOf("http"),tmp[0].indexOf("\" width")));
		info.setDescription(tmp[1]=tmp[1].substring(tmp[1].indexOf(">")+1));
		tmp=tmp[2].replaceAll(",","").split("class=[^>]+>");
		info.setNumber(Integer.parseInt(tmp[2].substring(0,tmp[2].indexOf("<"))));
		info.setLength(tmp[3].substring(0,tmp[3].indexOf("<")));
		info.setDate(tmp[4].substring(0,tmp[4].indexOf("<")));
		info.setTotalView(Integer.parseInt(tmp[5].substring(0,tmp[5].indexOf("<"))));
		info.setTotalRes(Integer.parseInt(tmp[6].substring(0,tmp[6].indexOf("<"))));
		info.setTotalMyList(Integer.parseInt(tmp[7].substring(0,tmp[7].indexOf("<"))));
		info.setDailyView(Integer.parseInt(tmp[8].substring(0,tmp[8].indexOf("<"))));
		info.setDailyRes(Integer.parseInt(tmp[9].substring(0,tmp[9].indexOf("<"))));
		info.setDailyMyList(Integer.parseInt(tmp[10].substring(0,tmp[10].indexOf("<"))));
	}
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("startDocument");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tags.add(qName);
		if(qName.equals("item"))info=new RSSInfo();
		//System.out.println("startElement("+uri+","+localName+","+qName+","+attributes.getValue("status")+")");
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		map.put(tags.get(tags.size()-1),new String(ch,start,length));
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals("item")){
			setInfo();
			list.add(info);
		}
		//System.out.println("endElement("+uri+","+localName+","+qName+")");
		tags.remove(tags.size()-1);
	}
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("endDocument");
	}
}
