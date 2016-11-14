package Model;

/**
 * 
 * @author tbagies
 * This class might be used later
 */

public class DatabaseTable {
	private String tableName;
	private String forignKey; // spelling -> foreign
	private String field;
	DatabaseTable(String name, String forignKey, String field){
		tableName = name;
		this.forignKey = forignKey;
		this.field = field;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getForignKey() {
		return forignKey;
	}
	public void setForignKey(String forignKey) {
		this.forignKey = forignKey;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
}
