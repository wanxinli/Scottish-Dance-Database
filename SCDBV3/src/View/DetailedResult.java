package View;

import javax.swing.JTable;

/**
 * 
 * @author tbagies
 * This class is responsible to show the details information about a particular record on the database
 * It is not working now it will be implemented on sprint5
 */


public class DetailedResult extends JTable{
	private static final long serialVersionUID = 1L;
	private String key;

	/**
	 * 
	 * @param key
	 */
	public DetailedResult(String key) {
		super();
		this.key = key;
	}
	/**
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	

}
