package GUI;

 
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class TabbedCategory extends JPanel {
	private String result = "Enter a word on the text field to retrieve information from database";
    public TabbedCategory() {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JComponent panelDance = makeTextPanel(result);
        tabbedPane.addTab("Dance", null, panelDance, "Click to search on Dances");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panelPublications = makeTextPanel(result);
        tabbedPane.addTab("Publications", null, panelPublications,"Click to search on Publications");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panelAlbum = makeTextPanel(result);
        tabbedPane.addTab("Album", null, panelAlbum,"Click to search on Albums");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panelRecordings = makeTextPanel(result);
        //panelRecordings.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Recordings", null, panelRecordings,"Click to search on Recordings");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
     
}
