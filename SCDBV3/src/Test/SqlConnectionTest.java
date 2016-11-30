package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before; // for @Before

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.SqlConnection;

public class SqlConnectionTest {

//	@Test
//	public void testSqlConnection() {
//		SqlConnection test = new SqlConnection();
//	}
	
	SqlConnection test;
	Connection conn;
	
	@Before
	public void initObj() {
		test = new SqlConnection();
		
		try { Class.forName("org.sqlite.JDBC");
		} catch ( ClassNotFoundException e1) { e1.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:scddata.db");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}	
	}

	@Test
	public void testSetConnection() {
		test.closeDatabase();
		
//		assertNull(test.getConnection());
		
		test.setConnection(conn);
		
		assertNotNull(test.getConnection());
	}

	@Test
	public void testGetConnection() {
		test.setConnection(conn);
		assertNotNull(test.getConnection());
	}
	
//	@Test
//	public void testCloseDatabase() {
//		test.closeDatabase();
//		assertNull(test.getConnection());
//	}

}
