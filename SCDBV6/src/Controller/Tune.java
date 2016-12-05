package Controller;

public class Tune extends Controller{
	private String composer;
	public static final String [] columns = {"id","name", "composer", "marked"};

	
	public String getcomposer() {
		return composer;
	}

	public void setcomposer(String composer) {
		this.composer = composer;
	}
	
	public Tune(int id, String name, String composer) {
		super(id,name);
		this.composer = composer;
	}
}