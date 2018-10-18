package amazon;

public class PasswordVerifier {
	private String passwordInput;
	private boolean validPassword;
	public final String[] SPECIAL_CHARACTERS = {"`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "{", "]", "}", "\\", "|", ";", ":", "\'", "\"", ",", "<", ".", "<", "/", "?"};
	
	public boolean isValid(String passwordInput) {
		int validCount = 0;
		this.validPassword = false;

		//Checks for white space
		if(passwordInput.matches(".*\\s+.*")) {
			return false;
		}
		//Checks for special characters
		for(int index=0; index<SPECIAL_CHARACTERS.length; index++) {
			if(passwordInput.contains(SPECIAL_CHARACTERS[index])) {
				return false;
			}
		}
		
		//Checks for at least 6 characters
		if(passwordInput.length()>=6) {
			validCount++;
		}
		//Checks for at least one lower case char
		if(passwordInput.matches(".*[a-z].*")) {
			validCount++;
		}
		//Checks for at least one upper case char
		if(passwordInput.matches(".*[A-Z].*")) {
			validCount++;
		}
		//Checks for at least one integer
		if(passwordInput.matches(".*[0-9].*")) {
			validCount++;
		}

		//Checks if each condition was met
		if(validCount==4) {
			this.validPassword = true;
			this.passwordInput = passwordInput;
		}
		
		return this.validPassword;
	}
}
