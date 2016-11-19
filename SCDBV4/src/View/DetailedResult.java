package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Album;
import Controller.Controller;
import Controller.Dance;
import Controller.Publication;
import Controller.Record;

/**
 * 
 * @author tbagies
 * 
 * This class is responsible to show the details information about a particular record on the database
 * It is not working now it will be implemented on sprint5
 */


public class DetailedResult extends JPanel{
	private static final long serialVersionUID = 1L;
	private String id;
	private String category;
	
	public DetailedResult(String id, String category) {
		super();
		this.id = id;
		this. category = category;
		display();
	}
	
	public void display(){
		switch(category){
			case "publication":
				Controller publication = Publication.searchByID(id,"publication");
				if(publication == null)
					ThrowError.errorMessage("You should clicked on a record on the table");
				else{
					publicationInfo(publication);
				}
			break;
			default:
			
		}
    }
	
	private void publicationInfo(Controller publication) {
		this.setLayout(new BorderLayout());
		Publication pub =  (Publication) publication;
		JLabel title = new JLabel("Publication: " + pub.getName());
		title.setForeground(Color.RED);
		add(title,BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		panel.add(new JLabel("Short name"));
		panel.add(new JLabel(pub.getShortName()));
		panel.add(new JLabel("Published by"));
		panel.add(new JLabel(pub.getPublishedBy()));
		panel.add(new JLabel("Date"));
		panel.add(new JLabel(""+pub.getYear()));
		panel.add(new JLabel("Available on paper"));
		panel.add(new JLabel(pub.isOnpaper()?"yes":"no"));
		add(panel,BorderLayout.CENTER);
	}
	

}
