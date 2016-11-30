package Controller;

/**
 * 
 * @author Wanxin Li
 *
 */
public class Dance extends Controller{
	
	private String authorName;
	private String type;
	private String shape;
	public static final String[] columns = { "id", "name", "type", "shape", "author" };
	
	public Dance(int id, String name, String type, String shape, String authorName) {
		super(id,name);
		this.type = type;
		this.shape = shape;
		this.authorName = authorName;
	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
