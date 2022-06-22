package javatask1;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Pdf extends JavaTask1 {

	public void example() throws Exception {

		// String word = "TestNG, Cucumber, Junit, IDE used: Eclipse, Visual Studio
		// Code, Selen. JIRA and,C";
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		System.out.println(word);

		String word1 = word.toLowerCase();

		PDDocument docs = PDDocument.load(new File(path));
		PDFTextStripper pdfdata = new PDFTextStripper();

		String pdftext = pdfdata.getText(docs);
		System.out.println(pdftext);

		String caseInsensitive = pdftext.toLowerCase();

		Set<String> keywords = new HashSet<String>();

		for (String s : word1.split("\\W")) {
			System.out.println(s);
			if (s.length() >= 1) {
				keywords.add(s);
				// System.out.println("Total :" +keywords.size());
			}
		}

		Set<String> mainWordsToFind = new HashSet(keywords);
		System.out.println("Total Words , " + mainWordsToFind);
		System.out.println(mainWordsToFind.size());

		for (String w : caseInsensitive.split("\\W")) {

			if (w.length() > 1) {
				mainWordsToFind.remove(w);
			}

			// System.out.println(mainWordsToFind);
		}
		double resume_percent = (keywords.size() - mainWordsToFind.size()) / keywords.size() * 100;
		System.out.println("Resume Percentage matching :- " + resume_percent);
	}
}