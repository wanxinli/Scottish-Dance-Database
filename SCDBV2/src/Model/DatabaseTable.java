package Model;
/*
 * Written by Taghreed Bagies
 */

import java.util.List;

public class DatabaseTable {
	private String tableName;
	private List<String> fields = null;
	private String primaryKey;
	DatabaseTable(String name, List<String> cols, String pKey){
		tableName = name;
		fields = cols;
		primaryKey = pKey;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	
}
