package nicovideo4j;

import http.ConnectionUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchRSSReader {

	private static final String base="http://www.nicovideo.jp/";
	
	private static RSSInfo info;
	private static final String[] reg={
			"img src=\"([^\"]+)\"",		//thumbnail
			"<span>([^<]+)</span>",		//length
			"vinfo_view\">([^<]+)</strong>",	//total view
			"vinfo_res\">([^<]+)</strong>",		//comment
			"vinfo_mylist\">([^<]+)</strong>",	//mylist
			"strong>([^<]+)</strong>",	//date
			"nobr><a href=\"([^\"]+)\"",	//link
			"h\" title=\"([^\"]+)\">",	//title
	};
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<RSSInfo> getList(String url) throws IOException{
		URLConnection con;
		con=ConnectionUtil.getConnection(url);
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		List<RSSInfo> list=new ArrayList<RSSInfo>();
		
		Pattern[] p=new Pattern[reg.length];
		
		String s;
		for(int i=0;i<p.length;i++){
			p[i]=Pattern.compile(reg[i],Pattern.CASE_INSENSITIVE);
		}
		Matcher m;
		while((s=bf.readLine())!=null){
			System.out.println(s);
			for(int i=0;i<p.length;i++){
				m=p[i].matcher(s);
				if(m.find()){
					if(i==0){
						info=new RSSInfo();
					}
					setInfo(i,m.group(1));
					if(i==p.length-1)list.add(info);
					//System.out.println(m.group(1));
				}
			}
		}
		return list;
	}
	private static void setInfo(int n,String s){
		switch(n){
		case 0:
			info.setThumbnailUrl(s);
			break;
		case 1:
			info.setLength(s);
			break;
		case 2:
			s=s.replace(",","");
			info.setTotalView(Integer.parseInt(s));
			break;
		case 3:
			s=s.replace(",","");
			info.setTotalRes(Integer.parseInt(s));
			break;
		case 4:
			s=s.replace(",","");
			info.setTotalMyList(Integer.parseInt(s));
			break;
		case 5:
			info.setDate(s);
			break;
		case 6:
			info.setLink(base+s);
			break;
		case 7:
			info.setTitle(s);
			break;
		}
	}
}
