package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//save all the crawled sites into a plain-text file and also the queue need to be saved separately.
//if in case the program fails:
//the program loads the queue file and starts with the last site in the index file as seed

public class WebCrawlerDemo {
	
	public boolean backupQueue(LinkedList<String> queue){
		File file = new File("queue.idx","w");
		
		FileWriter fw = null;
		try{
			fw = new FileWriter(file);
			for(String s: queue)
				fw.append(s);			
		}catch(IOException ioe){
			return false;
		}		
		
		return true;
	}
	
	public LinkedList<String> buildQueue(){
		//Expected queue file
		//cehck queue.idx exits in the set path
		String queueFile = "queue.idx";
		
		File file = new File(queueFile,"w");
		
		if(file.exists()){
			try{
				LinkedList<String> queue = new LinkedList<String>();
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.ready()){
					queue.add(br.readLine());
				}
				return queue; 
			}
			catch(IOException io){
				return new LinkedList<String>();
				
			}
			
		}
		else{
			return new LinkedList<String>();
		}
	}
	
	public String getTail(File file){
		RandomAccessFile fd = null;
		StringBuilder sb = null;
		try{
			fd = new RandomAccessFile(file,"r");
			long len = fd.length()-1; //this is the length of the file
			sb = new StringBuilder();
			for(long i=len;i>0;i--){
				fd.seek(i);
				char readChar = fd.readChar();
				
				if(readChar != '\n'){
					sb.append(readChar);
				}else break;
			}
			fd.close();
		}catch(IOException ioe){
			return "-1";
		}		
		return sb.reverse().toString();
	}
	
	public void crawler(){
		int count = 0;
		System.setProperty("sun.net.client.defaultConnectTimeout", "500");
		System.setProperty("sun.net.client.defaultReadTimeout", "1000");
		
		
		// seed website
		String seed = "http://www.craiglist.com/";				
		String indexFile = "site.idx";
		
		File fs = new File(indexFile);
		
		//Retreiving the seed
		try{		
			if(!fs.exists()){
//				System.out.println(fs.createNewFile());
				
				FileWriter fw = new FileWriter(fs);
			}else{
				String tail = getTail(fs);
				if(tail.equals("-1")){
					System.err.println("Program wil exit");
					System.exit(0);
				}
				seed = tail;				
			}
		}catch(IOException ie){
			ie.printStackTrace();
			System.err.println("Crawler Stoppperd Working");
			System.err.println("Check Logs to know the reason");
			System.err.println("Crawler will exit");
			
			System.exit(0);
		}
		
		//Retrieving the queue
		
		

		// String s = "http://www.dmoz.org/";

		LinkedList<String> queue = buildQueue();
		queue.add(seed);

		HashSet<String> set = new HashSet<String>();
		set.add(seed);

		// we are applying BFS while crawling the web
		while (!queue.isEmpty()) {

			String v = queue.poll();
			count++;
			
			System.out.println(count + " > Visiting : " + v);

			URL site;

			BufferedReader br;
			try {
				
				FileWriter fw = new FileWriter(fs);
				fw.append(v);
				
				site = new URL(v);
				br = new BufferedReader(new InputStreamReader(site.openStream()));
			} catch (MalformedURLException mue) {
				continue; // ignore the present url at hand
			} catch (IOException ioe) {
				continue; // ignore the present url contents
			}

			String regexp = "http://(\\w+\\.)+(\\w+)";
			Pattern pattern = Pattern.compile(regexp);

			Matcher matcher;

			try {
				for (Object x : br.lines().toArray()) {
					matcher = pattern.matcher(x.toString());
					while (matcher.find()) {
						String w = matcher.group();
						if (!set.contains(w)) {
							queue.add(w);
							set.add(w);
						}
					}
				}
			} catch (UncheckedIOException uioe) {
				if(!backupQueue(queue))
				{
					//report in log
				}
				//we cannot continue at this stage;
				//we exit
				System.exit(0);
				//continue;
			}
		}
	}
	

	public static void main(String[] args) {
		
		WebCrawlerDemo demo = new WebCrawlerDemo();
		demo.crawler();
	}
}
