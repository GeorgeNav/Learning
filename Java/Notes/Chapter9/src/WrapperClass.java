//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class WrapperClass {
	public static void main() {		
		//Primitive integer
		int i = 12;
		//Boxing primitive integer variable into 'Wrapper Class'
		Integer iObj = new Integer(i);
		int j = iObj.intValue();
		//Displays integer after unboxing a line above this line
		JOptionPane.showMessageDialog(null, j);

		//Primitive character
		char ch1 = '\t';
		Character char1 = new Character(ch1);
		char ch2 = char1;
		//Boxing primitive character variable into 'Wrapper Class'
		//Displays character after unboxing a line above this line
		JOptionPane.showMessageDialog(null, ch2);
		JOptionPane.showMessageDialog(null, "isWhiteSpace?: " + Character.isWhitespace(ch2));		
	}
}
