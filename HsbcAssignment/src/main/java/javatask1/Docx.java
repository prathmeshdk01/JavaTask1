package javatask1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Docx extends JavaTask1 {

	public void example1() throws Exception {

		FileInputStream fis = new FileInputStream(path);

		XWPFDocument doc = new XWPFDocument(OPCPackage.open(fis));
		XWPFWordExtractor extractor = new XWPFWordExtractor(doc);

		String fileData = extractor.getText();
		String caseInsense = fileData.toLowerCase();

		if (fileData.length() > 1) {

			Scanner sc = new Scanner(System.in);

			String word = sc.nextLine();
			System.out.println(word);

			String word1 = word.toLowerCase();

			Set<String> mainWords = new HashSet();
			for (String s : word1.split("\\W")) {
				if (s.length() >= 1) {
					mainWords.add(s);
				}
			}

			Set<String> mainWordsToFind = new HashSet(mainWords);

			for (String w : caseInsense.split("\\W")) {
				if (w.length() > 1) {
					mainWordsToFind.remove(w);
				}
			}
			double resume_percent = (mainWords.size() - mainWordsToFind.size()) / mainWords.size() * 100;
			System.out.println("Resume Percentage matching :-" + resume_percent);
		}
		else {
			System.out.println("File is empty");
		}
	}
}