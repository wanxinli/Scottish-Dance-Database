package Controller;

import java.util.List;

/** written by Namami **/

public class Album extends Controller{
	private String name;
	private int productionyearValue;
	private int artist_idValue;
	private String artist;
	private String short_nameValue;
	private String indexCode;
	
	private List<Record> records;
	public List<Record> getRecords() {
		return records;
	}

	public void setRecord(List<Record> records) {
		this.records = records;
	}
	
	public static final String [] columns = {"id","Name", "Artist","Productionyear","Index Code", "Marked"};
	
	public String getname1() {
		return name;
	}

	public void setname1(String name) {
		this.name = name;
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
	public Album(int id, String name, int productionyear, String artist) {
		super(id, name);
		this.productionyearValue = productionyear;
		this.artist = artist;
	}
	public Album(int id, String name, String shortname){
		super(id, name);
		this.short_nameValue = shortname;
	}
	
	public Album( String name) {
		super(-1,name);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getShortName() {
		return short_nameValue;
	}
	public void setShortName(String shortname){
		this.short_nameValue = shortname;
	}
	
	private Media media;

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	
}