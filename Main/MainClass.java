package Main;
import java.util.List;

import DataBase.SqlConnection;
import DataBase.SqlQuery;
import GUI.FirstWindow;
import Object.Dance;

/*
 * Written By Taghreed Bagies
 */

public class MainClass {
	  public static void main(String[] args) throws ClassNotFoundException
	  {
		  FirstWindow win = new FirstWindow();
	  }
	  public static void run(String searchKey){
		  SqlConnection con = new SqlConnection();  
		  SqlQuery sql = new SqlQuery(con.getConnection(),"dance");
		  List<Dance> dances = sql.searchByName(searchKey);
		  if(dances.isEmpty())
			  System.out.print("Noting in Database with dance name " + searchKey);
		  else
			  System.out.print(dances.size());
	  }
}
