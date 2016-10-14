package DataBase;
/*
 * Written By Taghreed Bagies
 */

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Dance;

public class SqlQuery
{
	private Connection connection = null;
	private String table;
	public SqlQuery(Connection con, String tableName){
		connection = con;
		table = tableName;
	}
	    
	public List<Dance> searchByName(String searchKey){
		Statement statement;
		List<Dance> dances = new ArrayList<Dance>();
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + " WHERE NAME  LIKE '%" + searchKey + "%'");
			//ResultSetMetaData md = rs.getMetaData();
			/*
			 * Create Dance class 
			 * pass the result to it
			 */
			while(rs.next()){
				int id = rs.getInt("id");
				int type_id = rs.getInt("type_id");
				int intensity = rs.getInt("intensity");
				int shape_id = rs.getInt("shape_id");
				int couples_id = rs.getInt("couples_id");
				int devisor_id = rs.getInt("devisor_id");
				int data_verified = rs.getInt("data_verified");
				int progression_id = rs.getInt("progression_id");
				int steps_verified = rs.getInt("steps_verified");
				int tunes_verified = rs.getInt("tunes_verified");
				int medley_type_id = rs.getInt("medleytype_id");
				int bars_per_repeat = rs.getInt("barsperrepeat");
				int intensity_per_turn = rs.getInt("intensity_per_turn");
				int formations_verified = rs.getInt("formations_verified");
				String name = rs.getString("name");
				String notes = rs.getString("notes");
				String ucname = rs.getString("ucname");
				String intensity_bars = rs.getString("intensity_bars");
				Dance aDance = new Dance(id,type_id,intensity, shape_id, couples_id, devisor_id, data_verified,
						progression_id, steps_verified, tunes_verified, medley_type_id, bars_per_repeat,
						intensity_per_turn, formations_verified,
						name, notes, ucname, intensity_bars);
				dances.add(aDance);
			}
		/*	for(int i=1; i<=md.getColumnCount(); i++)
			{
				str.append(md.getColumnLabel(i) + "     ");
			}
			str.append("\n");
			while(rs.next()){
				//Dance aDance = new Dance();
				for(int i=1; i<=md.getColumnCount(); i++)
				{
					str.append(rs.getString(md.getColumnLabel(i)) + "     ");
				}
				str.append("\n");
			}*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return dances;
	}
}