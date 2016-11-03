package Testing;
/*
 * Written By Taghreed Bagies
 */	

import static org.junit.Assert.*;

import org.junit.Test;

import DataBase.SqlConnection;
import DataBase.SqlQuery;

public class QueryTest {

	@Test
	public void testTheSizeofList() {
		SqlConnection con = new SqlConnection();  
		SqlQuery sql = new SqlQuery(con.getConnection(),"dance");
		int size = sql.searchByName("Lazy").size();
		assertEquals(4,size);
	}

	@Test
	public void testUnexistedValue() {
		SqlConnection con = new SqlConnection();  
		SqlQuery sql = new SqlQuery(con.getConnection(),"dance");
		boolean flag = sql.searchByName("abcjuy").isEmpty();
		assertEquals(true,flag);
	}
	
	@Test
	public void testPassingNumber() {
		SqlConnection con = new SqlConnection();  
		SqlQuery sql = new SqlQuery(con.getConnection(),"dance");
		boolean flag = sql.searchByName("765657").isEmpty();
		assertEquals(true,flag);
	}
	
	@Test
	public void tesWrongTableName() {
		SqlConnection con = new SqlConnection();  
		SqlQuery sql = new SqlQuery(con.getConnection(),"khdkwhd");
		boolean flag = sql.searchByName("Lazy").isEmpty();
		assertEquals(true,flag);
	}
}
