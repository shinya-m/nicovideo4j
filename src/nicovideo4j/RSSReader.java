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

public class RSSReader{

	private static RSSInfo info;
	private static final String[] reg={
			"<title>([^<]+)</title>",
			"<link>([^<]+)</link>",
			//"<pubDate>([^<]+)</pubDate>",
			"src=\"([^\"]+)\"",
			"nico-description\">([^<]+)</p>",
			"nico-info-number\">([^<]+)</strong>",
			"nico-info-length\">([^<]+)</strong>",
			"nico-info-date\">([^<]+)</strong>",
			"nico-info-total-view\">([^<]+)</strong>",
			"nico-info-total-res\">([^<]+)</strong>",
			"nico-info-total-mylist\">([^<]+)</strong>",
			"nico-info-daily-view\">([^<]+)</strong>",
			"nico-info-daily-res\">([^<]+)</strong>",
			"nico-info-daily-mylist\">([^<]+)</strong>"
	};
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<RSSInfo> getList(String url) throws IOException{
		URLConnection con=ConnectionUtil.getConnection(url+"?rss=2.0");
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		List<RSSInfo> list=new ArrayList<RSSInfo>();
		
		Pattern[] p=new Pattern[reg.length];
		
		String s;
		for(int i=0;i<p.length;i++){
			p[i]=Pattern.compile(reg[i],Pattern.CASE_INSENSITIVE);
		}
		Matcher m;
		while((s=bf.readLine())!=null){
			for(int i=0;i<p.length;i++){
				m=p[i].matcher(s);
				if(m.find()){
					if(i==0)info=new RSSInfo();
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
			info.setTitle(s);
			break;
		case 1:
			info.setLink(s);
			break;
		case 2:
			info.setThumbnailUrl(s);
			break;
		case 3:
			info.setDescription(s);
			break;
		case 4:
			s=s.replace(",","");
			info.setNumber(Integer.parseInt(s));
			break;
		case 5:
			info.setLength(s);
			break;
		case 6:
			info.setDate(s);
			break;
		case 7:
			s=s.replace(",","");
			info.setTotalView(Integer.parseInt(s));
			break;
		case 8:
			s=s.replace(",","");
			info.setTotalRes(Integer.parseInt(s));
			break;
		case 9:
			s=s.replace(",","");
			info.setTotalMyList(Integer.parseInt(s));
			break;
		case 10:
			s=s.replace(",","");
			info.setDailyView(Integer.parseInt(s));
			break;
		case 11:
			s=s.replace(",","");
			info.setDailyRes(Integer.parseInt(s));
			break;
		case 12:
			s=s.replace(",","");
			info.setDailyMyList(Integer.parseInt(s));
			break;
		}
	}
}
