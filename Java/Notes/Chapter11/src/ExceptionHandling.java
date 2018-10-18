//Display array without for loop
import java.util.Arrays;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class ExceptionHandling {
	public static void main(String[] args) {
		File a;
		String[] arr = {"", "", "", ""};
		String error = "";

		try {
			for(int i=0; i<=arr.length; i++) {
				arr[i] = "wow";
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//Shows exception and array value that created error
			error = e.toString();
			System.out.println(error);
			
			//Shows only array value that created error
			error = e.getMessage();
			System.out.println(error);
		} finally { //finally happens even if there is not catch clause or exception thrown
			System.out.println("final");
		}

		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
