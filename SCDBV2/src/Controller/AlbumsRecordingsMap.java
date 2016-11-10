package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.SqlConnection;
import Model.SqlQuery;


public class albumsrecordingsmap extends CategoryObj{

	public albumsrecordingsmap() {
		// TODO Auto-generated constructor stub
	}
	
	private int idValue2;
	private int album_idValue2;
	private int recording_idValue;
	private int track_numberValue;
	public static final String [] columns = {"id","recording_id", "album_id","tracknumber"};
	
	public int getId() {
		return idValue2;
	}

	public void setId(int id) {
		this.idValue2 = id;
	}
	
	
	public int getalbum_id() {
		return album_idValue2;
	}

	public void setalbum_id(int album_id) {
		this.album_idValue2 = album_id ;
	}
	
	public int getrecording_id() {
		return recording_idValue;
	}

	public void setrecording_id(int recording_id) {
		this.recording_idValue = recording_id;
	}
	
	public int gettracknumber() {
		return album_idValue2;
	}

	public void settracknumber(int tracknumber) {
		this.track_numberValue = tracknumber ;
	}
	
	
	public albumsrecordingsmap(int id, int recording_id, int album_id, int tracknumber) {
		this.idValue2 = id;
		this.album_idValue2 = album_id;
		this.recording_idValue = recording_id;
		this.track_numberValue = tracknumber;
		
	}
	
	public static List<albumsrecordingsmap> searchByKey(String searcKey)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"albumsrecordingsmap");
		ResultSet results = query.searchByName("name", searcKey);
		List<albumsrecordingsmap> albumsrecordingsmaps = new ArrayList<albumsrecordingsmap>();
		try {
			while(results.next()){
				albumsrecordingsmap albumsrecordingsmap1 = new albumsrecordingsmap(results.getInt("id"), results.getInt("album_id"),results.getInt("recording_id"), results.getInt("tracknumber"));
				albumsrecordingsmaps.add(albumsrecordingsmap1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albumsrecordingsmaps;
	}

}
