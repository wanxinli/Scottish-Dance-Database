package GUIV6;

import javax.swing.JTable;

public class DetailedResult extends JTable{
	private String key;

	public DetailedResult(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
