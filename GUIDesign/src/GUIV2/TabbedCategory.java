package GUIV2;

 
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel {
	private String result = "Enter a word on the text field to retrieve information from database";
    public TabbedCategory() {
        super(new GridLayout(1, 1));
         
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
        	JLabel label = new JLabel(result);
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
    	/* JPanel panel = new JPanel(false);
         panel.setLayout(new GridLayout(2, 2));
         panel.add(new SearchTextfield());
         ListResults list = new ListResults(text);
         panel.add(list.display());
         panel.add(list.display());
         return panel;%/
    /*    JPanel panel = new JPanel(false);
        GridBagConstraints c = grid(0,0,0,0);
        panel.setLayout(new GridBagLayout());//(new GridLayout(2, 1));
        panel.add(new SearchTextfield(),c);
        ListResults list = new ListResults(text);
        c= grid(0,1,0,1000);
        panel.add(list.display(),c);
        return panel;*/
    }
    
    private GridBagConstraints grid(int x , int y, double weightx, double weighty){
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx =x;
        c.gridy =y;
        c.weightx = weightx;
        c.weighty = weighty;
        return c;
    }
     
}
