package GUIV4;
/*
 * Written by Taghreed Bagies
 */
 
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel{
	private String userInput = "Enter a word on the text field to retrieve information from database";
    private JTabbedPane tabbedPane;
    private boolean flag;
	public TabbedCategory(boolean flag) {
		super(new GridLayout(1, 1));
		this.flag = flag;
		tabbedPane = new JTabbedPane();
		display("Dance",0,KeyEvent.VK_1);
		display("Publication",1,KeyEvent.VK_2);
		display("Album",2,KeyEvent.VK_3);
		display("Recordings",3,KeyEvent.VK_4);
	}
	public void display(String category, int position, int key){
		JComponent tab;
		if(flag)
			tab = makePanel2(category);
		else
			tab = makePanel1(category);
        tabbedPane.addTab(category, null, tab, "Click to search on Dances");
        tabbedPane.setMnemonicAt(position, key);
        add(tabbedPane);
    }
     
    protected JComponent makePanel1(String text) {
    	JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout(5,5));
        SearchTextfield textField = new SearchTextfield();
        panel.add(textField,BorderLayout.BEFORE_FIRST_LINE);
        textField.getButton().addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		userInput = textField.getInput();	
		flag = true;
		System.out.println("Hiewrwr");
	}});        
        JLabel label = new JLabel(userInput);
       	label.setOpaque(true);
       	panel.add(label,BorderLayout.CENTER);
      //  panel.add(new JLabel("Filter"),BorderLayout.WEST);
        return panel;
    }
    
    protected JComponent makePanel2(String text) {
    	JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout(5,5));
        SearchTextfield textField = new SearchTextfield();
        panel.add(textField,BorderLayout.BEFORE_FIRST_LINE);

        textField.getButton().addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		userInput = textField.getInput();	
		System.out.println("Hiewrwr");
	}});        
        if(userInput==null){
        	JLabel label = new JLabel(userInput);
        	label.setOpaque(true);
        	panel.add(label,BorderLayout.CENTER);
        }
        else{
        	ListResults list = new ListResults(text);
            panel.add(list.display(),BorderLayout.CENTER);
        }
        System.out.println(textField.getInput());
        panel.add(new JLabel("Filter"),BorderLayout.WEST);
        return panel;
    }
}
