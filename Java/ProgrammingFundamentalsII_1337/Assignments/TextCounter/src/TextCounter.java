//Need this utility class for input
import java.util.Scanner;
//File Input and Output
import java.io.*;

public class TextCounter {
	//Class variables
	private File textFile;
	private int lineCount, wordCount, sentenceCount, paragraphCount;
	private String foundPath;

	//Constructs object variables
	public void TextCounter(File textFile, int lineCount, int wordCount, int sentenceCount, int paragraphCount, String foundPath) {
		this.textFile = textFile;
		this.lineCount = lineCount;
		this.wordCount = wordCount;
		this.sentenceCount = sentenceCount;
		this.paragraphCount = paragraphCount;
		this.foundPath = foundPath;
	}

	public File getFile(String path) {
		textFile = new File(path);

		//Checks if file path exists
		if(textFile.exists() && path.endsWith(".txt")) {
			System.out.print("Used path to reference file for textFile: ");
			textFile = new File(path);
			foundPath = path;
			return textFile;
		} else {
			System.out.println("Did not use path; method awaiting another input");
			textFile = null;
			return null;
		}
	}

	//Returns number of lines the given file has
	public int getNumLines() {
		Scanner tempLineInput = null;
		System.out.print("\n" + "getNumLines method using foundPath for scanner: ");
		try {
			tempLineInput = new Scanner(getFile(foundPath));			
		} catch(FileNotFoundException e) {
			tempLineInput = null;
		}

		
		//Increments lineCount at each line read that exists
		do {
			tempLineInput.nextLine();
			++lineCount;
		} while(tempLineInput.hasNextLine()==true);
		//last line isn't counted
		++lineCount;
		
		tempLineInput.close();
		return lineCount;
	}

	//Returns number of words the given file has
	public int getNumWords() {
		Scanner tempWordInput = null;
		System.out.print("\n" + "getNumWords method using foundPath for scanner: ");
		try {
			tempWordInput = new Scanner(getFile(foundPath));			
		} catch(FileNotFoundException e) {
			tempWordInput = null;
		}

		//Increments wordCount after each word
		do {
			tempWordInput.next();
			++wordCount;
		} while(tempWordInput.hasNext());
		
		tempWordInput.close();
		return wordCount;
	}

	//Returns number of Sentences
	public int getNumSentences() {
		Scanner tempSentencesInput = null;
		System.out.print("\n" + "getNumSentences method using foundPath for scanner: ");
		try {
			tempSentencesInput = new Scanner(getFile(foundPath));			
		} catch(FileNotFoundException e) {
			tempSentencesInput = null;
		}
		
		StringBuilder sentences = new StringBuilder();
		String[] sentencesArr;
		
		//Increments sentenceCount at each new line and appends to a string builder at each of them
		do{
			sentences.append(tempSentencesInput.nextLine());
			sentenceCount++;
		} while (tempSentencesInput.hasNextLine()==true);
		
		//Cleans string for initialization		
		sentences.toString().replaceAll("\\s+", " ");
		sentencesArr = sentences.toString().split("\\. ");
		
		//'trims' string edges
		for(int index=0; index<sentencesArr.length; index++) {
			sentencesArr[index] = sentencesArr[index].trim();
		}
		
		//Displays sentencesArr strings to system
		System.out.print("SENTENCES ARRAY: " + "\n");
		for(int index=0; index<sentencesArr.length; index++, System.out.print(", ")) {
			System.out.print("[" + sentencesArr[index] + "]");
		} System.out.print("\n\n");
		
		//Uses string array size to initialize sentenceCount to correct amount
		sentenceCount = sentencesArr.length;
		
		tempSentencesInput.close();
		return sentenceCount;
	}

	//Returns number of Paragraphs
	public int getNumParagraphs() {
		Scanner tempParagraphsInput = null;
		System.out.print("getNumParagraphs method using foundPath for scanner: ");
		try {
			tempParagraphsInput = new Scanner(getFile(foundPath));			
		} catch(FileNotFoundException e) {
			tempParagraphsInput = null;
		}

		StringBuilder paragraphs = new StringBuilder();
		String tempString;
		String[] paragraphsArr;

		//Increments paragraphCount at each "" (empty line) and appends string builder with paragraphs separated by ~
		do{
			tempString = tempParagraphsInput.nextLine();
			
			//Checks for blank line
			if(tempString.contentEquals("")) {
				paragraphs.append("~");
				//Do nothing with the next line
				paragraphCount++;
			} else {
				paragraphs.append(tempString);
				paragraphs.append(" ");
			}
		} while (tempParagraphsInput.hasNextLine()==true);
		//Add to count for last paragraph not accounted for
		paragraphCount++;
		
		//Cleans string for initialization
		paragraphs.toString().replaceAll("\\s+", " ");

		//Each element in future array is initialized starting from ~
		paragraphsArr = paragraphs.toString().split("~");
		
		//'trims' string edges
		for(int index=0; index<paragraphsArr.length; index++) {
			paragraphsArr[index] = paragraphsArr[index].trim();
		}

		//Displays sentencesArr strings to system
		System.out.print("PARAGRAPHS ARRAY: " + "\n");
		for(int index=0; index<paragraphsArr.length; index++, System.out.print(", ")) {
			System.out.print("[" + paragraphsArr[index] + "]");
		} System.out.print("\n\n");

		//Uses string array size to initialize sentenceCount to correct amount		
		tempParagraphsInput.close();
		return paragraphCount;
	}
}
