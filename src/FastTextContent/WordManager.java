package FastTextContent;

import java.util.ArrayList;

public class WordManager {
	private String text;
	public ArrayList <String> wordList;
	
	
	public void splitWords(){
		String varText = this.text;
		String[] textList = varText.split(" ");
		for (int i=0; i<textList.length; i++){
			wordList.add(textList[i]);
		}
	}
	
	public void setArrayList(){
		splitWords();
		SearchManager searchMan = new SearchManager();
		searchMan.currentSearch = this.wordList;
		searchMan.createThread();
	}
	
	public WordManager(){
		this.wordList = new ArrayList<String>();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
