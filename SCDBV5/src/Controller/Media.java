package Controller;

public class Media extends Controller {



		private int yearValue;
		private int album_idValue;
		private int media_idValue;
		private String catalognumber_Value;
		
		public static final String [] columns = {"id","name", "album_id", "media_id","catalognumber","year"};
		
		
		public int getyear() {
			return yearValue;
		}

		public void setproductionyear(int year) {
			this.yearValue = year;
		}
		
		public int getalbum_id() {
			return album_idValue;
		}

		public void setartist_id(int album_id) {
			this.album_idValue = album_id;
		}
		public int getmedia_id() {
			return media_idValue;
		}

		public void setmedia_id(int media_id) {
			this.media_idValue = media_id;
		}
		public Media(int id, String name)
		{
			 super(id, name);
		}
		public Media(int id, String name, int album_id, int media_id, String catalognumber , int year) {
		    super(id, name);
			this.album_idValue = album_id;
			this.media_idValue = media_id;
			this.yearValue = year;
			this.catalognumber_Value = catalognumber;
		}
		
		public String getcatalognumber() {
			return catalognumber_Value;
		}

		public void setcatalognumber(String catalognumber) {
			this.catalognumber_Value = catalognumber;
		}
	}

