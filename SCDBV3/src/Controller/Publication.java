package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.SqlConnection;
import Model.SqlQuery;

public class Publication {

	private int idValue1;
	private String nameValue1;
	private int Year_idValue;
	private String publishedBy;
	public static final String [] columns = {"id","name","published_by", "year"};

	public int getId() {
		return idValue1;
	}

	public void setId(int id) {
		this.idValue1 = id;
	}
	
	public String getname() {
		return nameValue1;
	}

	public void setname(String name) {
		this.nameValue1 = name;
	}
	
	public Publication(int id, String name, int Year_id) {
		this.idValue1 = id;
		this.nameValue1 = name;
		this.Year_idValue = Year_id;
	}
	
	public int getYear_idValue() {
		return Year_idValue;
	}

	public void setYear_idValue(int year_idValue) {
		Year_idValue = year_idValue;
	}
	/*
	 * Edited by Taghreed
	 */
	public static List<Publication> searchByKey(String searchKey)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"publication");
		ResultSet results = query.join2Tables("name", "devisor_id", "name", "publication", "person", searchKey);
		List<Publication> Publications = new ArrayList<Publication>();
		try {
			while(results.next()){
				Publication Publication = new Publication(results.getInt("id"), results.getString("name"), results.getString("personCol"), results.getInt("year"));
				Publications.add(Publication);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publications;
	}
	
	public Publication(int id, String name, String publishedBy , int Year_id) {
		this.idValue1 = id;
		this.nameValue1 = name;
		this.Year_idValue = Year_id;
		this.publishedBy = publishedBy;
	}

	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}
	
	
}