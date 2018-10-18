import java.util.Arrays;

public class SimpleSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,35,20,10,25}, sortedOutput;
		sortedOutput = simpleSorting(input);
		System.out.println("Done: " + Arrays.toString(sortedOutput));
	}
	
	//Sorts an array of integers from smallest to largest
	public static int[] simpleSorting(int[] input) {
		int temp;

		for(int i = (input.length-1); 0 < i; --i) { // i = last subscript to check to
			for(int j = 0; j < i; ++j) {
				if(input[j] > input[j+1]) {
					temp = input[j];
					input[j] = input[i];
					input[i] = temp;
				}
			}
		}

		return input;
	}
}
