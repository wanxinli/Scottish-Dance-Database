package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Model.SqlQuery;

public class SqlQueryTest {

	SqlQuery test;
	Connection conn;
	
	@Before
	public void initObj() {
		
		try { Class.forName("org.sqlite.JDBC");
		} catch ( ClassNotFoundException e1) { e1.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:scddata.db");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}	
		
		test = new SqlQuery(conn, "recording");

	}
	
	@Test
	public void testSearchByName() {
		assertNotNull(test.searchByName("name", "Le Train"));
		// add more later....
	}

	@Test
	public void testJoin2Tables() {
		assertNotNull(test.join2Tables("name", "artist_id", "display_name", "recording", "person", "modern"));
		// add more later.
	}

	@Test
	public void testJoin4Tables() { //@TODO
		// Ill get back to this later fail("Not yet implemented");
	}

}
