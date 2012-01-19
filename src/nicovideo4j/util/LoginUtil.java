package nicovideo4j.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import http.ConnectionUtil;

/**
 * @author shinya-m
 *
 */
public class LoginUtil {

	private static final String loginUrl="https://secure.nicovideo.jp/secure/login?site=niconico";
	
	/**
	 * @param mail
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public static String login(String mail,String password) throws IOException{
		HttpURLConnection con=(HttpURLConnection)ConnectionUtil.getConnection(loginUrl);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
		writer.write("mail="+URLEncoder.encode(mail,"UTF-8"));
		writer.write("&password=" + URLEncoder.encode(password,"UTF-8"));
		writer.flush();
		writer.close();
		String cookie = con.getHeaderField("Set-Cookie");
		con.disconnect();
		return cookie;
	}
}
