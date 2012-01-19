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
	
	private static RankingRSSInfo info;
	
	private static final String[] reg={
			"title>([^<]+)</title",//title
			"link>([^<]+)</link",//link
			"src=\"([^\"]+)\"",//thumbnail
			"nico-description\">([^<]+)</p",//description
			"nico-info-length\">([^<]+)</strong",//length
			"nico-info-date\">([^<]+)</strong"//date
	};
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<RankingRSSInfo> getList(int searchType,int option,String keyword) throws IOException{
		String searchUrl=base+SearchRSSReader.searchType[searchType]+keyword+SearchRSSReader.option[option];
		URLConnection con=ConnectionUtil.getConnection(searchUrl);
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		List<RankingRSSInfo> list=new ArrayList<RankingRSSInfo>();
		
		Pattern[] p=new Pattern[reg.length];
		
		String s;
		for(int i=0;i<p.length;i++){
			p[i]=Pattern.compile(reg[i],Pattern.CASE_INSENSITIVE);
		}
		Matcher m;
		while((s=bf.readLine())!=null){
			//System.out.println(s);
			for(int i=0;i<p.length;i++){
				m=p[i].matcher(s);
				if(m.find()){
					if(i==0){
						info=new RankingRSSInfo();
					}
					setInfo(i,m.group(1));
					if(i==p.length-1)list.add(info);
					//System.out.println(m.group(1));
				}
			}
		}
		System.out.println(list.size());
		return list;
	}
	private static void setInfo(int n,String s){
		switch(n){
		case 0:
			info.setTitle(s);
			break;
		case 1:
			info.setLink(s);
			info.setLength(s);
			break;
		case 2:
			info.setThumbnailUrl(s);
			break;
		case 3:
			info.setDescription(s);
			break;
		case 4:
			info.setLength(s);
			break;
		case 5:
			info.setDate(s);
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		}
	}
	
	private static final String[] searchType={
		"search/",
		"tag/",
		"mylist_search/"
	};
	/**
	 * キーワード検索
	 */
	public static final int SEARCH=0;
	/**
	 * タグ検索
	 */
	public static final int TAG=1;
	private static final String[] option={
		"?rss=2.0",//コメントが新しい順
		"?order=a&rss=2.0",//コメントが古い順
		"?sort=v&rss=2.0",//再生が多い順
		"?sort=v&order=a&rss=2.0",//再生が少ない順
		"?sort=r&rss=2.0",//コメント数が多い順
		"?sort=r&order=a&rss=2.0",//コメント数が少ない順
		"?sort=m&rss=2.0",//マイリストが多い順
		"?sort=m&order=a&rss=2.0",//マイリストが少ない順
		"?sort=f&rss=2.0",//投稿日時が新しい順
		"?sort=f&order=a&rss=2.0",//投稿日時が古い順
		"?sort=l&rss=2.0",//再生時間が長い順
		"?sort=l&order=a&rss=2.0"//再生時間が短い順
	};
	
	/**
	 * コメントが新しい順
	 */
	public static final int COMMENT_NEW=0;
	/**
	 * コメントが古い順
	 */
	public static final int COMMENT_OLD=1;
	/**
	 * 再生数が多い順
	 */
	public static final int VIEW_LARGE=2;
	/**
	 * 再生数が少ない順
	 */
	public static final int VIEW_SMALL=3;
	/**
	 * コメント数が多い順
	 */
	public static final int COMMENT_LARGE=4;
	/**
	 * コメント数が少ない順
	 */
	public static final int COMMENT_SMALL=5;
	/**
	 * マイリストが多い順
	 */
	public static final int MYLIST_LARGE=6;
	/**
	 * マイリストが少ない順
	 */
	public static final int MYLIST_SMALL=7;
	/**
	 * 投稿日時が新しい順
	 */
	public static final int DATE_NEW=8;
	/**
	 * 投稿日時が古い順
	 */
	public static final int DATE_OLD=9;
	/**
	 * 再生時間が長い順
	 */
	public static final int TIME_LONG=10;
	/**
	 * 再生時間が短い順
	 */
	public static final int TIME_SHORT=11;
}
