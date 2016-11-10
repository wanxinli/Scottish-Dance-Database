package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SqlConnection;
import Model.SqlQuery;

public class TunesRecordingsMap {
	private int id;
	private int tune_id;
	private int alias_id;
	private int recording_number;
	private int number;
	
	public TunesRecordingsMap(){}
	
	public TunesRecordingsMap(int id, int tune_id, int alias_id, int recording_number, int number){
		this.id = id;
		this.tune_id = tune_id;
		this.alias_id = alias_id;
		this.recording_number = recording_number;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTune_id() {
		return tune_id;
	}

	public void setTune_id(int tune_id) {
		this.tune_id = tune_id;
	}

	public int getAlias_id() {
		return alias_id;
	}

	public void setAlias_id(int alias_id) {
		this.alias_id = alias_id;
	}

	public int getRecording_number() {
		return recording_number;
	}

	public void setRecording_number(int recording_number) {
		this.recording_number = recording_number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static List<TunesRecordingsMap> searchByKey(String searchKey) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"albumsrecordingsmap");
		ResultSet results = query.searchByName("name", searchKey);
		List<TunesRecordingsMap> recordingTuneMapList = new ArrayList<TunesRecordingsMap>();
		try {
			while(results.next()){
				TunesRecordingsMap newTuneRecordingMap = new TunesRecordingsMap(results.getInt("id"), results.getInt("tune_id"), results.getInt("alias_id"), results.getInt("recording_number"), results.getInt("number"));
				recordingTuneMapList.add(newTuneRecordingMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordingTuneMapList;
	}
	
}
