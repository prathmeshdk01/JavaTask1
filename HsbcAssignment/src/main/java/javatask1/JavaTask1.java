package javatask1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class JavaTask1 {

	// static String path = "C:\Users\pratkshi\OneDrive - Capgemini\Desktop\\Demo1.docx";

	static String path = "";

	public static void main(String[] args) throws Exception {

		String s1 = "pdf";
		String s2 = "docx";
		String s3 = "txt";

		Scanner sc = new Scanner(System.in);
		path = sc.nextLine();
		System.out.println("Path for resume file :-" + path);

		String ext1 = FilenameUtils.getExtension(path);
		System.out.println("Resume Format is :-" + ext1);

		if (ext1.equals(s1)) {
			Pdf p = new Pdf();
			p.example();
		}

		else if (ext1.equals(s2)) {
			Docx q = new Docx();
			q.example1();
		}

		else if (ext1.equals(s3)) {
			Txt r = new Txt();
			r.example2();
		}

		else {
			System.out.println("Sorry ");
		}

	}
}