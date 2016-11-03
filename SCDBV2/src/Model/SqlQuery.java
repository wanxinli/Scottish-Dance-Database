package Model;
/*
 * Written By Taghreed Bagies
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author tbagies
 *
 */
public class SqlQuery
{
	/**
	 * Data fileds
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
	 * @return list<Dance>
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
}