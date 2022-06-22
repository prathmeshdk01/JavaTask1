package javatask1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class Txt extends JavaTask1 {
	
	public void example2() throws Exception {
		
		Scanner sc = new Scanner(System.in);	
	      String word =sc.nextLine();
	      String word1 = word.toLowerCase();
	      //System.out.println(word1);
	      
	      
	      FileInputStream inputStream = new FileInputStream(path);
	      String everything = IOUtils.toString(inputStream);
	      
	      System.out.println(everything);
	      String caseInsensitive = everything.toLowerCase();
	      System.out.println(caseInsensitive);
	     
	      Set<String> keywords = new HashSet<String>();
			

			for (String s : word1.split("\\W"))
			{
				System.out.println(s);
				if (s.length() >= 1) {
					keywords.add(s);
					System.out.println("Total :" +keywords.size());
				}
			}
			Set<String> mainWordsToFind = new HashSet(keywords);
			System.out.println( "Total Words , " +mainWordsToFind);
			System.out.println(mainWordsToFind.size());
			
			for (String w : caseInsensitive.split("\\W")) {

				if (w.length() >=1) {
					mainWordsToFind.remove(w);		
				}
			}	
			double resume_percent = (keywords.size() - mainWordsToFind.size()) / keywords.size()*100;
			System.out.println("Resume Percentage matching :- " +resume_percent);
	}
	      
	}
