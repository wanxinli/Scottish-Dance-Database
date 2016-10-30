package GUIV6;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * Written by Taghreed Bagies
 */

public class FrameDB extends JFrame {

	public FrameDB() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PAWNT-Dance Database");
        setSize(2000, 2000);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout());
        setContentPane(contentPane);
        
        TabbedCategory tabbedCategory= new TabbedCategory();
        contentPane.add(tabbedCategory);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    
	}
	
}
