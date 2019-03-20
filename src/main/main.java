package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.jsoup.*;

public class main {
	
	public static void main(String[] args) throws IOException {
		Map<String, WordMap> wordMapping = new HashMap();
		
		File folder = new File("E:\\Downloads\\Windsor Sem 1\\Advanced Computing Concepts\\Data Files\\W3C Web Pages");
    	File[] listOfFiles = folder.listFiles();
		
    	for(int i=0; i < listOfFiles.length; i++) {
    		if(listOfFiles[i].isFile()) {
    			 File myFile = new File("E:\\Downloads\\Windsor Sem 1\\Advanced Computing Concepts\\Data Files\\W3C Web Pages\\"+listOfFiles[i].getName());
    			 org.jsoup.nodes.Document doc = Jsoup.parse(myFile, "UTF-8");
    			 String text = doc.text();
    			 PrintWriter out = new PrintWriter("E:\\Downloads\\Windsor Sem 1\\Advanced Computing Concepts\\Data Files\\W3C Web Pages\\Text\\"+ listOfFiles[i].getName() +".txt");
    			 out.println(text);
    			 out.close();
    			 
    			 StringTokenizer tkob= new StringTokenizer(text, " , .;:©®â'\"&!?-_\n\t[]“”{}()@#$%^*/+-=<>\\|    ");
    		     
    		     while(tkob.hasMoreTokens()) {
    		     	String key = tkob.nextToken();
					/*
					 * if(wordMapping.containsKey(key)) { //wordMapping.put(key,
					 * wordMapping.get(key)+1); wordMapping.replace(key, wordMapping.get(key)+1); }
					 */
    		     	WordMap word ;
    		     	if(wordMapping.containsKey(key)) {
    		     		word = wordMapping.get(key);
    		     		int count = word.getUrlWordCount(listOfFiles[i].getName());
    		     		word.setUrlWordCount(listOfFiles[i].getName());
    		     	}
    		     	wordMapping.putIfAbsent(key, new WordMap(1, listOfFiles[i].getName(), 1));
    		     }
    			 
    		}
    	}
    	WordMap word ;
    	for (Map.Entry<String, WordMap> entry : wordMapping.entrySet()) {
    		word = entry.getValue();
    	    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getHashMap());
    	}
   
		
	}
}
