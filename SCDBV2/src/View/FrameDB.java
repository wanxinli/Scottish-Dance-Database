package View;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * Written by Taghreed Bagies
 */

public class FrameDB extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JPanel contentPane;
	public FrameDB() {
        setTitle("PAWNT-Dance Database");
        setSize(2000,2000);
      //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout());
        setContentPane(contentPane);
        TabbedCategory tabbedCategory= new TabbedCategory();
        contentPane.add(tabbedCategory);
        
      //  pack();
     //   setLocationRelativeTo(null);
        setVisible(true);
	}
	
	public FrameDB(JPanel contentPane){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PAWNT-Dance Database");
      //  setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(2000,2000);
		contentPane.setLayout(new GridLayout());
	    setContentPane(contentPane);        
	    TabbedCategory tabbedCategory= new TabbedCategory();
	    contentPane.add(tabbedCategory);
	    pack();
	    setLocationRelativeTo(null);
        setVisible(true);
	}
}
