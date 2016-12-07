package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author tbagies
 * 
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
		String sql;
		searchKey = fixSpecialCharacters(searchKey);
			
		if(pk.equals("name"))
			sql = "SELECT * FROM " + table + " WHERE " + pk + " LIKE '%" + searchKey + "%' ORDER BY " + pk + " ASC";
		else
			sql = "SELECT * FROM " + table + " WHERE " + pk + " LIKE '" + searchKey + "'";
		try {
			statement = connection.createStatement();
			//statement.setQueryTimeout(30);  
		//	System.out.println(sql);
			ResultSet rs = statement.executeQuery(sql);
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	private String fixSpecialCharacters(String searchKey){
		if(searchKey.contains("'")){
			int index = searchKey.indexOf("'");
			//System.out.println(index);
			return searchKey.substring(0,index);
		}
		return searchKey;
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
		String sql;
		if(PK.equals("name"))
			sql = "SELECT " + table1 + ".*, "  + 
					table2 + "." + table2ID + " AS " + table2 + "Col " +
					"FROM " + table1 + 
					" JOIN " + table2 + " ON (" + table1 +"." + table1ID + " = " + table2 + ".id ) WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%' ORDER BY " + PK + " ASC";
		else
			sql = "SELECT " + table1 + ".*, "  + 
					table2 + "." + table2ID + " AS " + table2 + "Col " +
					"FROM " + table1 + " JOIN " + table2 + " ON (" + table1 +"." + table1ID + " = " + table2 + ".id ) WHERE " + table1 + "." + PK + " LIKE '" + searchKey + "'";
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
			ResultSet rs = statement.executeQuery(sql);
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
		String sql;
		searchKey = fixSpecialCharacters(searchKey);
		if(PK.equals("name"))
			sql = "SELECT " + table1 + ".*, " + 
				table2 + "." + table2ID + " AS " + table2 + "Col, " +
				table3 + "." + table3ID + " AS " + table3 + "Col, " +
				table4 + "." + table4ID + " AS " + table4 + "Col " +
				"FROM " + table1 + 
				" JOIN " +table2 + " ON (" + table1 +"." + table1ID1 + " = " + table2 + ".id ) " +
				"JOIN  " + table3 + " ON (" + table1 +"." + table1ID2 + " = " + table3 + ".id ) " +
				"JOIN  " + table4 + " ON (" + table1 +"." + table1ID3 + " = " + table4 + ".id ) " +
				"WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%' ORDER BY " + PK + " ASC";
		else
			sql = "SELECT " + table1 + ".*, " + 
					table2 + "." + table2ID + " AS " + table2 + "Col, " +
					table3 + "." + table3ID + " AS " + table3 + "Col, " +
					table4 + "." + table4ID + " AS " + table4 + "Col " +
					"FROM " + table1 + 
					" JOIN " +table2 + " ON (" + table1 +"." + table1ID1 + " = " + table2 + ".id ) " +
					"JOIN  " + table3 + " ON (" + table1 +"." + table1ID2 + " = " + table3 + ".id ) " +
					"JOIN  " + table4 + " ON (" + table1 +"." + table1ID3 + " = " + table4 + ".id ) " +
					"WHERE " + table1 + "." + PK + " LIKE '" + searchKey + "'";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public ResultSet join3Tables(String PK, String table1ID1, String table2ID, String table1ID2, String table3ID, String table1, String table2, String table3, String searchKey){
		Statement statement;
		searchKey = fixSpecialCharacters(searchKey);
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT " + table1 + ".*, " + 
					table2 + "." + table2ID + " AS " + table2 + "Col, " +
					table3 + "." + table3ID + " AS " + table3 + "Col " +
					"FROM " + table1 + 
					" JOIN " +table2 + " ON (" + table1 +"." + table1ID1 + " = " + table2 + ".id ) " +
					"JOIN  " + table3 + " ON (" + table1 +"." + table1ID2 + " = " + table3 + ".id ) " +
					"WHERE " + table1 + "." + PK + " LIKE '%" + searchKey + "%'");
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public ResultSet mappingTableJoin3Tables(String table1ID1, String table1ID2, String table2ID, String table3ID, String table1, String table2, String table3, String searchKey){
		Statement statement;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT " + table1 + "." + table1ID2 + ", "  + 
					table2 + ".*, " +
					table3 + "." + table3ID + " AS " + table3 + "Col " +
					"FROM " + table1 + " JOIN " + table2 + " ON (" + table1 +"." + table1ID2 + " = " + table2 + ".id ) " + 
					"JOIN  " + table3 + " ON (" + table2 +"." + table2ID + " = " + table3 + ".id ) " +
					"WHERE " + table1 + "." + table1ID1 + " LIKE '" + searchKey + "'");
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public ResultSet mappingTableJoin4Tables(String table1ID1, String table1ID2, String table2ID1, String table2ID2, String table2Col, String table3Col, String table4Col,String table1, String table2, String table3, String table4, String searchKey){
		Statement statement;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT " + table1 + "." + table1ID2 + ", "  + 
					table2 + ".*, " +
					table3 + "." + table3Col + " AS " + table3 + "Col, " +
					table4 + "." + table4Col + " AS " + table4 + "Col " +
					"FROM " + table1 + " JOIN " + table2 + " ON (" + table1 +"." + table1ID2 + " = " + table2 + ".id ) " + 
					"JOIN  " + table3 + " ON (" + table2 +"." + table2ID1 + " = " + table3 + ".id ) " +
					"JOIN  " + table4 + " ON (" + table2 +"." + table2ID2 + " = " + table4 + ".id ) " +
					"WHERE " + table1 + "." + table1ID1 + " LIKE '" + searchKey + "'");
			return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public ResultSet checkmark(int id, String tableName){
		Statement statement;
		try{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * from mark " +
					"WHERE id =" + id + " AND tableName like '" + tableName + "'");
			return rs;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	public boolean mark(int id, String tableName){
		PreparedStatement statement;
		try{
			statement = connection.prepareStatement("INSERT INTO mark VALUES(" + id + ",'" + tableName + "')");
			statement.executeUpdate();
			if(statement != null) {
				  statement.close();
				  return true;
			 }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet checkIndexCode(int id,String tableName){
		Statement statement;
		try{
			statement = connection.createStatement();
			String sql = "SELECT * from codeTable " +
					"WHERE id =" + id + " AND tableName like '" + tableName + "' ORDER BY indexCode ASC";
			ResultSet rs = statement.executeQuery(sql);
			return rs;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	public boolean indexCodeUpdate(int id, String indexCode, String tableName){
		PreparedStatement statement;
		String sql = "INSERT INTO codeTable VALUES(" + id + ",'" + indexCode + "' ,'" + tableName + "')";
		try{
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			 if(statement != null) {
				  statement.close();
				  return true;
			 }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}