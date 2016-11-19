package Controller;

public class Record extends Controller{
	private int artistId; 		// Artist
	private int typeId;			// single character {R,S,M,J,h,etc}
	private int reps;			// repetitions
	private int barsPerRepeat;	// bars per repetition
	private int playTime;		// length of the recording
	private String artist;
	
	public static final String [] columns = {"id","name","artist", "type", "repetitions", "barsperrepeat", "playingseconds"};

	public Record(int id, String name, String artist, int typeId, int reps, int barsPerRepeat, int playTime){
		super(id,name);
		this.artist = artist;
		this.typeId = typeId;
		this.reps = reps;
		this.barsPerRepeat = barsPerRepeat;
		this.playTime = playTime;
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

public String getArtist() {
	return artist;
}

public void setArtist(String artist) {
	this.artist = artist;
}
	
	
}