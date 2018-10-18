//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;

public class Chapter3 {
	public static void main(String[] args) {
	}
}

/*
int x = 0;
Scanner keyboard = new Scanner(System.in);

if (x<1||x>3){
	System.out.println("Enter a freaking number (1-3)");
	x = keyboard.nextInt();
	System.out.println();

	switch (x) {
		case 1:
			System.out.println("The # you chose was 1");
			break;
		case 2:
			System.out.println("The # you chose was 2");
			break;
		case 3:
			System.out.println("The # you chose was 3");
			break;
		default:
			System.out.println("The # you chose was invalid");
			break;
	}			
}

		double sales1 = 12345.67;
		int sales2 = 12;
		//Format the way a number variable is printed
		//(FormatedString, ArgumentList)
		//%f = float or double, %d = int short or long
		//%[flags][width][.precision]conversion
		//flags = ,(comma thousands) 0 (leading zeros) - (left justified)
		System.out.printf("Our sales are %,020.2f for the day." + "\n" + "As well as sales yesterday %20d" + "\n", sales1, sales2);


		String name1 = "George";
		String name2 = "Franklin";
		String name3 = "Jay";
		String name4 = "Ozzy";
		String name5 = "Carmine";
		String name6 = "Dee";
		
		//%s for string
		System.out.printf("%-10s%-10s" + "\n", name1, name2);
		System.out.printf("%-10s%-10s" + "\n", name3, name4);
		System.out.printf("%-10s%-10s" + "\n", name5, name6);
		
		
		//String for graphical interface
		String x = "I am good.", output;
		//Format string in graphical interface rather than console
		output = String.format("Damn %s", x);
		JOptionPane.showMessageDialog(null, output);
*/