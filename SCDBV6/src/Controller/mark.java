package Controller;

public class mark {
	private int id;
	private String tableName;
	public mark(int id, String tableName) {
		super();
		this.id = id;
		this.tableName = tableName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
