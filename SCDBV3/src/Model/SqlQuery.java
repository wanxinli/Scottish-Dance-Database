package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author tbagies
 * This class is responsible for executing a query on the database
 * It handles three types of queries (select statement , join statement on 2 tables, join statement on 4 tables) 
 */
public class SqlQuery
{
	/**
	 * Data fields
	 */
	private Connection connection = null;
	private String table;
	
	/**
	 * 
	 * @param con
	 * @param tableName
	 */
	public SqlQuery(Connection con, String tableName){
		connection = con;
		table = tableName;
	}
	    
	/**
	 * 
	 * @param searchKey
	 * @return ResultSet
	 * 
	 * handles select statement on one table
	 * 	 
	 */
	public ResultSet searchByName(String pk, String searchKey){
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + " WHERE " + pk + " LIKE '%" + searchKey + "%'");
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 
	 * @param PK
	 * @param table1ID
	 * @param table2ID
	 * @param table1
	 * @param table2
	 * @param searchKey
	 * @return ResultSet
	 * Handles join statement on 2 tables
	 */
	public ResultSet join2Tables(String PK, String table1ID, String table2ID, String table1, String table2, String searchKey){
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
			System.out.println("SELECT " + table1 + ".*, "  + 
					table2 + "." + table2ID + " AS " + table2 + "Col " +
					"FROM " + table1 + " JOIN " + table2 + " ON (" + table1 +"." + table1ID + " = " + table2 + ".id ) WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%'");
			ResultSet rs = statement.executeQuery("SELECT " + table1 + ".*, "  + 
					table2 + "." + table2ID + " AS " + table2 + "Col " +
					"FROM " + table1 + " JOIN " + table2 + " ON (" + table1 +"." + table1ID + " = " + table2 + ".id ) WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%'");
			
			
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 
	 * @param PK
	 * @param table1ID1
	 * @param table1ID2
	 * @param table1ID3
	 * @param table2ID
	 * @param table3ID
	 * @param table4ID
	 * @param table1
	 * @param table2
	 * @param table3
	 * @param table4
	 * @param searchKey
	 * @return ResultSet
	 * 
	 * handles join statement on 4 tables
	 */
	public ResultSet join4Tables(String PK, String table1ID1, String table1ID2, String table1ID3, String table2ID, String table3ID, String table4ID, String table1, String table2, String table3, String table4, String searchKey){
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
			System.out.println("SELECT " + table1 + ".*, " + 
					table2 + "." + table2ID + " AS " + table2 + "Col, " +
					table3 + "." + table3ID + " AS " + table3 + "Col, " +
					table4 + "." + table4ID + " AS " + table4 + "Col " +
					"FROM " + table1 + 
					" JOIN " +table2 + " ON (" + table1 +"." + table1ID1 + " = " + table2 + ".id ) " +
					"JOIN  " + table3 + " ON (" + table1 +"." + table1ID2 + " = " + table3 + ".id ) " +
					"JOIN  " + table4 + " ON (" + table1 +"." + table1ID3 + " = " + table4 + ".id ) " +
					"WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%'");
			ResultSet rs = statement.executeQuery("SELECT " + table1 + ".*, " + 
					table2 + "." + table2ID + " AS " + table2 + "Col, " +
					table3 + "." + table3ID + " AS " + table3 + "Col, " +
					table4 + "." + table4ID + " AS " + table4 + "Col " +
					"FROM " + table1 + 
					" JOIN " +table2 + " ON (" + table1 +"." + table1ID1 + " = " + table2 + ".id ) " +
					"JOIN  " + table3 + " ON (" + table1 +"." + table1ID2 + " = " + table3 + ".id ) " +
					"JOIN  " + table4 + " ON (" + table1 +"." + table1ID3 + " = " + table4 + ".id ) " +
					"WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%'");
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
}