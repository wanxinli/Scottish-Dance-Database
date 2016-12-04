package Controller;

import java.util.List;

/**
 * 
 * @author Wanxin Li
 *
 */
public class Dance extends Controller {

	private String authorName;
	private String type;
	private String shape;
	//
	private int barsperrepeat;
	private List<Formation> formations;
	private Publication publication;
	//
	public static final String[] columns = { "id", "name", "type", "shape", "author" };

	public Dance(int id, String name, String type, String shape, String authorName) {
		super(id, name);
		this.type = type;
		this.shape = shape;
		this.authorName = authorName;
	}

	//
	public Dance(int id, String name, String type, String shape, String authorName, int barsperrepeat) {
		super(id, name);
		this.type = type;
		this.shape = shape;
		this.authorName = authorName;
		this.setBarsperrepeat(barsperrepeat);
	}

	//
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

	//
	public int getBarsperrepeat() {
		return barsperrepeat;
	}

	public void setBarsperrepeat(int barsperrepeat) {
		this.barsperrepeat = barsperrepeat;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	//
}
