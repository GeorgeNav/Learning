import javax.swing.*;
import java.awt.*;

public class ReadOnlyTextFields {
	public static void main(String[] args) {
		JFrame UI = new JFrame();
		UI.setLayout(new GridLayout(3,2));

		// Create a read-only text field for the subtotal
		JTextField subtotalField = new JTextField(10);
		subtotalField.setText("100.00");
		subtotalField.setEditable(true); //can alter (defaults to enabled so this is not needed)
		// Create a read-only text field for the sales tax
		JTextField taxField = new JTextField(10);
		taxField.setText("6.00");
		taxField.setEditable(false); //sets to read only (defaults to enabled)
		// Create a read-only text field for the total
		JTextField totalField = new JTextField(10);
		totalField.setText("106.00");
		totalField.setEditable(false); //sets to read only (defaults to enabled)

		JLabel subtotalLabel = new JLabel("Subtotal");
		JLabel taxLabel = new JLabel("Sales Tax");
		JLabel totalLabel = new JLabel("Total");

		UI.add(subtotalLabel);
		UI.add(subtotalField);
		UI.add(taxLabel);
		UI.add(taxField);
		UI.add(totalLabel);
		UI.add(totalField);
		UI.setTitle("Read Only Text Fields Test");
		UI.setSize(300,200);
		UI.setVisible(true);
	}
}
