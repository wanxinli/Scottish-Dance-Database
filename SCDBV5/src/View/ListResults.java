package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Album;
import Controller.Controller;
import Controller.Dance;
import Controller.Owned;
import Controller.Publication;
import Controller.Record;

/**
 *  @author tbagies
 *  
 * This class is to show a list of information that has been retrieved from database.
 * It uses all the controller classes such as Album and Dance to get the data from database
 */

public class ListResults extends JPanel{
	
	/**
	 * data members 
	 */
	private static final long serialVersionUID = 1L;
	String category="";
	JTable table;
	String searchKey;
	JScrollPane spTable;
	private DefaultTableModel model;
	
	/**
	 * 
	 * @param category
	 * @param userInput
	 * 
	 */
	public ListResults(String category,String userInput){
		this.category = category;
		searchKey = userInput;
		display();
	}
	/**
	 * Shows the information based on the category (The clicked tab on GUI)
	 */
	public void display(){

		switch(category){
			case "album":
				List<Controller> albums = Controller.searchByKey(searchKey,"album");

				if(albums.isEmpty()){
					ThrowError.errorMessage("No Results Found");
				}
				else{
					albumTable(albums);
					setupTable();
				}
				break;
			case "dance":
				List<Controller> dances = Controller.searchByKey(searchKey,"dance");
		        if (dances.isEmpty()) {
			        ThrowError.errorMessage("No Results Found");
		        } else {
			        danceTable(dances);
			        setupTable();
		        }
			break;
			case "recordings":
				List<Controller> records = Controller.searchByKey(searchKey,"recording");
				if (records.isEmpty()){
					ThrowError.errorMessage("No Results Found");
				} else {
					recordTable(records);
					setupTable();
				}
			break;
			case "publication":
				List<Controller> publications = Controller.searchByKey(searchKey,"publication");
				if (publications.isEmpty()){
					ThrowError.errorMessage("No Results Found");
				} else {
					publicationTable(publications);
					setupTable();
				}
			break;
			default:
			
		}
    }
	/**
	 * creates a table to display the retrieved information on organizing way
	 */
	private void setupTable(){
		setLayout(new BorderLayout());
		table = new JTable(model);
		spTable = new JScrollPane(table);
	    table.setPreferredScrollableViewportSize(new Dimension(900, 500));
		table.setAutoCreateRowSorter(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(0);
        table.removeColumn(table.getColumnModel().getColumn(0));
        table.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				removeAll();
				int row = (int) table.getModel().getValueAt(table.getSelectedRow(),0);
				JPanel panel = new DetailedResult(Integer.toString(row),category);
				add(panel);
//				System.out.println("FROM MOUSE CLicked");
			}

			@Override
			public void mousePressed(MouseEvent e) {				
			}

			@Override
			public void mouseReleased(MouseEvent e) {				
			}

			@Override
			public void mouseEntered(MouseEvent e) {				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
        	
        });
		add(spTable,BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * @param albums
	 * uses the controller Album class to get the information from database
	 */
	private void albumTable(List<Controller> albums){
		Object [][] data = new Object[albums.size()][Album.columns.length];
		for(int i=0; i<albums.size(); i++){
			Album album = (Album) albums.get(i);
			data[i][0] = album.getId();
			data[i][1] = album.getName();
			data[i][2] = album.getArtist();
			data[i][3] = album.getproductionyear();
			data[i][4] = Owned.isOwned(album.getId(),category);
		}
		
		model = createModel(data,Album.columns);
		
	}
	
	/**
	 * 
	 * @param dances
	 * uses the controller Dance class to get the information from database
	 */
	private void danceTable(List<Controller> dances) {
		Object [][] data = new Object[dances.size()][Dance.columns.length];
		
		for (int i = 0; i < dances.size(); i++) {
			Dance dance = (Dance) dances.get(i);
			data[i][0] = dance.getId();
			data[i][1] = dance.getName();
			data[i][2] = dance.getType();
			data[i][3] = dance.getShape();
			data[i][4] = dance.getAuthorName();
			data[i][5] = dance.getBarsperrepeat();
			data[i][6] = Owned.isOwned(dance.getId(),category);
		}
		model = createModel(data, Dance.columns);
	}
	
	/**
	 * 
	 * @param records
	 * uses the controller record class to get the information from database
	 */
	private void recordTable(List<Controller> records) {
		Object [][] data = new Object[records.size()][Record.columns.length];
		
		for(int i=0; i < records.size(); i++){
			Record record = (Record) records.get(i);
			data[i][0] = record.getId();
			data[i][1] = record.getName();
			data[i][2] = record.getArtist();
			data[i][3] = record.getTypeName().substring(0,1) + record.getBarsPerRepeat() + " " + record.getReps();
			data[i][4] = Owned.isOwned(record.getId(),category);
		}
		
		model = createModel(data,Record.columns);
	}
	
	private void publicationTable(List<Controller> publications) {
		Object [][] data = new Object[publications.size()][Publication.columns.length];
		for(int i=0; i < publications.size(); i++){
			Publication publication =  (Publication) publications.get(i);
			data[i][0] = publication.getId();
			data[i][1] = publication.getName();
			data[i][2] = publication.getPublishedBy();
			data[i][3] = publication.getYear();
			data[i][4] = Owned.isOwned(publication.getId(),category);
		}
		
		model = createModel(data,Publication.columns);
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 
	 * @param data
	 * @param columns
	 * @return DefaultTableModel
	 * 
	 * creates a model needed by for JTable
	 */
	private DefaultTableModel createModel(Object[][] data, String[] columns){
		
		return new DefaultTableModel(data, columns) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
	}
}
