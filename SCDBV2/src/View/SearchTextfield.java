package View;
/*
 * Written by Taghreed Bagies
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchTextfield extends JPanel implements ActionListener{
	 protected  JButton button;
	 protected Label label;
	 protected JTextField textField;
	 protected String input;
	 private String category;
	 private JPanel panel= new JPanel();
	 
	 SearchTextfield(String category){
		 this.category = category;
		 setLayout(new BorderLayout());
		 panelSearch();
	 }
	 
	 private void panelSearch(){
		 JPanel panelSearch = new JPanel();
		 panelSearch.setLayout(new FlowLayout());
		 label = new Label("Enter the serach key: ");
		 textField = new JTextField(30);
		 button = new JButton("Search");
		 button.addActionListener(this);
		 panelSearch.add(label);
		 panelSearch.add(textField);
		 panelSearch.add(button);
		 add(panelSearch,BorderLayout.NORTH);
	 }
	 @Override
		public void actionPerformed(ActionEvent e) {
			input = textField.getText();
			System.out.println("INPUT " + input);
			panel.removeAll();
			if(input == null || input.isEmpty()){
				JLabel label = new JLabel("Enter a search Key ");
				panel.add(label);
			}
			else{
				ListResults resultList = new ListResults(category,input);
				panel.add(resultList);
			}
			add(panel,BorderLayout.CENTER);
			revalidate();			
			System.out.println("Hi");
		}
	
}
