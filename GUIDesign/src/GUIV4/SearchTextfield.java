package GUIV4;
/*
 * Written by Taghreed Bagies
 */

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchTextfield extends JPanel implements ActionListener{
	 private JButton button;
	 private Label label;
	 private JTextField textField;
	 private String input;
	 SearchTextfield(){
		 setLayout(new FlowLayout());
		 label = new Label("Enter the serach key: ");
		 add(label);
		 textField = new JTextField(30);
		 textField.addActionListener(this);
		 add(textField);
		 button = new JButton("Search");
		 add(button);    
		 button.addActionListener(this);
	 }

public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		input = textField.getText();	
		System.out.println("Hi");
	}
}
