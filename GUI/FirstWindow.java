package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import Main.MainClass;

public class FirstWindow extends JFrame implements ActionListener {
	 private Button button;
	 private Label label;
	 private TextField textField;
	    
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
	public void actionPerformed(ActionEvent e) {
		MainClass.run(textField.getText());
	}
}
