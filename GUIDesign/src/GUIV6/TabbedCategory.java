package GUIV6;
/*
 * Written by Taghreed Bagies
 */
 
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel{
	protected static String userInput = "Enter a word on the text field to retrieve information from database";
    private JTabbedPane tabbedPane;

	public TabbedCategory() {
		super(new GridLayout(1, 1));
		tabbedPane = new JTabbedPane();
		display("Dance",0,KeyEvent.VK_1);
		display("Publication",1,KeyEvent.VK_2);
		display("Album",2,KeyEvent.VK_3);
		display("Recordings",3,KeyEvent.VK_4);
	}
	public void display(String category, int position, int key){
		JComponent panel = new SearchTextfield(category);
		tabbedPane.addTab(category, null, panel, "Click to search on " + category);
		tabbedPane.setMnemonicAt(position, key);
		add(tabbedPane);
    }
     
  
}
