package Model;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
/**
 * 
 * @author tbagies
 *
 */
	public class SqlConnection
	{
		/**
		 * data fields
		 */
		Connection connection = null;
		
		/**
		 * Constructor
		 */
		public SqlConnection(){
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try
			{
				// create a database connection
				connection = DriverManager.getConnection("jdbc:sqlite:scddata.db");
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
	  }
		/**
		 * closeDatabase
		 */
		public void closeDatabase()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	/**
	 * 
	 * @return connection
	 */
		public Connection getConnection() {
			return connection;
		}
		/**
		 * 
		 * @param connection
		 */
		public void setConnection(Connection connection) {
			this.connection = connection;
		}
		
	}

