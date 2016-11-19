package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.SqlConnection;
import Model.SqlQuery;

public class Tune /*extends CategoryObj*/{

	public Tune() {
		// TODO Auto-generated constructor stub
	}
	
	private int idValue1;
	private String nameValue1;
	private int composer_idValue;
	public static final String [] columns = {"id","name", "composer_id"};

	public int getId() {
		return idValue1;
	}

	public void setId(int id) {
		this.idValue1 = id;
	}
	
	
	public int getcomposer_id() {
		return composer_idValue;
	}

	public void setcomposer_id(int composer_id) {
		this.composer_idValue = composer_id ;
	}
	
	public String getname() {
		return nameValue1;
	}

	public void setname(String name) {
		this.nameValue1 = name;
	}
	
	public Tune(int id, String name, int composer_id) {
		this.idValue1 = id;
		this.nameValue1 = name;
		this.composer_idValue = composer_id;
	}
	
	public static List<Tune> searchByKey(String searcKey)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"tune");
		ResultSet results = query.searchByName("name", searcKey);
		List<Tune> tunes = new ArrayList<Tune>();
		try {
			while(results.next()){
				Tune tune = new Tune(results.getInt("id"), results.getString("name"),results.getInt("composer_id"));
				tunes.add(tune);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tunes;
	}
}