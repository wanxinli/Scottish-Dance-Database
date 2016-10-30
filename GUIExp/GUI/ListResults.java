package GUI;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class ListResults {
	String[] initString = {"This is an editable JTextPane, "};  

	String[] initStyles = {"regular"};
	
	public ListResults(){
		String[] initString =
            { 
            		"This is an editable JTextPane, "
            }; 

    String[] initStyles =
            { "regular"
            };

	}
	public JTextPane display(){
		JTextPane textPane = new JTextPane();
	    StyledDocument doc = textPane.getStyledDocument();
	    addStylesToDocument(doc);

	    try {
	        for (int i=0; i < initString.length; i++) {
	            doc.insertString(doc.getLength(), initString[i],
	                             doc.getStyle(initStyles[i]));
	        }
	    } catch (BadLocationException ble) {
	        System.err.println("Couldn't insert initial text into text pane.");
	    }
	    return textPane;
		}
	
	protected void addStylesToDocument(StyledDocument doc) {
        //Initialize some styles.
        Style def = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);
 
        Style regular = doc.addStyle("regular", def);
        StyleConstants.setFontFamily(def, "SansSerif");
 
        Style s = doc.addStyle("italic", regular);
        StyleConstants.setItalic(s, true);
 
        s = doc.addStyle("bold", regular);
        StyleConstants.setBold(s, true);
 
        s = doc.addStyle("small", regular);
        StyleConstants.setFontSize(s, 10);
 
        s = doc.addStyle("large", regular);
        StyleConstants.setFontSize(s, 16);
 
       
    }
 
}
