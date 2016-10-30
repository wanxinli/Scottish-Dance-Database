package GUIV2;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchTextfield extends JPanel  {
	 private JButton button;
	 private Label label;
	 private JTextField textField;
	 private String input;
	 SearchTextfield(){
		 setLayout(new FlowLayout());
		 label = new Label("Enter the serach key: ");
		 add(label);
		 Listener listner = new Listener();
		 textField = new JTextField(30);
		 textField.addActionListener(listner);
		 add(textField);
		 button = new JButton("Search");
		 add(button);    
		 button.addActionListener(listner);
	 }


public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
private class Listener implements ActionListener{
@Override
public void actionPerformed(ActionEvent e) {
	input = textField.getText();		
	System.out.println("Hi");
}
}
}
