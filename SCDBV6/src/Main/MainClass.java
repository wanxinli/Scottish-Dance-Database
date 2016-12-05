package Main;

import java.awt.EventQueue;

import Controller.Owned;
import View.FrameDB;
/**
 * 
 * @author tbagies
 * 
 * This the main class. It creates an object of FrameDB.
 */
public class MainClass {
	public static void main(String[] args) {
		
		// Calling Owned here to make sure the json file is loaded into memory
		Owned.read();
		
		 EventQueue.invokeLater(new Runnable() {
	            @SuppressWarnings("unused")
				public void run() {
	            	FrameDB frame = new FrameDB();
	            }
	        });
    }
}
