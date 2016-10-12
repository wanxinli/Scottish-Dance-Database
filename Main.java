package main;

import java.util.List;
import java.util.Scanner;
import gui.j1;
import gui.jFrame;

import java.sql.Connection;

import objects.Dance;
import sql.SqlConnection;
import sql.SqlQuery;

public class Main {

	public static void main(String[] args) {

		// Database connect
		SqlConnection sqlconn = new SqlConnection();
		Connection conn = sqlconn.getConnection();
		SqlQuery sqlqry = new SqlQuery(conn, "dance");

		// GUI Open--------------------------------------------------------
		// input
		j1 frame1 = new j1();
		frame1.setVisible(true);
		System.out.println(frame1.getInput());
		System.out.println(frame1.isFlag());
		List<Dance> result_list = sqlqry.searchByName(frame1.getInput());
		if(frame1.isFlag()){
			jFrame jframe = new jFrame();
			jframe.setVisible(true);
		}
		// output (print in console temporarily)
		for (int i = 0; i < result_list.size(); i++) {
			System.out.println("name: " + result_list.get(i).getName());
			System.out.println("type_id: " + result_list.get(i).getType_id());
			System.out.println("shape_id: " + result_list.get(i).getShape_id());
			System.out.println();
		}
		// GUI Close-----------------------------------------------------------

		
		
		
		// Console Open----------------------------------------------------
		 // input
//		 System.out.println("Search:");
//		 Scanner scan = new Scanner(System.in);
//		 String str = scan.nextLine();
//		 List<Dance> result_list = sqlqry.searchByName(str);
//		 scan.close();
//		
//		 // output
//		 System.out.println(result_list.size());
//		 for (int i = 0; i < result_list.size(); i++) {
//		 System.out.println("name: " + result_list.get(i).getName());
//		 System.out.println("type_id: " + result_list.get(i).getType_id());
//		 System.out.println("shape_id: " + result_list.get(i).getShape_id());
//		 System.out.println();
//		 }
		// Console Close-------------------------------------------------------

		sqlconn.closeDatabase();
	}

}
