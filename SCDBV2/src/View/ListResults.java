package View;

/*
 * Written by Taghreed Bagies
 */
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Album;


public class ListResults extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String category="";
	JTable table;
	String searchKey;
	JScrollPane spTable;
	private DefaultTableModel model;
	
	public ListResults(String category,String userInput){
		this.category = category;
		searchKey = userInput;
		display();
	}
	public void display(){

		switch(category){
			case "album":
				List<Album> albums = Album.searchByKey(searchKey);
				if(albums.isEmpty()){
					errorMessage("There is no data matches the input ");
				}
				else{
					albumTable(albums);
					setupTable();
				}
				break;
			case "dance":
				//setupTable();
				break;
			default:
			
		}
    }
	
	private void setupTable(){
		setLayout(new BorderLayout());
		table = new JTable(model);
		spTable = new JScrollPane(table);
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
	
	private void albumTable(List<Album> albums){
		Object [][] data = new Object[albums.size()][Album.columns.length];
		for(int i=0; i<albums.size(); i++){
			data[i][0] = albums.get(i).getId();
			data[i][1] = albums.get(i).getname();
			data[i][2] = albums.get(i).getartist_id();
			data[i][3] = albums.get(i).getproductionyear();
		}
		model = createModel(data,Album.columns);
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	private DefaultTableModel createModel(Object[][] data, String[] columns){
		return new DefaultTableModel(data, columns) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
	}
	
	private void errorMessage(String msg){
		JOptionPane.showMessageDialog(null,
			    msg,
			    "Error Message",
			    JOptionPane.ERROR_MESSAGE);
	}
}
