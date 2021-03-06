package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public static Controller searchByID(String id, String tableName) {
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),tableName);
		ResultSet results = query.searchByName("id", id);
		Controller controller = null;
		try {
		switch(tableName){
		//Wanxin
			case "dance":
				results = query.join4Tables("id", "devisor_id", "type_id", "shape_id", "name", "name", "name", "dance",
						"person", "dancetype", "shape", id);
				if (results.next()) {
					controller = new Dance(results.getInt("id"), results.getString("name"),
							results.getString("dancetypeCol"), results.getString("shapeCol"),
							results.getString("personCol"), results.getInt("barsperrepeat"));

					List<Formation> formations = new ArrayList<Formation>();
					results = query.join2Tables("dance_id", "formation_id", "name", "dancesformationsmap", "formation",
							id);
					while (results.next()) {
						Formation formation = new Formation(results.getInt("id"), results.getString("formationCol"));
						formations.add(formation);
					}
					((Dance) controller).setFormations(formations);
					results = query.join2Tables("dance_id", "publication_id", "name", "dancespublicationsmap","publication", id);
					if(results.next()){
						Publication publication = new Publication(results.getInt("id"), results.getString("publicationCol"));
						((Dance) controller).setPublication(publication);
					}
				}
				break;
		 //
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
			}
			break;
			case "publication":
				results = query.join2Tables("id", "devisor_id", "name", "publication", "person", id);
				if(results.next()){
					controller = new Publication(results.getInt("id"), results.getString("name"), results.getString("shortname"), results.getString("personCol"), results.getInt("year"), results.getBoolean("onpaper"));
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
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		con.closeDatabase();
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
						Dance dance = new Dance(results.getInt("id"), results.getString("name"),results.getString("dancetypeCol"), results.getString("shapeCol"),results.getString("personCol"),results.getInt("barsperrepeat"));
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
				results = query.join3Tables("name", "artist_id", "display_name", "type_id", "name", "recording", "person","dancetype", searchKey);

			try {
				while(results.next()){
					Record recording = new Record(results.getInt("id"), results.getString("name"),results.getString("personCol"),results.getString("dancetypeCol"), 
							results.getInt("repetitions"), results.getInt("barsperrepeat"));
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
		con.closeDatabase();
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
	
	public static List<Controller> getList(String id, String tableName){
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),tableName);
		List<Controller> controllers = new ArrayList<Controller>();
		ResultSet results= query.searchByName("id", id);
		try {
		switch(tableName){
			case "album":
				results = query.mappingTableJoin4Tables("album_id", "recording_id", "artist_id", "type_id", "name", "display_name", "name", "albumsrecordingsmap", "recording","person","dancetype", id);
				while(results.next()){
					Record controller = new Record(results.getInt("id"), results.getString("name"),results.getString("personCol"),results.getString("dancetypeCol"), 
							results.getInt("repetitions"), results.getInt("barsperrepeat"));
					controllers.add(controller);
				}
				break;
			case "recording":
				results = query.mappingTableJoin3Tables("recording_id", "tune_id","composer_id", "name", "tunesrecordingsmap", "tune","person", id);
				while(results.next()){
					Tune tune= new Tune(results.getInt("id"),results.getString("name"),results.getString("personCol"));
					controllers.add(tune);
					}
				break;
			case "publication":
				results = query.mappingTableJoin3Tables("publication_id", "dance_id","type_id", "name", "dancespublicationsmap", "dance","dancetype", id);
				while(results.next()){
					Dance dance= new Dance(results.getInt("id"),results.getString("name"),results.getString("dancetypeCol"), results.getInt("barsperrepeat"));
					controllers.add(dance);
					}
				break;
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		con.closeDatabase();
		return controllers; 
	}
	
	
	public static char checkMarked(int id, String tableName){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:markeddb.db");
			SqlQuery query = new SqlQuery(connection,tableName);
			ResultSet results = query.checkmark(id,tableName);
			if(results.next()){
				connection.close();
				return '*';
			}
			connection.close();
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return ' ';
	}
	
	public static boolean mark(String id, String tableName){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:markeddb.db");
			SqlQuery query = new SqlQuery(connection,tableName);
			boolean flag = 	query.mark(Integer.parseInt(id),tableName);
			connection.close();
			return flag; 
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public static String getCodeIndex(int id, String tableName){
		Connection connection = null;
		String indexCode  = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:markeddb.db");
			SqlQuery query = new SqlQuery(connection,"codeTable");
			ResultSet rs = 	query.checkIndexCode(id,tableName);
			if(rs.next())
				indexCode = rs.getString("indexCode");
			connection.close();
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return indexCode;
	}
	
	public static boolean addIndexCode(String id,String indexCode, String tableName){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:markeddb.db");
			SqlQuery query = new SqlQuery(connection,"codeTable");
			boolean flag = 	query.indexCodeUpdate(Integer.parseInt(id),indexCode,tableName);
			connection.close();
			return flag; 
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public static Controller getAlbumFromRecording(int id){
		SqlConnection con = new SqlConnection();
		SqlQuery query = new SqlQuery(con.getConnection(),"album");
		
		Album alb = null;
		try {
			ResultSet results= query.join2Tables("recording_id","album_id","name","albumsrecordingsmap", "album", ""+id);
			if(results.next())
				alb = new Album(results.getString("albumCol"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alb;
	}
}
