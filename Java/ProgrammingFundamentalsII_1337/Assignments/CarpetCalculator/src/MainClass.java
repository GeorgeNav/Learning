//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class MainClass {
	public static void main(String[] args) {
		double length = 0, width = 0, area = 0, price = 0;
		RoomDimension dimension = new RoomDimension();
		RoomCarpet carpet = new RoomCarpet();
		Scanner keyboard = new Scanner(System.in);
		boolean SENTINEL = false;
		
		//Retrieves input for length and width in MainClass
		System.out.println("This is the Carpet Calculator!" + "\n");
		
		//Gathers correct length input of 0<value
		while(SENTINEL == false) {
			System.out.print("Enter length of Carpet: ");
			length = keyboard.nextDouble();
			System.out.print("Enter width of Carpet: ");
			width = keyboard.nextDouble();
			if(length>0 && width>0) {
				SENTINEL = true;
			} else {
				System.out.println("ERROR: Length, width, or both has values that are not supported. Try to enter them again more than 0 this time." + "\n");
				SENTINEL = false;
			}
		} SENTINEL = false;
		
		//Saves length and width into 'dimension' object (RoomDimension original class)
		dimension.RoomDimension(length,width);
		//Displays area with RoomDimension 'dimension' object method
		System.out.println(dimension.toString() + "\n");
		
		//Retrieves input for price in USD $
		while(SENTINEL == false) {
			System.out.print("Enter the $ amount per sq/ft: ");
			price = keyboard.nextDouble();
			if(price>0) {
				SENTINEL = true;
			} else {
				System.out.println("ERROR: Price value is not supported. Try to enter it again more than 0 this time." + "\n");
				SENTINEL = false;
			}
		} SENTINEL = false;
		
		//Sends 'dimension' object to RoomCarpet as well as price
		carpet.RoomCarpet(dimension,price);
		//Displays total cost with RoomCarpet 'carpet' object method
		System.out.println(carpet.toString());
	}
}
