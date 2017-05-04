package FastTextContent;

import java.util.Hashtable;

public class Result {
	Hashtable<String, Word> listResult;
	private static Result res;
	
	private Result(){
		listResult = new Hashtable<String, Word>();
	}
	
	public static Result getInstance(){
		if (res == null){
			res = new Result();
		}
		return res;
	}
	
}