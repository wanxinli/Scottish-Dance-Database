package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SqlConnection;
import Model.SqlQuery;

public class Record extends CategoryObj {
	private int id;				// *Needed*
	private String name; 		// Name
	private int artistId; 		// Artist
	private int typeId;			// single character {R,S,M,J,h,etc}
	private int reps;			// repetitions
	private int barsPerRepeat;	// bars per repetition
	private int playTime;		// length of the recording
	public static final String [] columns = {"id","name","artist_id", "type_id", "repetitions", "barsperrepeat", "playingseconds"};

	public Record(){}

	public Record(int id, String name, int artistId, int typeId, int reps, int barsPerRepeat, int playTime){
		this.id = id;
		this.name = name;
		this.artistId = artistId;
		this.typeId = typeId;
		this.reps = reps;
		this.barsPerRepeat = barsPerRepeat;
		this.playTime = playTime;
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

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getBarsPerRepeat() {
		return barsPerRepeat;
	}

	public void setBarsPerRepeat(int barsPerRepeat) {
		this.barsPerRepeat = barsPerRepeat;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public static String[] getColumns() {
		return columns;
	}

	public static List<Record> searchByKey(String searchKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"recording");
		ResultSet results = query.searchByName("name", searchKey);
		List<Record> records = new ArrayList<Record>();
		try {
			while(results.next()){
				Record recording = new Record(results.getInt("id"), results.getString("name"),results.getInt("artist_id"),results.getInt("type_id"), 
						results.getInt("repetitions"), results.getInt("barsperrepeat"), results.getInt("playingseconds"));
				records.add(recording);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;
	}
}