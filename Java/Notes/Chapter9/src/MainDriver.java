import javax.swing.JOptionPane;

public class MainDriver {
	public static void main(String[] args) {
		CaseConversion caseConversion = new CaseConversion();
		SearchingForSubstrings searchingForSubstrings = new SearchingForSubstrings();
		StringBuilderClass stringBuilderClass = new StringBuilderClass();
		UsingArrayLists usingArrayLists = new UsingArrayLists();
		WrapperClass wrapperClass = new WrapperClass();
		String option = null;
		
		do {
			option = JOptionPane.showInputDialog("Enter a choice, (-1) to exit: " + "\n"
					+ "1) Case Conversion" + "\n"
					+ "2) Searching For Substrings" + "\n"
					+ "3) String Builder Class" + "\n"
					+ "4) Using Array Lists" + "\n"
					+ "5)  Wrapper Class" + "\n");
			switch(Integer.parseInt(option)) {
				case 1:
					caseConversion.main();
				case 2:
					searchingForSubstrings.main();
				case 3:
					stringBuilderClass.main();
				case 4:
					usingArrayLists.main();
				case 5:
					wrapperClass.main();
				default:
					JOptionPane.showMessageDialog(null, "This program is finished");
					option = "-1";
					break;
			}
			
		} while (Integer.parseInt(option) != (-1));
	}
}
