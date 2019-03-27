//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class CaseConversion {
	public static void main() {
		char ch = 'Y';
		Character char1 = new Character(ch);
		char lowerCase = Character.toLowerCase(char1.charValue());
		JOptionPane.showMessageDialog(null, "Wrapped object variable to lowerCase: " + lowerCase);
		char upperCase = Character.toUpperCase(char1.charValue());
		JOptionPane.showMessageDialog(null, "Wrapped object variable to upperCase: " + upperCase);

		Character white = new Character('\t');
		//Checks for Integer 1-9
		JOptionPane.showMessageDialog(null, "isDigit?: " + white.isDigit(white));
	}
}
