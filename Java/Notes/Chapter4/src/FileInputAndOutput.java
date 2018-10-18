//Need this utility class for input
import java.util.Scanner;
//Dialog box class
import javax.swing.JOptionPane;
//File Input and Output
import java.io.*;

public class FileInputAndOutput {
	//throws = clause that adds an exception
	//PrintWrither needs IOException to build a file
	//IOException = needed if specified txt file isn't found
	public static void main (String[] args) throws IOException {
		int value = 0;
		Scanner inputOutput = new Scanner(System.in);

		System.out.print("Output to a new file?(1) or Input from existing file to new file?(2): ");
		value = inputOutput.nextInt();
		
		//Output user info to txt file
		if (value==1) {
			String fileName;
			String friendName;
			int numFriends;
			
			//Scanner object for keyboard input
			Scanner keyboard = new Scanner(System.in);
			
			//Get number of friends
			do{
				System.out.print("Number of Friends: ");
				numFriends = keyboard.nextInt();
				if (numFriends<0){
					System.out.println("Invalid # choice");
				}
			}while(numFriends<0);
			//Consume the remaining newline character
			keyboard.nextLine();
	
			//Get fileName
			System.out.print("Enter the fileName: ");
			fileName = keyboard.nextLine();
			
			//Open/Create the file
			// \\ = \ when defining directory
			PrintWriter outputFile = new PrintWriter("C:\\GDRIVE\\PROJECTS\\JAVA\\ProgrammingFundamentalsII_1337\\StartingWithJava\\Chapter4\\txt\\" + fileName);
			
			//Get data and write it to the file
			for (int i = 0; i < numFriends; i++){
				//Get name of friend
				System.out.print("Enter the name of friend " + "number " + (i+1) + ": ");
				friendName = keyboard.nextLine();
				
				//Write the name to that file
				outputFile.println(friendName);
			}
			System.out.println("Data written to the file.");
	
			//Appending more data
			System.out.print("Add another friends name for Appending reasons: ");
			//This references the txt file up to add lines to (Appending, does not open file)
			FileWriter fWriter = new FileWriter(fileName, true);
			friendName = keyboard.nextLine();
			outputFile.println(friendName);
			
			//Close the file
			//outputFile.close();
			
			System.out.println("Data written to the file.");
		}
		
		//Input from pre-existing txt file
		if (value==2) {
			int SENTINEL = 1;
			String fileName;
			Scanner keyboard = new Scanner(System.in);
			File myFile;
			
			//User input for correct file name
			do{
				System.out.print("Enter the name of an existing file for input: ");
				fileName = keyboard.nextLine();
				
				//Binds myFile to this file/non-existent file directory the File variable
				myFile = txtPath(fileName);
				
				if (!myFile.exists()) {
					System.out.print("This file does not exist: ");
					System.out.println("\""+ myFile + ".txt" + "\"");
					
					//Resets File object reference to nothing so Java garbage collector can delete it
					myFile = null;
					
					System.out.print("Enter 1 to search for another or 0 to quit the program: ");
					SENTINEL = keyboard.nextInt();
				}
				if (SENTINEL == 0) {
					break;
				}
			} while (SENTINEL == 0);
			
			//Output found file's contents (Strings in this case)
			if (SENTINEL == 1){
				//Opens the new file created above as an input
				Scanner inputFile = new Scanner(myFile);
				//Read the first line from the file
				int index = 1;
				
				do {
					//Input whole line from file scanner
					//Can also read numbers = nextByte, nextDouble, nextFloat, nextInt, nextLong, nextShort
					String line = inputFile.nextLine();
					
					//Display the line
					System.out.print("line " + (index++) + " in the file is: ");
					System.out.println(line);
					

				} while (inputFile.hasNext());
				//Close the file
				inputFile.close();
				
				System.exit(0);
			} else {
				System.out.println("The program will now shutdown...");
				System.exit(0);
			}
		}
	}
	
	public static File txtPath(String path) {
		File txt = new File("C:\\GDRIVE\\PROJECTS\\JAVA\\ProgrammingFundamentalsII_1337\\StartingWithJava\\Chapter4\\txt\\" + path);
		if(!txt.exists()) {
			return null;
		} else {
			return txt;
		}
	}
}