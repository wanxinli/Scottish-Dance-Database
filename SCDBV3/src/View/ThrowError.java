package View;

import javax.swing.JOptionPane;
/**
 * 
 * @author tbagies
 * This class is responsible for displaying a pop up message when it is used by other class
 * All View classes can use this class when an error occurs.
 */
public class ThrowError {
	/**
	 * 
	 * @param msg
	 * uses JOptionPane to display a pop up message with error sentence. 
	 */
	public static void errorMessage(String msg){
		JOptionPane.showMessageDialog(null,
			    msg,
			    "Error Message",
			    JOptionPane.ERROR_MESSAGE);
	}
}
