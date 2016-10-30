package GUIV5;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/*
 * Written by Taghreed Bagies
 */

public class FrameDB extends JFrame {
	//private Container container = new Container();
	private final CardLayout cl = new CardLayout();
	private final JPanel cards = new JPanel(cl);
	private String window ="Home";
	public FrameDB() {
	JPanel contentPane = new JPanel();
    contentPane.setLayout(new GridLayout());
    setContentPane(contentPane);
    
    TabbedCategory tabbedCategory1= new TabbedCategory(window,cl,cards);
    JPanel panel1 = new JPanel(new GridLayout());
    panel1.add(tabbedCategory1);
    cards.add(panel1, "First Panel");
  /*  JButton controlButton1 = tabbedCategory1.button;
    controlButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cl.next(cards);
        }
    });*/
    
    TabbedCategory tabbedCategory2= new TabbedCategory("1",cl,cards);
    JPanel panel2 = new JPanel(new GridLayout());
    panel2.add(tabbedCategory2);
    cards.add(panel2, "Second Panel");

    contentPane.add(cards);

    cl.show(cards, "First Panel");
	}
	
}
