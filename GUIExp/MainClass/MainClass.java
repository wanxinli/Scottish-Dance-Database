package MainClass;
import java.awt.EventQueue;

import javax.swing.JFrame;

/*
 * Written by Taghreed Bagies
 */
import GUIV5.FrameDB;

public class MainClass {
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                FrameDB frame = new FrameDB();
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setTitle("PAWNT-Dance Database");
	                frame.setSize(2000, 2000);
	                frame.pack();
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            }
	        });
    }
}
