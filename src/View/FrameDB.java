package View;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author tbagies
* 
* This class is the container of the GUI.
* It is create the frame and uses TabbedCatgeory to display the tab panel
*/
public class FrameDB extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * data member
	 */
	protected static JPanel contentPane;
	/**
	 * A constructor to create the Frame and add tab panel on the frame
	 */
	public FrameDB() {
        setTitle("PAWNT-Dance Database");
        setSize(1000,770);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout());
        setContentPane(contentPane);
        TabbedCategory tabbedCategory= new TabbedCategory();
        contentPane.add(tabbedCategory);
        setVisible(true);
	}
}
