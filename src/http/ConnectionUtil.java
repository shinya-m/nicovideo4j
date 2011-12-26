package http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionUtil {

	public static URLConnection getConnection(String url) throws IOException{
		URL u=new URL(url);
		HttpURLConnection con=(HttpURLConnection)u.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		return con;
	}
}
