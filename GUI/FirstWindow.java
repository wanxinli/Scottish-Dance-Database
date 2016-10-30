package GUI;
/*
 * Written By Taghreed Bagies
 */	

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import Main.MainClass;

/**
 * 
 * @author tbagies
 *
 */
public class FirstWindow extends JFrame implements ActionListener {
	/**
	 * Data Fields
	 */
	 private Button button;
	 private Label label;
	 private TextField textField;
	/**
	 * Constructor    
	 */
	public FirstWindow(){
		setLayout(new FlowLayout());
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		label = new Label("Enter Dance Name: ");
	    add(label);
	    textField = new TextField(30);
	    add(textField);
	    textField.addActionListener(this);
	    button = new Button("Search");
	    add(button);     
	    button.addActionListener(this);
	    setTitle("Dance Database");
	    setSize(1000, 1000);
	    setVisible(true);  
	}

	@Override
	/**
	 * @param actionevent 
	 */
	public void actionPerformed(ActionEvent actionevent) {
		MainClass.run(textField.getText());
	}
}
