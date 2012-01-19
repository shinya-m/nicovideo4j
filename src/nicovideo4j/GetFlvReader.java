package nicovideo4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetFlvReader {

	public void test(String id,String cookie) throws IOException{
		URL url=new URL("http://flapi.nicovideo.jp/api/getflv/"+id);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestProperty("Cookie",cookie);
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.connect();
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String s;
		while((s=reader.readLine())!=null){
			System.out.println(s);
		}
		con.disconnect();
	}
}
