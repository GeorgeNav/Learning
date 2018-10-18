//This program defines and calls a simple method

public class SimpleMethod {
	public static void main(String[] args) {
		//main method display
		System.out.println("Hello from the main method.");
		//main methods display
		displayMessage();
		//main methods display
		System.out.println("Back in the main method.");
	}
	
	//displayMessage method displays a greeting
	public static void displayMessage() {
		System.out.println("Hello from the displayMessage method.");
	}
}
