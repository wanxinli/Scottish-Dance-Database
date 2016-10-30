package GUIV5;
/*
 * Written by Taghreed Bagies
 */
 
import javax.swing.JTabbedPane;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel{
	protected static String userInput = "Enter a word on the text field to retrieve information from database";
    private JTabbedPane tabbedPane;
    private String win;
    private CardLayout cl;
	private JPanel cards;
	
    protected JButton button;
	public TabbedCategory(String win,CardLayout cl,JPanel cards) {
		super(new GridLayout(1, 1));
		this.cl = cl;
		this.cards = cards;
		this.win = win;
		tabbedPane = new JTabbedPane();
		display("Dance",0,KeyEvent.VK_1);
		display("Publication",1,KeyEvent.VK_2);
		display("Album",2,KeyEvent.VK_3);
		display("Recordings",3,KeyEvent.VK_4);
	}
	public void display(String category, int position, int key){
		switch(win){
		case "Home":
			JComponent panel = makePanel(category);
			tabbedPane.addTab(category, null, panel, "Click to search on Dances");
			tabbedPane.setMnemonicAt(position, key);
			add(tabbedPane);
			break;
		case "1":
			JComponent panel1 = makePanel2(category);
			tabbedPane.addTab(category, null, panel1, "Click to search on Dances");
			tabbedPane.setMnemonicAt(position, key);
			add(tabbedPane);
			break;
		}
    }
     
    protected JComponent makePanel(String text) {
    	JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout(5,5));
        SearchTextfield textField = new SearchTextfield();
        panel.add(textField,BorderLayout.BEFORE_FIRST_LINE);
        textField.getButton().addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		userInput = textField.getInput();
		System.out.println(userInput);
		cl.next(cards);
		
	}});        
        JLabel label = new JLabel(userInput);
       	label.setOpaque(true);
       	panel.add(label,BorderLayout.CENTER);
        return panel;
    }
    
    protected JComponent makePanel2(String text) {
    	JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout(5,5));
        JLabel label = new JLabel(userInput);
       	label.setOpaque(true);
       	panel.add(label,BorderLayout.CENTER);
        return panel;
    }
}
