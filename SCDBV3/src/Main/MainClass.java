package Main;

import java.awt.EventQueue;
import View.FrameDB;
/**
 * 
 * @author tbagies
 * This the main class. It creates an object of FrameDB.
 */
public class MainClass {
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	FrameDB frame = new FrameDB();
	            }
	        });
    }
}
