package GUIV3;
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
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel {
	private String userInput = "Enter a word on the text field to retrieve information from database";
    public TabbedCategory() {
    	super(new GridLayout(1, 1));
    	run();
    }
    
    public void run(){
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panelDance = makePanel("dance");
        tabbedPane.addTab("Dance", null, panelDance, "Click to search on Dances");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panelPublications = makePanel("Publications");
        tabbedPane.addTab("Publications", null, panelPublications,"Click to search on Publications");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panelAlbum = makePanel("Album");
        tabbedPane.addTab("Album", null, panelAlbum,"Click to search on Albums");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panelRecordings = makePanel("Recordings");
        //panelRecordings.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Recordings", null, panelRecordings,"Click to search on Recordings");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makePanel(String text) {
    	JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout(5,5));
        SearchTextfield textField = new SearchTextfield();
        panel.add(textField,BorderLayout.BEFORE_FIRST_LINE);
        if(textField.getInput()==null){
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
