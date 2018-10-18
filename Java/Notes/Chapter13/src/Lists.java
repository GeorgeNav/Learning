//Currently on Combo Boxes pg.868 chapter 13
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;

public class Lists extends JFrame {
	private JFrame UI;
	private JPanel optionPanel;
	private JPanel selectionPanel;
	private JLabel selectionLabel;
	private JList selectionField;
	private JScrollPane namesListWithScrollPane;
	private String[] names = new String[] {"Romi", "Matt", "Nick", "John", "Ryan", "Doug", "JT", "Pulp", "Frank"};
	private JList namesList;
	private int pixels = 1; // for border
	private int amountVisible = 5;

	public Lists() {
		UI = new JFrame();

		selectionLabel = new JLabel("You have selected:");
		selectionField = new JList();

		//namesList = new JList(names); // easier way to set list to array of names
		//harder way
		namesList = new JList();
		namesList.setListData(names);

		namesList.setVisibleRowCount(amountVisible); // amount of options able to be seen
		namesList.setBorder(BorderFactory.createLineBorder(Color.BLACK, pixels)); // sets boarder the be black and 1 pixel thick

		namesListWithScrollPane = new JScrollPane(namesList);
		
		selectionPanel = new JPanel(new GridLayout(1,2));
		selectionPanel.add(selectionLabel);
		selectionPanel.add(selectionField);
		optionPanel = new JPanel();
		//optionPanel.add(namesList); //not needed because scrollPane contains list component
		optionPanel.add(namesListWithScrollPane);

		namesList.addListSelectionListener(new ListListener()); // adds a Listener to list so when something is selected it sends the event to the ListListener class for further use
		//namesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // used by default only allowing one choice at a time
		//namesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // can select multiple by holding control or shift as long as ones that are selected are by each other
		namesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // can select multiple by holding control or shift (no restrictions)
		UI.add(optionPanel, BorderLayout.CENTER);
		UI.add(selectionPanel, BorderLayout.SOUTH);
		UI.setSize(300,400);
		UI.setVisible(true);
	}

	private class ListListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			Object[] selection = namesList.getSelectedValues();
			selectionField.setListData(selection);
		}
	}

	public static void main(String[] args) {
		new Lists();
	}
}
