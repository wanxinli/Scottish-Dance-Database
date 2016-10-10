package main;

import java.sql.Connection;

import sql.SqlConnection;
import sql.SqlQuery;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlConnection SqlC = new SqlConnection();
		Connection conn = SqlC.getConnection();
		SqlQuery SqlQ = new SqlQuery(conn, "dance");
		
		System.out.println(SqlQ.searchByName("T.A.Norris"));
		
		// c.closeDatabase();
	}

}
