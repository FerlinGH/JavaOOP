package net.ukr.grygorenko_d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

	public static File getPage(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		File html = new File("page.html");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				PrintWriter pw = new PrintWriter(html)) {
			StringBuilder sb = new StringBuilder();
			String text = "";
			while ((text = br.readLine()) != null) {
				sb.append(text).append(System.lineSeparator());
			}
			pw.print(sb.toString());
		}

		return html;
	}

	public static void extractLinks(File page) throws IOException{
		File result = new File("links.txt");
		result.createNewFile();
		try (BufferedReader br = new BufferedReader(new FileReader(page));
				PrintWriter pw = new PrintWriter(result)){
			String str = null;
			while((str = br.readLine())!=null){
				String[] words = str.split(" ");
				for (String word : words) {
					int[] indexes = null;
					if((indexes = testString(word))!= null){
						pw.println(word.substring(indexes[0] + 1, indexes[1]));
						indexes = null;
					}
				}
				
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	private static int[] testString(String testString) {
		Pattern p = Pattern.compile("^(href|src)=.+\".*");
		Matcher m = p.matcher(testString);
		if (m.find()) {
			int[] limits = { testString.indexOf("\""), testString.lastIndexOf("\"") };
			return limits;
		} else {
			return null;
		}
	}

}
