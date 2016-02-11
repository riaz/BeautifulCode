package practice;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class RegexTestHarness {
	public static void main(String[] args){
		Console console = System.console();
		
		
		if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
		
		Pattern pattern = Pattern.compile(console.readLine("%n Enter the patter to match"));
		Matcher matcher = pattern.matcher(console.readLine("Enter the string to match against"));
		
		boolean found = false;
		while(matcher.find()){
			console.format("I found the text" +
					"\"%s\" starting at "+
					"\"%d\" index and ending at \"%d\" index.",
					matcher.group(),
					matcher.start(),
					matcher.end());
			found = true;
		}
		
		if(!found){
			System.out.println("No pattern was found");
		}
	}
}
