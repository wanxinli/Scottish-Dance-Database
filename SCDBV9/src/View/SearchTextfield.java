package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author tbagies
 * 
 * This class is responsible to draw the input text field and button on the GUI interface
 * if a user click on search button with empty string input, the class call ThrowError class to handle error message
 * Otherwise, the class uses Create an object of ListResults to display the information from database 
 * 
 */

@SuppressWarnings("serial")
public class SearchTextfield extends JPanel implements ActionListener{
	/**
	 * data fields
	 */
	 protected  JButton button;
	 protected Label label;
	 protected JTextField textField;
	 protected String input;
	 private String category;
	 private JPanel panel= new JPanel();
	 
	 /**
	  * 
	  * @param category
	  */
	 SearchTextfield(String category){
		 this.category = category;
		 setLayout(new BorderLayout());
		 panelSearch();
	 }
	 
	 /**
	  * method to draw label, text field, and button
	  */
	 private void panelSearch(){
		 JPanel panelSearch = new JPanel();
		 panelSearch.setLayout(new FlowLayout());
		 label = new Label("Enter the search key: ");
		 textField = new JTextField(30);
		 button = new JButton("Search");
		 button.addActionListener(this);
		 panelSearch.add(label);
		 panelSearch.add(textField);
		 panelSearch.add(button);
		 add(panelSearch,BorderLayout.NORTH);
	 }
	 
	 /**
	  * (non-Javadoc)
	  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	  * It creates an object of ListResults to display the retrived information
	  * It , also, handles empty input by using ThrowError class
	  */
	 @Override
		public void actionPerformed(ActionEvent e) {
			input = textField.getText();
			panel.removeAll();
			if(input == null || input.isEmpty()){
				ThrowError.errorMessage("Enter a search Key on the input box to search on " + category + " data");
			}
			else{
				ListResults resultList = new ListResults(category,input);
				panel.add(resultList);
			}
			add(panel,BorderLayout.CENTER);
			revalidate();			
		}
	
}
