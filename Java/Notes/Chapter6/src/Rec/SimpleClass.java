package Rec;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class SimpleClass {
	public static void main(String[] args) {
		
		//Create a Rectangle object
		//This object creates instance fields&variables
		//assigns the object's address to the box variable without passing any values
		Rectangle box = new Rectangle();
		
		//(1.0, 5.0)This passes the value 1.0 and 5.0 to it's constructor, and assigns the object's address to the box variable
		//Rectangle box = new Rectangle(1.0, 5.0);

		
		//Indicate what you are doing
		System.out.println("Sending the value 10.0 to the setLength method.");
		
		//Call the box object's setLength method
		box.setLength(10.0);
		//Call the box object's setLength method
		box.setWidth(20.0);
		
		//Use methods in Rectangle that returns a value from this outside class
		System.out.printf("Length stored: %.2f" + "\n", box.getLength());
		System.out.printf("Width stored: %.2f" + "\n", box.getWidth());
		System.out.printf("Area stored: %.2f" + "\n", box.getArea());
		
		//Indicate we are done
		System.out.println("Done.");
	}
}
