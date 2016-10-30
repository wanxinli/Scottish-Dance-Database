package GUI;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class SearchTextfield extends JPanel implements ActionListener {
	 private Button button;
	 private Label label;
	 private TextField textField;
	 private String input;
	 SearchTextfield(){
		 setLayout(new FlowLayout());
		 label = new Label("Enter the serach key: ");
		 add(label);
		 textField = new TextField(30);
		 add(textField);
		 textField.addActionListener(this);
		 button = new Button("Search");
		 add(button);     
		 button.addActionListener(this);
	//	 setPreferredSize(new Dimension(100, 50));
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
}

}
