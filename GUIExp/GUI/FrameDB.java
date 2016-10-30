package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameDB {
	//private Container container = new Container();
	public FrameDB() {
		JFrame frame = new JFrame("PAWNT-Dance Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 2000);
		JPanel panel = new JPanel(new BorderLayout());
		Container contentPane = frame.getContentPane();
	//	contentPane.setLayout(new FlowLayout());
		contentPane.add(new TabbedCategory(),BorderLayout.PAGE_START);
		contentPane.add(new SearchTextfield(),BorderLayout.CENTER);
		ListResults list = new ListResults();
		contentPane.add(list.display(),BorderLayout.AFTER_LINE_ENDS);
		frame.pack();
		frame.setVisible(true);
		/*JFrame frame = new JFrame("PAWNT-Dance Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(new TabbedCategory());
        container.add(new SearchTextfield());
        frame.setContentPane(container);
        frame.pack();
        frame.setVisible(true);
	        //Create and set up the window.
	      /*  JFrame frame = new JFrame("PAWNT-Dance Database");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(new SearchTextfield(),1);
	        frame.add(new TabbedCategory(),3);
	     //   
	        //Display the window.
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(true);
	        frame.setVisible(true);*/
	    }
}
