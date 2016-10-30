package GUIV6;


import javax.swing.JTable;


public class ListResults extends JTable{
	String[] initString = {"\n\n\n\n\n\nThis is an editable JTextPane, "};  

	String[] initStyles = {"regular"};
	String tableName;
	String keySearch;
	JTable table;
	
	public ListResults(String category, String userInput){
		tableName = category;
		keySearch = userInput;
		table = new JTable();
		display();
	}
	public void display(){
		/*
		 *
		 * Displayed in Table format
		 */
		System.out.println("No Connection To database");
    }
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getKeySearch() {
		return keySearch;
	}
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
		System.out.println("From SET " + keySearch);
	}
	
}
