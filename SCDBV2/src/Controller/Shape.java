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
public class Shape extends CategoryObj{
	private int id;
	private String name;
	private String short_name;

	public Shape(int id, String name, String short_name) {
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

	public static List<Shape> searchByKey(String searcKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(), "shape");
		ResultSet results = query.searchByName("name", searcKey);
		List<Shape> shapes = new ArrayList<Shape>();
		try {
			while (results.next()) {
				Shape shape = new Shape(results.getInt("id"), results.getString("name"), results.getString("shortname"));
				shapes.add(shape);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shapes;
	}

}
