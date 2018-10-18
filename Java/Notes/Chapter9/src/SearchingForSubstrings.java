//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class SearchingForSubstrings {
	public static void main() {
		String str = "Four score and seven years ago";
		String option  = null;
		do {
			option = JOptionPane.showInputDialog("Enter a choice, (-1) to exit: " + "\n"
												+ "1) startsWithTest" + "\n"
												+ "2) endsWithTest" + "\n"
												+ "3) regionMatchesTest" + "\n"
												+ "4) indexOfTest" + "\n"
												+ "5) lasIndexOfTest: " + "\n"
												+ "6) substringTest" + "\n"
												+ "7) getCharsTest" + "\n"
												+ "8) modifiedStringMethodsTest" + "\n"
												+ "9) valueOfTest: " + "\n");
			switch (Integer.parseInt(option)) {
				case 1:
					startsWithTest(str);
					break;
				case 2:
					endsWithTest(str);
					break;
				case 3:
					regionMatchesTest(str);
					break;
				case 4:
					indexOfTest(str);
					break;
				case 5:
					lastIndexOfTest(str);
					break;
				case 6:
					substringTest(str);
					break;
				case 7:
					getCharsTest(str);
				case 8:
					modifiedStringMethodsTest(str);
				case 9:
					valueOfTest();
				default:
					System.out.println("program is finished");
					option = "-1";
					break;
			}
		} while (Integer.parseInt(option) != (-1));
	}
	static void startsWithTest(String str) { System.out.println("startsWithTest: ");
		if(str.startsWith("Four")) {
			System.out.println("The string starts with " + str + ": " + true + "\n");
		} else {
			System.out.println("The string does not start with " + str + ": " + false + "\n");
		}
	}
	static void endsWithTest(String str) { System.out.println("endsWithTest: ");
		if(str.endsWith("ago")) {
			System.out.println("The string ends with " + str + ": " + true + "\n");
		} else {
			System.out.println("The string does not ends with " + str + ": " + false + "\n");
		}
	}
	static void regionMatchesTest(String str) { System.out.println("regionMatchesTest: ");
		/* Page 569
		This method returns true if a specified
		region of the calling string matches a
		specified region of the string passed into
		str. The start parameter indicates the
		starting position of the region within the
		calling string. The start2 parameter
		indicates the starting position of the
		region within str. The n parameter
		indicates the number of characters in
		both regions. ignoreCase if true ignores case.
		*/
	
		String temp = "Fo";
		//   (int start, String str,int start2,int n)
		//or (Boolean ignoreCase, int start, String str, int start2, int n)
		if(str.regionMatches(true, 0, temp, 0, 2)) {
			System.out.println(temp + " was found in str" + "\n");
		} else {
			System.out.println(temp + " was not found in str" + "\n");
		}
	}
	static void indexOfTest(String str) { System.out.println("indexOfTest: ");
		char tempChar = 'o';
		String tempString = "score";
		int startIndex = 3;
		//If returns -1, not found
		System.out.println("String element index where '" + tempChar + "' is: " + str.indexOf(tempChar));
		System.out.println("String element index where '" + tempChar + "' is, searching from index "+ startIndex + ": " + str.indexOf(tempChar, startIndex));
		System.out.println("String element index where '" + tempString + "' is: " + str.indexOf(tempString));
		System.out.println("String element index where '" + tempString + "' is, searching from index "+ startIndex + ": " + str.indexOf(tempString, startIndex));
	}
	static void lastIndexOfTest(String str) { System.out.println("lasIndexOfTest: ");
	//Last occurrence is returned of character or string
	char tempChar = 'o';
	String tempString = "score";
	int startIndex = str.length();
	//If returns -1, not found
	//starts from integer value searching backwards from there
	System.out.println("String element index where '" + tempChar + "' is: " + str.lastIndexOf(tempChar));
	System.out.println("String element index where '" + tempChar + "' is, searching from index "+ startIndex + ": " + str.lastIndexOf(tempChar, startIndex));
	System.out.println("String element index where '" + tempString + "' is: " + str.lastIndexOf(tempString));
	System.out.println("String element index where '" + tempString + "' is, searching from index "+ startIndex + ": " + str.lastIndexOf(tempString, startIndex));
	}
	static void substringTest(String str) { System.out.println("substringTest: ");
		//Returns copy of string from (int start) or (int start, int end)
		int startIndex = 5;
		int endIndex = str.length()-10;
		System.out.println("Extracts substring from element index " + startIndex + " is: " + str.substring(startIndex));
		System.out.println("Extracts substring from element index " + startIndex + " to " + endIndex + " is: " + str.substring(startIndex, endIndex));
	}
	static void getCharsTest(String str) { System.out.println("getCharsTest: ");
	//Returns copy of char array with (int start, int end, char[] array, int arrayString) or str.toCharArray()
	int startIndex = 5;
	int endIndex = str.length()-10;
	char[] charArr1 = new char[str.length()];
		str.getChars(startIndex, endIndex, charArr1, 0);
	char[] charArr2 = str.toCharArray();

	System.out.print("Extracts characters from element index " + startIndex + " to " + endIndex + " with getChars() method: ");
	System.out.println(Arrays.toString(charArr1));
	System.out.print("Extracts all characters from String with toCharArray() method: ");
	System.out.println(Arrays.toString(charArr2));
	}
	static void modifiedStringMethodsTest(String str) { System.out.println("modifiedStringMethodsTests: ");
		String tempString = "Aberham said: ";
		//Adds str to end of tempString
		String fullSentence = tempString.concat(str);
		System.out.println(fullSentence);
		
		//Replaces old char with new one
		char oldChar = 'o';
		char newChar = 'O';
		String fullSentenceReplace = str.replace(oldChar, newChar);
		System.out.println(fullSentenceReplace);
		
		//trims String (removes whitespace that occurs at the start and end, not middle)
		String whitespaceString = "   Hello   ";
		System.out.println(whitespaceString.trim());
	}
	static void valueOfTest() { System.out.println("valueOfTest: ");
		boolean b = true;
		char [] letters = { 'a', 'b', 'c', 'd', 'e' };
		double d = 2.4981567;
		int i = 7;
		//Each returns a string version of input
		System.out.println("b: " + String.valueOf(b));
		System.out.println("letters: " + String.valueOf(letters));
		//(char[] array, int startingSubscript, int endingSubscript)
		System.out.println(String.valueOf(letters, 1, 3));
		System.out.println(String.valueOf(d));
		System.out.println(String.valueOf(i));
	}
}
