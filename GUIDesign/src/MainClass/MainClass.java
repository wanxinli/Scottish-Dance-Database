package MainClass;
import java.awt.EventQueue;


/*
 * Written by Taghreed Bagies
 */
import GUIV6.FrameDB;

public class MainClass {
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	FrameDB frame = new FrameDB();
	            }
	        });
    }
}
