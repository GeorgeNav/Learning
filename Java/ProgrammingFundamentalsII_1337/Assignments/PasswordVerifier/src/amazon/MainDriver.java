package amazon;

//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class MainDriver {
	public static void main(String[] args) {
		PasswordVerifier pv = new PasswordVerifier();
		String passwordInput = null;
		boolean validPassword = false;
		do {
			passwordInput = JOptionPane.showInputDialog(null, "Enter a valid password" + "\n" + "It must be 6 characters long, have at least 1 lower case and upper case character, and 1 number (int)");
			validPassword = pv.isValid(passwordInput);
			
			if(validPassword==true){
				JOptionPane.showMessageDialog(null, "Your password has been accepted.");
			} else {
				JOptionPane.showMessageDialog(null, "INVALID PASSWORD...Please try again." + "\n"
						+ "Do not include any spaces, tabs, or any special characters such as... " + Arrays.toString(pv.SPECIAL_CHARACTERS));
			}
		} while (validPassword==false);
	}
}
