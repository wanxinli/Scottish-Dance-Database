package db;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class SqlConnection
	{
		Connection connection = null;
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
		public void closeDatabase()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public Connection getConnection() {
			return connection;
		}
		public void setConnection(Connection connection) {
			this.connection = connection;
		}
		
	}

