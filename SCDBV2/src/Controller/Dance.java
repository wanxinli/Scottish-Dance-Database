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
public class Dance extends CategoryObj {
	private int id;
	private String name;
	private int type_id;
	private int shape_id;
	private int devisor_id;
	public static final String[] columns = { "id", "Name", "Type", "Shape", "Author" };

	public Dance(int id, String name, int type_id, int shape_id, int devisor_id) {
		this.id = id;
		this.name = name;
		this.type_id = type_id;
		this.shape_id = shape_id;
		this.devisor_id = devisor_id;
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

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getShape_id() {
		return shape_id;
	}

	public void setShape_id(int shape_id) {
		this.shape_id = shape_id;
	}

	public int getDevisor_id() {
		return devisor_id;
	}

	public void setDevisor_id(int devisor_id) {
		this.devisor_id = devisor_id;
	}

	public static List<Dance> searchByKey(String searcKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(), "dance");
		ResultSet results = query.searchByName("name", searcKey);
		List<Dance> dances = new ArrayList<Dance>();
		try {
			while (results.next()) {
				Dance dance = new Dance(results.getInt("id"), results.getString("name"),
						results.getInt("type_id"), results.getInt("shape_id"),results.getInt("devisor_id"));
				dances.add(dance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dances;
	}
}
