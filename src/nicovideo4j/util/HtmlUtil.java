package nicovideo4j.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HtmlUtil {

	public static InputStream formHtml(InputStream is) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
		String s;
		StringBuilder sb=new StringBuilder(140000);
		while((s=br.readLine())!=null){
			sb.append(changeEscapeSequence(s));
			//sb.append("\n");
		}
		//System.out.println(sb.length());
		br.close();
		return new ByteArrayInputStream(sb.toString().getBytes());
	}
	/**
	 * エスケープシーケンスの変換処理
	 * @param s
	 * @return
	 */
	private static String changeEscapeSequence(String s){
		return s.replaceAll("&#039;","'")
				.replaceAll("&lt;","<")
				.replaceAll("&gt;",">")
				.replaceAll("&amp;","&")
				.replaceAll("&nbsp;"," ")
				.replaceAll("&quot;","\"");
	}
}
