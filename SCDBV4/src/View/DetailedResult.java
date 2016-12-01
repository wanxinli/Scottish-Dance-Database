package View;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Album;
import Controller.Controller;
import Controller.Dance;
import Controller.Publication;
import Controller.Record;
import Controller.Tune;

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
	JScrollPane spTable;
	JTable table;
	private DefaultTableModel model;
	
	public DetailedResult(String id, String category) {
		super();
		setLayout(new BorderLayout());
		this.id = id;
		this. category = category;
		display();
	}
	
	public void display(){
		/*Checkbox cb1 = new Checkbox();
		cb1.setLabel("Mark");
		add(cb1,BorderLayout.PAGE_END);*/
		switch(category){
			case "album":
				List<Controller> records = Controller.getListRecords(id,"album");

				break;
			case "recordings":
				Controller recording = Record.searchByID(id, "recording");
				if(recording == null)
					ThrowError.errorMessage("You should clicked on a record on the table");
				else{
					recordingInfo(recording);
				}
				break; 
			case "publication":
				Controller publication = Publication.searchByID(id,"publication");
				if(publication == null)
					ThrowError.errorMessage("You should clicked on a record on the table");
				else{
					publicationInfo(publication);
				}
			break;
			case "tune":
				Controller tune = Tune.searchByID(id,"tune");
				if(tune == null)
					ThrowError.errorMessage("You should clicked on a record on the table");
				else{
					tuneInfo(tune);
				}
				break;
			default:
				
		}
    }
	
	private void recordingInfo(Controller recording) {
		Record record =  (Record) recording;
		JLabel title = new JLabel("Recording: " + record.getName());
		title.setForeground(Color.RED);
		add(title,BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		panel.add(new JLabel("Played by"));
		panel.add(new JLabel(record.getArtist()));
		panel.add(new JLabel("Type"));
		panel.add(new JLabel(record.getTypeName() + " " + record.getReps() + " x " + record.getBarsPerRepeat() +" bars"));
		add(panel,BorderLayout.CENTER);
		List<Tune> tunes = record.getTunes();
		tuneTable(tunes);
		setupTable();
		add(spTable,BorderLayout.PAGE_END);
		
	}
	private void tuneTable(List<Tune> tunes){
		Object [][] data = new Object[tunes.size()][Tune.columns.length];
		for(int i=0; i<tunes.size(); i++){
			Tune tune =  tunes.get(i);
			data[i][0] = tune.getId();
			data[i][1] = tune.getName();
			data[i][2] = tune.getcomposer();
		}
		model = createModel(data,Tune.columns);
		
	}
	
private void publicationInfo(Controller publication) {
		
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

private void tuneInfo(Controller tu) {
	Tune tune =  (Tune) tu;
	JLabel title = new JLabel("Tune: " + tune.getName());
	title.setForeground(Color.RED);
	add(title,BorderLayout.NORTH);
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(new JLabel("Composed by"));
	panel.add(new JLabel(tune.getcomposer()));
	add(panel,BorderLayout.CENTER);
}

private void albumInfo(Controller album) {
	List<Controller> records = album.getListRecords(id,"album");
}

private void setupTable(){
	table = new JTable(model);
	spTable = new JScrollPane(table);
  //  table.setPreferredScrollableViewportSize(new Dimension(900, 500));
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
			JPanel panel = new DetailedResult(Integer.toString(row),"tune");
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
