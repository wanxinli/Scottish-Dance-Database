package Main;

/*
 * Written by Taghreed Bagies
 */

import java.awt.EventQueue;
import View.FrameDB;

public class MainClass {
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	FrameDB frame = new FrameDB();
	            }
	        });
    }
}
