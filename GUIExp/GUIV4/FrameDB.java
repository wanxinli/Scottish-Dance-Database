package GUIV4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/*
 * Written by Taghreed Bagies
 */

public class FrameDB {
	//private Container container = new Container();
	private String s;
	private boolean flag = false;
	public FrameDB(){
	}
	public Container display(){
		JFrame frame = new JFrame("PAWNT-Dance Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2000, 2000);
		Container contentPane = frame.getContentPane();
		contentPane.add(new TabbedCategory(flag));
		
		frame.pack();
		frame.setVisible(true);
		return contentPane;
	    }
}
