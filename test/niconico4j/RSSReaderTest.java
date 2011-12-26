package niconico4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import http.ConnectionUtil;

import nicovideo4j.RSSInfo;
import nicovideo4j.RSSReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class RSSReaderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ParserConfigurationException, SAXException {
		List<RSSInfo> list=RSSReader.getList("http://www.nicovideo.jp/ranking/daily");
		for(int i=0;i<list.size();i++){
			RSSInfo v=list.get(i);
			System.out.println("title	: "+v.getTitle());
			System.out.println("link	: "+v.getLink());
			System.out.println("guid	: "+v.getGuid());
			System.out.println("pubDate	: "+v.getPubDate());
			System.out.println("description	: "+v.getDescription());
			System.out.println("thumbnail	: "+v.getThumbnailUrl());
			System.out.println("length	: "+v.getLength());
			System.out.println("date	: "+v.getDate());
			System.out.println("total view	: "+v.getTotalView());
			System.out.println("total res	: "+v.getTotalRes());
			System.out.println("total mylist	: "+v.getTotalMyList());
			System.out.println("daily view	: "+v.getDailyView());
			System.out.println("daily res	: "+v.getDailyRes());
			System.out.println("daily mylist	: "+v.getDailyMyList());
		}
	}

}
