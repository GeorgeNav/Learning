//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;

public class Chapter2 {
	//Method
	//Any variables inside this method cannot be accessed by outside methods
	public static void main(String[] args) {
		
		System.exit(0);
	}
}

/*
double regularWages;
double basePay = 25;
double regularHours = 40;
double overtimeWages;
double overtimePay = 37.5;
double overtimeHours = 10;
double totalWages;

regularWages = basePay * regularHours;
overtimeWages = overtimePay * overtimeHours;
totalWages = regularWages + overtimeWages;
System.out.println("Wages for this week are $" + totalWages);

double result;

//Math.pow(x,x) can only be used with double type integers
result = Math.pow(4, 2);

//Value variable casted
int value = 7;
System.out.println((double)value);

final double INTEREST_RATE = 0.0324;
System.out.println(INTEREST_RATE);

//Constant Variable
final double INTEREST_RATE = 0.0324;
System.out.println(INTEREST_RATE);

//Declare a string named 'name'
String name = "HERMAN";
String bigName;
String smallName;
int stringSize;
char letter;
		
//name.charAt(x) = character in element slot
letter = name.charAt(3);
System.out.println("char variable" + " has \'" + letter + "\'.");
		
//name.length() = number of characters in name
stringSize = name.length();
System.out.println(name + " has " + stringSize + " characters.");
		
//name.toLowerCase() = lower case string
smallName = name.toLowerCase();
System.out.println("smallName String says " + "\'" + smallName + "\'");
		
//name.toUpperCase() = upper case string
bigName = name.toUpperCase();
System.out.println("bigName String says " + "\'" + bigName + "\'");
		
//Standard Input Device
//Scanner is a class, keyboard is a class type variable that can reference objects within Scanner
Scanner scan = new Scanner(System.in);
System.out.println("Enter an integer value: ");
		
//Get int data type input from keyboard
int number = scan.nextInt();
		
System.out.println("number: " + number);

//Standard Input Device
//Scanner is a class, keyboard is a class type variable that can reference objects within Scanner
Scanner keyboard1 = new Scanner(System.in);
System.out.print("Enter an int value: ");
				
//Get int data type input from keyboard
int number = keyboard1.nextInt();		
System.out.println("number: " + number);
		
//Get int data type input from keyboard
Scanner keyboard2 = new Scanner(System.in);
System.out.print("Enter a String: ");
String inputText = keyboard2.nextLine();
System.out.println("String: " + inputText);

//Dialog box (graphical windows) with OK button, requires = import javax.swing.JOptionPane;
JOptionPane.showMessageDialog(null, "Hello World");

//Input Dialog box for string name
String name = JOptionPane.showInputDialog(null, "Enter your name");
System.out.println("Name: " + name);
*/