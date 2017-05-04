package FastTextContent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

public class SearchManager {
	public ArrayList<String> currentSearch;
	
	public void createThread(){
		
		for (String palabra:currentSearch){
			Thread thread = new Process (palabra);
			thread.start();
		}
		
	}

}
