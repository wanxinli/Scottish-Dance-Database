package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Album;
import Controller.Dance;
import Controller.Publication;
import Controller.Record;

/**
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
				List<Album> albums = Album.searchByKey(searchKey);
				if(albums.isEmpty()){
					ThrowError.errorMessage("There is no data matches the input ");
				}
				else{
					albumTable(albums);
					setupTable();
				}
				break;
			case "dance":
				List<Dance> dances = Dance.searchDances(searchKey);
		        if (dances.isEmpty()) {
			        ThrowError.errorMessage("There is no data matches the input ");
		        } else {
			        danceTable(dances);
			        setupTable();
		        }
			break;
			case "recordings":
				List<Record> records = Record.searchByKey(searchKey);
				if (records.isEmpty()){
					ThrowError.errorMessage("No Results Found");
				} else {
					recordTable(records);
					setupTable();
				}
			break;
			case "publication":
				List<Publication> publications = Publication.searchByKey(searchKey);
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
				JPanel panel = new JPanel();
				JLabel label = new JLabel("Detailed information " + row);
				panel.add(label);
				
				add(panel);
				System.out.println("FROM MOUSE CLicked");
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
	private void albumTable(List<Album> albums){
		Object [][] data = new Object[albums.size()][Album.columns.length];
		for(int i=0; i<albums.size(); i++){
			data[i][0] = albums.get(i).getId();
			data[i][1] = albums.get(i).getname();
			data[i][2] = albums.get(i).getArtist();
			data[i][3] = albums.get(i).getproductionyear();
		}
		model = createModel(data,Album.columns);
		
	}
	
	/**
	 * 
	 * @param dances
	 * uses the controller Dance class to get the information from database
	 */
	private void danceTable(List<Dance> dances) {
		Object [][] data = new Object[dances.size()][Dance.columns.length];
		for (int i = 0; i < dances.size(); i++) {
			data[i][0] = dances.get(i).getId();
			data[i][1] = dances.get(i).getName();
			data[i][2] = dances.get(i).getType();
			data[i][3] = dances.get(i).getShape();
			data[i][4] = dances.get(i).getAuthorName();
		}
		model = createModel(data, Dance.columns);
	}
	
	/**
	 * 
	 * @param records
	 * uses the controller record class to get the information from database
	 */
	private void recordTable(List<Record> records) {
		Object [][] data = new Object[records.size()][Record.columns.length];
		
		for(int i=0; i < records.size(); i++){
			data[i][0] = records.get(i).getId();
			data[i][1] = records.get(i).getName();
			data[i][2] = records.get(i).getArtist();
			data[i][3] = records.get(i).getTypeId();
			data[i][4] = records.get(i).getReps();
			data[i][5] = records.get(i).getBarsPerRepeat();
			data[i][6] = records.get(i).getPlayTime();
		}
		
		model = createModel(data,Record.columns);
	}
	
	private void publicationTable(List<Publication> publications) {
		Object [][] data = new Object[publications.size()][Publication.columns.length];
		
		for(int i=0; i < publications.size(); i++){
			data[i][0] = publications.get(i).getId();
			data[i][1] = publications.get(i).getname();
			data[i][2] = publications.get(i).getPublishedBy();
			data[i][3] = publications.get(i).getYear_idValue();
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
