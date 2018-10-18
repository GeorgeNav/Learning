//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

//Stopped at 9.5 page 593(630)
public class StringBuilderClass {
	public static void main() throws NullPointerException {
		String option = null;
		//Initializing StringBuilder Example
		StringBuilder strBuild1 = new StringBuilder(); //16 blank characters
		StringBuilder strBuild2 = new StringBuilder(5); //5 blank characters
		StringBuilder strBuild3 = new StringBuilder("Wow"); //3 characters which says Wow
		do {
			option = JOptionPane.showInputDialog("Enter an option, (-1) to exit" + "\n"
												+ "1) appendTest" + "\n"
												+ "2) insertTest" + "\n"
												+ "3) relplaceTest" + "\n"
												+ "4) deleteTest" + "\n");
			switch(Integer.parseInt(option)){
				case 1:
					appendTest();
					break;
				case 2:
					insertTest();
					break;
				case 3:
					replaceTest();
					break;
				case 4:
					deleteTest();
					break;
				default:
					System.out.println("program is finished");
					break;
			}
		} while(Integer.parseInt(option) != (-1) || option != null);
		System.exit(0);
	}
	static void appendTest() { System.out.println("appendTest: ");
		StringBuilder str = new StringBuilder("Humans have ");
		int numArmsLegs = 4;
		//Adds Integer to end of StringBuilder
		str.append(numArmsLegs);
		//Adds String to end of StringBuilder
		str.append(" Arms and Legs.");
		System.out.println(str.toString());
		
	}
	static void insertTest() { System.out.println("insertTest: ");
		StringBuilder str = new StringBuilder("New City");
		System.out.println("Original string: " + "\n" + str + "\n");
		//Insert String after StringBuilder location (int substring, String str)
		str.insert(4, "York ");
		System.out.println("New string after York was inserted after possition 4: " + "\n" + str + "\n");
	}
	static void replaceTest() { System.out.println("relplaceTest: ");
		String temp = "New York";
		int startInt = 14, endInt = 21;
		StringBuilder str = new StringBuilder("We moved from Chicago to Atlanta");
		System.out.println("Original string: " + "\n" + str + "\n");
		str.replace(startInt, endInt, temp);
		System.out.println("New string after " + temp + " replaced Chicago from possition " + startInt + " to " + endInt + ": " + "\n" + str + "\n");
	}
	static void deleteTest() { System.out.println("deleteTest: ");
		StringBuilder str = new StringBuilder("Wow learning java takes for ever");
		int startInt = str.length()-28;
		int endInt = str.length()-19;
		int charPos = 2;
		char charSet = 'w';
		System.out.println("Original string: " + "\n" + str + "\n");
		str.delete(startInt, endInt);
		System.out.println("String at subscript " + startInt + " through " + endInt + " was deleted: " + "\n" + str + "\n");
		str.deleteCharAt(charPos);
		System.out.println("Character(element) at subscript " + charPos + " was deleted: " + "\n" + str + "\n");
		str.setCharAt(charPos, 'w');
		System.out.println(charSet + " at subscript " + charPos + " was added: " + "\n" + str + "\n");
	}
}
