package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQuery {
	private Connection connection = null;
	private String table;

	public SqlQuery(Connection con, String tableName) {
		connection = con;
		table = tableName;
	}

	public String searchByName(String name) {
		Statement statement;
		StringBuilder str = new StringBuilder("");
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + " WHERE NAME  LIKE '%" + name + "%'");
			ResultSetMetaData md = rs.getMetaData();
			/*
			 * Create Dance class pass the result to it
			 */
			for (int i = 1; i <= md.getColumnCount(); i++) {
				str.append(md.getColumnLabel(i) + "     ");
			}
			str.append("\n");
			while (rs.next()) {
				for (int i = 1; i <= md.getColumnCount(); i++) {
					str.append(rs.getString(md.getColumnLabel(i)) + "     ");
				}
				str.append("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (str.equals(""))
			return "No information on Database for " + name;
		return str.toString();
	}
}