//Does not communicate with peer classes
//creates GUI (light weight components)
import javax.swing.*;
//Communicates with peer classes that are os specific
//determines events (heavy weight components)
//has Layout managers
import java.awt.*;
//Allows event objects to be used
import java.awt.event.*;
//
import java.awt.event.ActionListener;

//JFrame automatically uses BorderLayout which arranges components in 5 regions: north, east, south, west, and center
public class Window extends JFrame {
	private final int WIN_WIDTH = 600;			//WIDTH in pixels for JFrame window
	private final int WIN_HEIGHT = 200;			//HEIGHT in pixels for JFrame window
	private final int kiloTextFieldSize = 10;	//field size by characters
	private final int horizontalGap = 10;		//FlowLayout gap horizontally
	private final int verticalGap = 10;			//FlowLayout gap vertically
	private final int rows = 2;					//Init value for GridLayout
	private final int columns = 3;				//Init value for GridLayout
	private final int top = 5, left = 5, bottom = 5, right = 5; //border pixel width for all sides
	private JPanel panel1, panel2;				//panel references
	private ButtonGroup rButtonGroup;			//Groups radio buttons 
	private JLabel messageLabel;				//label reference
	private JTextField kiloTextField;			//text field reference
	private JButton calcButton;					//button reference
	private JLabel description;					//Describes what the program does
	private JLabel a,b,c,d,e,f;
	private JRadioButton choice1, choice2, choice3;
	private JCheckBox checkB1,checkB2, checkB3;
	
	public Window() {
		//Sets the windows title
		setTitle("My First Window");
		//Sets the size of the window
		setSize(WIN_WIDTH, WIN_HEIGHT);
		//Sets close button to close the window and terminate the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EXIT_ON_CLOSE = 3
		//Sets Layout manager to BorderLayout (set by default)
		setLayout(new BorderLayout());
		//Build panel and add to the frame
		buildButtonsAndCheckBox();
		buildPanel1();
		buildPanel2();
		//Adds panels, description, and grid to the frame's content pane
		add(panel1, BorderLayout.CENTER);
		add(description, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		//Shows window GUI
		setVisible(true);
	}
	
	public void buildButtonsAndCheckBox() {
		//Creates check boxes
		this.checkB1 = new JCheckBox("check box 1");
		this.checkB2 = new JCheckBox("check box 2");
		this.checkB3 = new JCheckBox("check box 3");
		//checkB1.addItemListener(new CheckBoxListener());
		//checkB2.addItemListener(new CheckBoxListener());
		//checkB3.addItemListener(new CheckBoxListener());
		this.rButtonGroup = new ButtonGroup();
		//Miles option is init selected
		this.choice1 = new JRadioButton("Miles", true);
		this.choice2 = new JRadioButton("Feet");
		this.choice3 = new JRadioButton("Inches");
		this.choice1.addActionListener(new ButtonListener());
		this.choice2.addActionListener(new ButtonListener());
		this.choice3.addActionListener(new ButtonListener());
		this.rButtonGroup.add(choice1);
		this.rButtonGroup.add(choice2);
		this.rButtonGroup.add(choice3);
	}
	
	public void buildPanel1() {
		//Create a JPanel object and let the panel field reference it
		//Sets Layout manager to FlowLayout and set to LEFT and gaps between components
		this.panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, horizontalGap, verticalGap));
		//This label will describe what the program does
		this.description = new JLabel("THIS PROGRAM CONVERTS FROM KILOMETERS");
		this.description.setForeground(Color.blue);
		//Create a label to display instructions
		this.messageLabel = new JLabel("Enter a distance in kilometers");
		//Create a text field 10 characters wide
		this.kiloTextField = new JTextField(kiloTextFieldSize);
		//Create a button with the caption Calculate
		this.calcButton = new JButton("Calculate");
		//Sets button's color
		this.calcButton.setBackground(Color.RED);
		this.calcButton.setForeground(Color.WHITE);
		//Add an action listener to the Calculate button
		this.calcButton.addActionListener(new ButtonListener());
		//Add the label, text field, and button components to the panel
		this.panel1.add(this.messageLabel);
		this.panel1.add(this.kiloTextField);
		this.panel1.add(this.calcButton);
		//Adds border to panel1 with 4 values representing pixel width on each side (4 sides)
		//BorderFactory has static methods so no object creation is needed
		this.panel1.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
	
	public void buildPanel2() {
		this.panel2 = new JPanel(new GridLayout(rows,columns));
		this.panel2.add(this.choice1);
		this.panel2.add(this.choice2);
		this.panel2.add(this.choice3);
		this.panel2.add(this.checkB1);
		this.panel2.add(this.checkB2);
		this.panel2.add(this.checkB3);
		//Adds border to panel1 with 4 values representing pixel width on each side (4 sides)
		//BorderFactory has static methods so no object creation is needed
		this.panel2.setBorder(BorderFactory.createEtchedBorder());
	}
	
	//Performs actionPerformed method after ActionEvent is passed from ActionListener
	private class ButtonListener implements ActionListener {
		//Used for buttons
		@Override
		public void actionPerformed(ActionEvent e) {
			final double MILES_CONVERT = 0.6214;	//miles conversion
			final double FEET_CONVERT = 3281.0;		//miles conversion
			final double INCHES_CONVERT = 39370.0;	//miles conversion
			String input;							//hold user input
			String actionCommand;
			double conversion;						//converted number

			//Get the text entered by the user into the text field
			input = kiloTextField.getText();
			//Get button action command
			actionCommand = e.getActionCommand();
			
			//Displays that calc button was used
			if (e.getSource() == calcButton && actionCommand == "Calculate") {
				JOptionPane.showMessageDialog(null,"Used Calculate button");
			}
			
			try {
				if (choice1.isSelected()) { //If miles button was pressed convert to miles
					//Convert the input to miles
					conversion = (Double.parseDouble(input) * MILES_CONVERT);
					//Display result
					JOptionPane.showMessageDialog(null,input + " kilometers converts to " + conversion + " miles.");
				} else if (choice2.isSelected()) { //If feet button was pressed convert to feet
					//Convert the input to miles
					conversion = (Double.parseDouble(input) * FEET_CONVERT);
					//Display result
					JOptionPane.showMessageDialog(null,input + " kilometers converts to " + conversion + " miles.");
				} else if (choice3.isSelected()) { //If inches button was pressed convert to inches
					//Convert the input to miles
					conversion = (Double.parseDouble(input) * INCHES_CONVERT);
					//Display result
					JOptionPane.showMessageDialog(null,input + " kilometers converts to " + conversion + " miles.");
				}
			} catch (NumberFormatException n) {
				//Display result
				JOptionPane.showMessageDialog(null," Please enter a valid number.");
			}
			
			//This command will click a radio button automatically as if the user did so
			//choice1.doClick();
			
			//This command will click a check box option automatically as if the user did so
			//checkB1.doClick();
		}
	}
	private class CheckBoxListener implements ItemListener {
		//Used for check boxes
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(checkB1.isSelected()) {
				JOptionPane.showMessageDialog(null, "option 1 was used");
			}
			if(checkB2.isSelected()) {
				JOptionPane.showMessageDialog(null, "option 2 was used");
			}
			if(checkB3.isSelected()) {
				JOptionPane.showMessageDialog(null, "option 3 was used");
			}
		}
	}
}
