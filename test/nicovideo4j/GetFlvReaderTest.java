package nicovideo4j;

import static org.junit.Assert.*;

import java.io.IOException;

import nicovideo4j.util.LoginUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetFlvReaderTest {

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
	public void test() throws IOException {
		GetFlvReader g=new GetFlvReader();
		g.test("sm10393864",LoginUtil.login("toriaezu5@gmail.com","10311988"));
	}

}
