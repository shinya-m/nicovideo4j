package http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author shinya-m
 *
 */
public class ConnectionUtil {

	private static HttpURLConnection con;
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static URLConnection getConnection(String url) throws IOException{
		URL u=new URL(url);
		con=(HttpURLConnection)u.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		
		//ユーザーエージェントをChromeに偽装
		con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.X.Y.Z Safari/525.13.");
		con.connect();
		return con;
	}
	public static void close(){
		if(con!=null){
			con.disconnect();
		}
	}
}
