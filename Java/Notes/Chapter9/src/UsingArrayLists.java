//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;
//Allows for ArrayList class for object variables (not primitive)
import java.util.ArrayList;

public class UsingArrayLists {
	public static void main() {
		String option = null;
		do {
			option = JOptionPane.showInputDialog("Enter a choice, (-1) to exit: " + "\n"
					+ "1) ArrayListTest" + "\n");
			switch(Integer.parseInt(option)) {
				case 1:
					ArrayListTest();
				default:
					System.out.println("program is finished");
					option = "-1";
					break;
			}
		} while (Integer.parseInt(option) != (-1));
	}
	static void ArrayListTest() {
		final int arrIndex = 10;
		//Creates an array for type Integer reference variables
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		//Adds reference variable myInt1(5) to beginning of ArrayList (subscript 0) and myInt2 (su
		Integer myInt1 = 5, myInt2 = 8;
		listInt.add(myInt1);
		listInt.add(myInt2);
		System.out.println(listInt.toArray()[listInt.toArray().length-1]);
	}
}
