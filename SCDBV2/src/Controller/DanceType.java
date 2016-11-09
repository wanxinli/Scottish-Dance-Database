package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SqlConnection;
import Model.SqlQuery;

/**
 * 
 * @author Wanxin Li
 *
 */
public class DanceType extends CategoryObj {
	private int id;
	private String name;
	private String short_name;
	public static final String[] columns = { "id", "name", "short_name"};
	
	public DanceType(int id, String name, String short_name) {
		this.id = id;
		this.name = name;
		this.short_name = short_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public static List<DanceType> searchByKey(String searcKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(), "dancetype");
		ResultSet results = query.searchByName("name", searcKey);
		List<DanceType> dancetypes = new ArrayList<DanceType>();
		try {
			while (results.next()) {
				DanceType dancetype = new DanceType(results.getInt("id"), results.getString("name"), results.getString("short_name"));
				dancetypes.add(dancetype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dancetypes;
	}

}
