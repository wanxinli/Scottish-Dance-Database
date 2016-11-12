package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SqlConnection;
import Model.SqlQuery;
/** written by Namami **/

public class Album {

	private int idValue;
	private int productionyearValue;
	private String nameValue;
	private int artist_idValue;
	private String artist;
	public static final String [] columns = {"id","name", "artist","productionyear"};
	
	public Album(){}
	
	public int getId() {
		return idValue;
	}

	public void setId(int id) {
		this.idValue = id;
	}
	
	public int getproductionyear() {
		return productionyearValue;
	}

	public void setproductionyear(int productionyear) {
		this.productionyearValue = productionyear;
	}
	
	public int getartist_id() {
		return artist_idValue;
	}

	public void setartist_id(int artist_id) {
		this.artist_idValue = artist_id;
	}
	
	public String getname() {
		return nameValue;
	}

	public void setname(String name) {
		this.nameValue = name;
	}
	/*Edited by Taghreed*/
	
	public Album(int id, String name, int productionyear, String artist) {
		this.idValue = id;
		this.nameValue = name;
		this.productionyearValue = productionyear;
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public static List<Album> searchByKey(String searchKey)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"album");
		ResultSet results = query.join2Tables("name", "artist_id", "display_name", "album", "person", searchKey);

		List<Album> albums = new ArrayList<Album>();
		try {
			while(results.next()){
				Album album = new Album(results.getInt("id"), results.getString("name"),results.getInt("productionyear"),results.getString("personCol"));
				albums.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}
	
}