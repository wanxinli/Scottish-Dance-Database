package View;
/*
 * Written by Taghreed Bagies
 */
 
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
 
@SuppressWarnings("serial")
public class TabbedCategory extends JPanel{
	protected static String userInput = "Enter a word on the text field to retrieve information from database";
    protected static JTabbedPane tabbedPane;
	public TabbedCategory() {
		super(new BorderLayout());
		tabbedPane = new JTabbedPane();
		display("dance",0,KeyEvent.VK_1);
		display("publication",1,KeyEvent.VK_2);
		display("album",2,KeyEvent.VK_3);
		display("recordings",3,KeyEvent.VK_4);
	}
	private void display(String category, int position, int key){
		JComponent panel = new SearchTextfield(category);
		tabbedPane.addTab(category, null, panel, "Click to search on " + category);
		tabbedPane.setMnemonicAt(position, key);
		add(tabbedPane);
    }

}
