package GUIV6;
/*
 * Written by Taghreed Bagies
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class SearchTextfield extends JPanel implements ActionListener{
	 private JButton button;
	 private Label label;
	 private JTextField textField;
	 private String input;
	 private final CardLayout cl = new CardLayout();
	 private final JPanel cards = new JPanel(cl);

	 private String category;
	 ListResults resultList = new ListResults(category,input);
	 DetailedResult detailedresult = new DetailedResult(input);
	 
	 SearchTextfield(String c){
		 setLayout(new BorderLayout(2,1));
		 this.category = c;
		 makeCards();
	 }
	 
	 private JPanel panelSearch(){
		 JPanel panelSearch = new JPanel();
		 panelSearch.setLayout(new FlowLayout());
		 label = new Label("Enter the serach key: ");
		 textField = new JTextField(30);
		 textField.addActionListener(this);
		 button = new JButton("Search");
		 button.addActionListener(this);
		 panelSearch.add(label);
		 panelSearch.add(textField);
		 panelSearch.add(button);
		 return panelSearch;

	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		input = textField.getText();
		System.out.println(input);
		resultList.setKeySearch(input);
		resultList.setTableName(category);
		cl.show(cards, "List Result Panel");//next(cards);
		System.out.println("Hi");
	}
	
	protected void makeCards() {
		
	    cards.add(makePanel(new JLabel(category + " Home Page ")), "First Panel");

	    JScrollPane spTable = new JScrollPane(resultList);
	    cards.add(makePanel(spTable),"List Result Panel");
	 
	  //  spTable = new JScrollPane(detailedresult);
	   // cards.add(makePanel(spTable), "Detailed Panel");
	    
	    add(cards);
	    cl.show(cards, "First Panel");

	}
	
	private JPanel makePanel(JComponent panel1){
		JPanel panel = new JPanel(new BorderLayout());
	    panel.add(panelSearch(),BorderLayout.NORTH);
	    panel.add(panel1,BorderLayout.CENTER);
	    return panel;
	}
}
