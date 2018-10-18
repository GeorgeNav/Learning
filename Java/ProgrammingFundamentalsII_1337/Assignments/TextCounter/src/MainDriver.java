//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class MainDriver {
	public static void main(String[] args) {
		TextCounter textCounter = new TextCounter();
		String path;
		int SENTINEL = (-1);

		JOptionPane.showMessageDialog(null, "This program gathers various file information" + "\n" +
                                            "--------  Created by George Navarro  --------");
		//Finds file path for input later
		do {
			//Enter file path, if not correct try again after loop resets
			path = JOptionPane.showInputDialog("Enter the path of your .txt file" + "\n" + "Example: " + "C:\\foldername\\filename.txt");
			
			//Checks if file exists, if yes then uses it, if no repeat to start of loop
			if (textCounter.getFile(path)!=null) {
				JOptionPane.showMessageDialog(null, "File was Found!");
				SENTINEL = 1;
			} else {
				JOptionPane.showMessageDialog(null, "File was Found :( Please enter another file directory including file name (filename.txt)");
			}
		} while (SENTINEL==(-1));

		//Outputs amount of lines, words, sentences, and paragraphs in document
		JOptionPane.showMessageDialog(null, "Lines: "      + textCounter.getNumLines()      + "\n" +
											"Words: "      + textCounter.getNumWords()      + "\n" +
											"Sentences: "  + textCounter.getNumSentences()  + "\n" +
											"Paragraphs: " + textCounter.getNumParagraphs() + "\n");
	}
}
