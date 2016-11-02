package Controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import DataBase.SqlConnection;
import DataBase.SqlQuery;
import Object.Dance;

public class DanceController {

	public void SearchbyKey() {
		// Database Connect
		SqlConnection sqlconn = new SqlConnection();
		Connection conn = sqlconn.getConnection();

		SqlQuery sqlqry = new SqlQuery(conn, "dance");

		// input
		System.out.println("Search:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		List<Dance> result_list = sqlqry.searchByName(str);
		scan.close();
		// output
		System.out.println(result_list.size());
		for (int i = 0; i < result_list.size(); i++) {
			System.out.println("name: " + result_list.get(i).getName());
			System.out.println("type_id: " + result_list.get(i).getType_id());
			System.out.println("shape_id: " + result_list.get(i).getShape_id());
			System.out.println("devisor_id: " + result_list.get(i).getDevisor_id());
			System.out.println();
		}
		sqlconn.closeDatabase();
	}
}
