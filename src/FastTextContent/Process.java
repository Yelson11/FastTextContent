package FastTextContent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.*;
import javax.naming.directory.SearchResult;

public class Process extends Thread{
	public Process(String msg){
		super(msg);
	}
	
	public void run(){
		try {
			searchResults(this.getName());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR");
		}
	}
	
	public void searchResults(String name)throws IOException{
		String urlLink = "http://www.google.com/search?q=" + name;
		System.out.println("Ejecuta el hilo :" + name);
		URL url = new URL (urlLink);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.addRequestProperty("User-Agent", "Chrome");
		conn.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		
		while((line = in.readLine()) != null){
			sb.append(line);
		}
		in.close();
		Word word = new Word(name,300, sb.toString());
		Result res = Result.getInstance();
		res.listResult.put(name, word);
		System.out.println(name + ": " + sb.toString());
		
	}

}
