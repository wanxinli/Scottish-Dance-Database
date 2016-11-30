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
public class Person /*extends CategoryObj*/ {
	private int id;
	private String name;
	private String loctaion;
	private int byear; // birth year
	private int dyear; // dead year
	public static final String[] columns = { "id", "name", "location", "byear", "dyear" };

	public Person(int id, String name, String loctaion, int byear, int dyear) {
		super();
		this.id = id;
		this.name = name;
		this.loctaion = loctaion;
		this.byear = byear;
		this.dyear = dyear;
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

	public String getLoctaion() {
		return loctaion;
	}

	public void setLoctaion(String loctaion) {
		this.loctaion = loctaion;
	}

	public int getByear() {
		return byear;
	}

	public void setByear(int byear) {
		this.byear = byear;
	}

	public int getDyear() {
		return dyear;
	}

	public void setDyear(int dyear) {
		this.dyear = dyear;
	}

	public static List<Person> searchByKey(String searcKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(), "person");
		ResultSet results = query.searchByName("id", searcKey);
		List<Person> persons = new ArrayList<Person>();
		try {
			while (results.next()) {
				Person person = new Person(results.getInt("id"), results.getString("name"),
						results.getString("location"), results.getInt("byear"), results.getInt("dyear"));
				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}
}