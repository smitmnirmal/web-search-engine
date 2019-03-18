package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.*;

public class main {
	
	public static void main(String[] args) throws IOException {
		
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
    		}
    	}
    	
    	
		
	}
}
