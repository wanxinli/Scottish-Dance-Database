package Controller;
/** written by Namami **/

public class Album extends Controller{

	private int productionyearValue;
	private int artist_idValue;
	private String artist;
	
	public static final String [] columns = {"id","name", "artist","productionyear"};
	
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
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}