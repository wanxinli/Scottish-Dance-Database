package View;
 
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
 
/**
 * 
 * @author tbagies
 * 
 * This class is responsible for drawing the tabbed panel on GUI
 * There are four tabs (Dance, Album, Recordings, Publications)
 * A user needs to click on one of them in order to retrieve information associated with the clicked tab
 * It uses SearchTextfield class to be appeared on each tab
 */
@SuppressWarnings("serial")
public class TabbedCategory extends JPanel{
	/**
	 * data member
	 */
    protected static JTabbedPane tabbedPane;
    /**
     * constructor that creates a JTabbedPane 
     */
	public TabbedCategory() {
		super(new BorderLayout());
		tabbedPane = new JTabbedPane();
		display("dance",0,KeyEvent.VK_1);
		display("publication",1,KeyEvent.VK_2);
		display("album",2,KeyEvent.VK_3);
		display("recording",3,KeyEvent.VK_4);
	}
	/**
	 * 
	 * @param category
	 * @param position
	 * @param key
	 * 
	 * creates an object of searctTextfield for each category 
	 * Adds it on each tab panel
	 */
	private void display(String category, int position, int key){
		JComponent panel = new SearchTextfield(category);
		tabbedPane.addTab(category, null, panel);
		tabbedPane.setMnemonicAt(position, key);
		add(tabbedPane);
    }

}
