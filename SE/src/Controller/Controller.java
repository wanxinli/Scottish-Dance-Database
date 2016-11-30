package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.SqlConnection;
import Model.SqlQuery;
/**
 * 
 * @author tbagies
 * This class is a super class that is inherited by all controller classes
 */
public abstract class Controller {
	
	private int id;
	private String name;
	
	public Controller(int id, String name){
		this.id = id;
		this.name = name;
	}
	public static Controller searchByID(String id, String tableName)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),tableName);
		ResultSet results = query.searchByName("id", id);
		Controller controller = null;
		try {
		switch(tableName){
		case "tune":
			results = query.join2Tables("id", "composer_id", "name", "tune", "person", id);
			if(results.next()){
				controller = new Tune(results.getInt("id"),results.getString("name"),results.getString("personCol"));
			}
			break;	
		case "recording":
			results = query.join3Tables("id", "artist_id", "display_name", "type_id", "name", "recording", "person","dancetype", id);
			if(results.next()){
				controller = new Record(results.getInt("id"), results.getString("name"),results.getString("personCol"),results.getString("dancetypeCol"), 
						results.getInt("repetitions"), results.getInt("barsperrepeat"));
				List<Tune> tunes = new ArrayList<Tune>();
				results = query.mappingTableJoin3Tables("recording_id", "tune_id","composer_id", "name", "tunesrecordingsmap", "tune","person", id);
				while(results.next()){
					Tune tune= new Tune(results.getInt("id"),results.getString("name"),results.getString("personCol"));
					tunes.add(tune);
				}
				((Record) controller).setTunes(tunes);
			}
			break;
			case "publication":
				results = query.join2Tables("id", "devisor_id", "name", "publication", "person", id);
				if(results.next()){
					controller = new Publication(results.getInt("id"), results.getString("name"), results.getString("name"), results.getString("personCol"), results.getInt("year"), results.getBoolean("onpaper"));
				}
				break;
				
			case "album":
				results = query.searchByName("id", id);
				if(results.next()){
					controller = new Album(results.getInt("id"), results.getString("name"),results.getString("shortname"));
					results = query.join2Tables("album_id","media_id" , "name", "media", "mediatype", id);
					if(results.next()){
						Media media = new Media(results.getInt("id"), results.getString("mediatypeCol"));
					((Album) controller).setMedia(media);
					}
				}
				break;
		/*	
			case "media":
				results = query.searchByName("album_id", id);
				while(results.next()){
					controller = new Media(results.getInt("id"), results.getString("name"), results.getInt("album_id"), results.getInt("media_id"),results.getString("catalognumber"),results.getInt("year"));
				}
				break;
				*/
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return controller;
	}
	
	public static List<Controller> searchByKey(String searchKey,String tableName)
	{
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),tableName);
		List<Controller> controllers = new ArrayList<Controller>();
		try {
		ResultSet results;
		switch(tableName){
			case "dance":
				results = query.join4Tables("name", "devisor_id", "type_id", "shape_id", "name","name","name","dance","person","dancetype", "shape", searchKey);
				try {
					while (results.next()) {
						Dance dance = new Dance(results.getInt("id"), results.getString("name"),results.getString("dancetypeCol"), results.getString("shapeCol"),results.getString("personCol"));
						controllers.add(dance);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "album":
				results = query.join2Tables("name", "artist_id", "display_name", "album", "person", searchKey);
				try {
					while(results.next()){
						Album album = new Album(results.getInt("id"), results.getString("name"),results.getInt("productionyear"),results.getString("personCol"));
						controllers.add(album);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "recording":
			results = query.join2Tables("name", "artist_id", "display_name", "recording", "person", searchKey);
			try {
				while(results.next()){
					Record recording = new Record(results.getInt("id"), results.getString("name"),results.getString("personCol"),results.getInt("type_id"), 
							results.getInt("repetitions"), results.getInt("barsperrepeat"), results.getInt("playingseconds"));
					controllers.add(recording);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			case "publication":
				results = query.join2Tables("name", "devisor_id", "name", "publication", "person", searchKey);
				while(results.next()){
					Publication Publication = new Publication(results.getInt("id"), results.getString("name"), results.getString("personCol"), results.getInt("year"));
					controllers.add(Publication);
				}
				break;
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return controllers;
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
	
	public static List<Controller> getListRecords(String id, String tableName){
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),tableName);
		List<Controller> controllers = new ArrayList<Controller>();
		ResultSet results = query.searchByName("id", id);
		try {
		switch(tableName){
			case "album":
				results = query.mappingTableJoin3Tables("album_id", "recording_id", "artist_id", "display_name", "albumsrecordingsmap", "recording","person", id);
				while(results.next()){
					Record controller = new Record(results.getInt("id"), results.getString("name"),results.getString("personCol"),results.getInt("type_id"), 
							results.getInt("repetitions"), results.getInt("barsperrepeat"), results.getInt("playingseconds"));
					
					List<Tune> tunes = new ArrayList<Tune>();
					ResultSet result2 = query.mappingTableJoin3Tables("recording_id", "tune_id","composer_id", "name", "tunesrecordingsmap", "tune","person", id);
					while(result2.next()){
						Tune tune= new Tune(result2.getInt("id"),result2.getString("name"),result2.getString("personCol"));
						tunes.add(tune);
					}
					((Record) controller).setTunes(tunes);
					controllers.add(controller);
				}
				break;
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return controllers; 
	}
	
}
