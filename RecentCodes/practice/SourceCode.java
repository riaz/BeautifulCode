package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class SourceCode {

	public static void main(String[] args)  throws MalformedURLException,IOException{
		String source = "http://01knapsack.com";
		
		URL site = new URL(source);
		BufferedReader br = new BufferedReader(new InputStreamReader(site.openStream()));
		
		for(Object s: br.lines().toArray()){
			//check for a link in each line and report
		}
		
	}

}
