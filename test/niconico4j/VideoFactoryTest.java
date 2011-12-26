package niconico4j;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import nicovideo4j.NicoVideo;
import nicovideo4j.VideoFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class VideoFactoryTest {

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
		NicoVideo v=VideoFactory.getVideo("sm16467362");
		System.out.println(v.isStatus());
		System.out.println(v.getId());
		System.out.println(v.getTitle());
		System.out.println(v.getDescription());
		System.out.println(v.getThumbnailUrl());
		System.out.println(v.getFirstRetrive());
		System.out.println(v.getLength());
		System.out.println(v.getMovieType());
		System.out.println(v.getSizeHigh());
		System.out.println(v.getSizeLow());
		System.out.println(v.getViewCounter());
		System.out.println(v.getCommentNum());
		System.out.println(v.getMyListCounter());
		System.out.println(v.getLastResBody());
		System.out.println(v.getWatchUrl());
		System.out.println(v.getThumbType());
		System.out.println(v.getEmbeddable());
		System.out.println(v.getNoLivePlay());
		System.out.println(v.getTags());
		System.out.println(v.getUserId());
	}

}
