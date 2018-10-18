//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;

public class Chapter4 {
	public static void main (String[] args) {
		float[] x = {4, 8, 14};
		//running total variable
		float total = 0;
		
		//Element size controlled for loop (save a squared value in element)
		for (int index = 0; index < x.length; ++index){
			x[index] *= x[index];
			total += x[index];
		}
		
		for (int index = 0; index < x.length; ++index){
			System.out.println("Element " + index + " is = " + x[index]);
		}
		
		System.out.println("Total: " + total);
	}
}