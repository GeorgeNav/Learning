package ArrayIntro;
//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class Arrays {
	public static void main(String[] args) {
		final int EMPLOYEES = 3;
		int[] hours; //Declares a reference variable
		hours = new int[EMPLOYEES]; //hours array is created with EMPLOYEES (6) for the array size declarator
		int[] simpleArr = {7,8,9,2,28,100,7}; //Declares reference variable, sets size to 3, and initializes each element with an int value
		double[] wow;
		int count = 0;
		int highestIndex = 0;
	
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the hours worked by " + EMPLOYEES + " employees.");
		
		//loop that gets the hours worked for all employees in array
		for(int index = 0; index<EMPLOYEES; index++) {
			System.out.print("Employee " + (index+1) + ": ");
			hours[index] = keyboard.nextInt();
		}
		
		//Displays hours worked by each employee
		System.out.println("The hours you entered are: ");
		for(int index = 0; index<EMPLOYEES; index++) {
			System.out.println("Employee " + (index+1) + ": " + hours[index]);
		}

		//Tests array simpleArr
		for(int index = 0; index<simpleArr.length;index++) {
			System.out.println("Element " + (index) + " of simpleArr: " + simpleArr[index]);
		}
		
		//Tests array using a more efficient style of for loop
		for(int index : simpleArr) {
			System.out.print("Element " + count + " of simpleArr: ");
			System.out.println(index);
			count++;
		}
		
		//Find the highest number and element index in simpleArr
		for(int index = 1; index<simpleArr.length; index++) {
			if(simpleArr[index]>simpleArr[(index-1)]) {
				highestIndex = index;
			}
		}
		System.out.print("Highest value in simpleArr: " + simpleArr[highestIndex] + ", ");
		System.out.println("Index: " + highestIndex + " (0-" + (simpleArr.length-1) + ")");
	
		//Return array reference to another array variable
		wow = getArr();
		for(int index = 0; index<wow.length;index++) {
			System.out.println("Element " + (index) + " of wow array: " + wow[index]);
		}
	}
	
	//Returns array reference hashCode
	public static double[] getArr(){
		double[] tempArr = {7,3,1};
		return tempArr;
	}
}
