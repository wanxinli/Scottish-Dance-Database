package GUIV2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameDB {
	//private Container container = new Container();
	public FrameDB() {
	}
	
	public Container display(){
		JFrame frame = new JFrame("PAWNT-Dance Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 2000);
		JPanel panel = new JPanel(new BorderLayout());
		Container contentPane = frame.getContentPane();
		contentPane.add(new TabbedCategory(),BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		return contentPane;
	    }
}
