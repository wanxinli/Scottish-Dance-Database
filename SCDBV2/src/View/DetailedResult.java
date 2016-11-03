package View;
/*
 * Written by Taghreed Bagies
 */

import javax.swing.JTable;

public class DetailedResult extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
