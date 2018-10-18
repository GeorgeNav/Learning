package CourseDemo;

public class Palindrome {
	public static boolean isPalindrome(String word) {
		boolean isPal = true;
		for(int index = 0; index < (word.length()/2); index++) {
			if(word.charAt(index) == word.charAt(word.length()-index)) {
				isPal = true;
			} else {
				isPal = false;
				break;
			}
		}
		return isPal;
	}
}