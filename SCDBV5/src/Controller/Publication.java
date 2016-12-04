package Controller;

public class Publication extends Controller{

	private int Year_idValue;
	private String publishedBy;
	private boolean onpaper;
	private String shortName;
	
	public static final String [] columns = {"id","name","published_by", "year", "marked"};
	
	public Publication(int id, String name, String publishedBy , int Year_id) {
		super(id,name);
		this.Year_idValue = Year_id;
		this.publishedBy = publishedBy;
	}
	public Publication(int id, String name, String shortName, String publishedBy , int Year_id, boolean onpaper) {
		super(id,name);
		this.Year_idValue = Year_id;
		this.publishedBy = publishedBy;
		this.setShortName(shortName);
		this.setOnpaper(onpaper);
	}
	//Wanxin
	
	public Publication(int id, String name){
		super(id, name);
	}
	
	//
	
	public int getYear() {
		return Year_idValue;
	}

	public void setYear(int year_idValue) {
		Year_idValue = year_idValue;
	}
	
	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	public boolean isOnpaper() {
		return onpaper;
	}

	public void setOnpaper(boolean onpaper) {
		this.onpaper = onpaper;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
}
