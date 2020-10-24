import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
	
	private static String keyword = "";		//get keyword
	private static String text = "";
		
	public Search(String k, String t) {		//constructor
		keyword = k;
		text = t;
		
		System.out.println("Keyword is: " + keyword);
		System.out.println("Text is: " + text);
	}

	//return positions of each word
	public static ArrayList<Integer> find(){
		ArrayList<Integer> positions = new ArrayList<Integer>();	
		
		String keywordInc = "(\\s|\\(|\\[|\\'|\\\")" + keyword + "(\\s|\\.|\\?|\\!|\\)|\\]|\\,|\\\"|\\')" ;		//convert keyword to REGEX expression
		//note this keyword also includes the spaces before and after the word as well as the following characters: 
		// '[' , ']' , '(' , ')' , '.' , '!' , '?' ' " ' , ''',  
		//(\s|\(|\[|\'|\")keyword(\s|\.|\?|\!|\)|\]|\,|\"|\')
		System.out.println(keywordInc);
		
		//***must replace with keywordInc
		Pattern keywordPattern1 = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
	    Matcher matcher1 = keywordPattern1.matcher(text);
	    
		while(matcher1.find()) {
			positions.add(matcher1.start());	//add all the starting positions of the text
		}
			
	  			
		for(int i: positions) {
			System.out.println(i);
		}
		
		return positions;
	}
	
	public static void setKeyword(String k) {
		keyword = k;
	}
	
	public static void setText(String t) {
		text = t;
	}

}
