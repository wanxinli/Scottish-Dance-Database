package View;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Album;
import Controller.Controller;
import Controller.Dance;
import Controller.Formation;
import Controller.Media;
import Controller.Owned;
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
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.id = id;
		this.category = category;
		display();
	}
	
	public void display(){
		switch(category){
			case "album":
				Controller album = (Album) Album.searchByID(id,"album");							
				if(album == null)
					ThrowError.errorMessage("You should click on a record in the table");
				else{
					albumInfo(album);
				}
				break;
			case "recordings":
				Controller recording = Record.searchByID(id,"recording");
				if(recording == null)
					ThrowError.errorMessage("You should click on a record in the table");
				else{
					recordingInfo(recording);
				}
				break; 
			case "publication":
				Controller publication = Publication.searchByID(id,"publication");
				if(publication == null)
					ThrowError.errorMessage("You should click on a record in the table");
				else{
					publicationInfo(publication);
				}
				break;
			case "tune":
				Controller tune = Tune.searchByID(id,"tune");
				if(tune == null)
					ThrowError.errorMessage("You should clicked a record in the table");
				else{
					tuneInfo(tune);
				}
				break;
		//Wanxin
		        case "dance":
			        Controller dance = Dance.searchByID(id, "dance");
			        if (dance == null)
				        ThrowError.errorMessage("You should clicked on a record on the table");
			        else {
				        danceInfo(dance);
			        }
			        break;
		//
			default:
		}
		
		JPanel panel = new JPanel();
		Checkbox cb1 = new Checkbox();
		cb1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// This needs to change depending on what category you're marking, as well as if you're unmarking as well.
				Owned.mark(id,category); 
				SuccessfulMsg.message("The record has been marked successfully");
				System.out.println("Mouse Clicked");
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
		}
		);
		cb1.setLabel("Mark");
		panel.add(cb1);
		panel.setAlignmentY(BOTTOM_ALIGNMENT);
		panel.setAlignmentX(RIGHT_ALIGNMENT);
		add(panel);
    }
	
	private void recordingInfo(Controller recording) {
		Record record =  (Record) recording;
		JLabel title = new JLabel("Recording: " + record.getName());
		title.setForeground(Color.RED);
		title.setAlignmentY(TOP_ALIGNMENT);
		title.setAlignmentX(RIGHT_ALIGNMENT);
		add(title);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		panel1.add(new JLabel("Played by"));
		panel1.add(new JLabel(record.getArtist()));
		panel1.add(new JLabel("Type"));
		panel1.add(new JLabel(record.getTypeName() + " " + record.getReps() + " x " + record.getBarsPerRepeat() +" bars"));
		panel1.setAlignmentY(CENTER_ALIGNMENT);
		panel1.setAlignmentX(CENTER_ALIGNMENT);
		add(panel1);

		List<Tune> tunes = record.getTunes();
		tuneTable(tunes);
		setupTable("tune");
		spTable.setAlignmentX(CENTER_ALIGNMENT);
		spTable.setAlignmentY(LEFT_ALIGNMENT);
		add(spTable);
	}
	private void tuneTable(List<Tune> tunes){
		Object [][] data = new Object[tunes.size()][Tune.columns.length];
		for(int i=0; i<tunes.size(); i++){
			Tune tune =  tunes.get(i);
			data[i][0] = tune.getId();
			data[i][1] = tune.getName();
			data[i][2] = tune.getcomposer();
			data[i][3] = Owned.isOwned(tune.getId(),"tune");
		}
		model = createModel(data,Tune.columns);
		
	}
	
	private void recordTable(List<Controller> records){
		Object [][] data = new Object[records.size()][Record.columns.length];
		for(int i=0; i<records.size(); i++){
			Record record = (Record) records.get(i);
			data[i][0] = record.getId();
			data[i][1] = record.getName();
			data[i][2] = record.getArtist();
			data[i][3] = record.getTypeName().substring(0,1) + record.getBarsPerRepeat() + " " + record.getReps();
			data[i][4] = Owned.isOwned(record.getId(),"recordings");
			
		}
		model = createModel(data,Record.columns);
		
	}
	
private void publicationInfo(Controller publication) {
		
		Publication pub =  (Publication) publication;
		JLabel title = new JLabel("Publication: " + pub.getName());
		title.setForeground(Color.RED);
		title.setAlignmentY(TOP_ALIGNMENT);
		title.setAlignmentX(RIGHT_ALIGNMENT);
		add(title);
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
		panel.setAlignmentY(CENTER_ALIGNMENT);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		add(panel);
	}

private void tuneInfo(Controller tu) {
	Tune tune =  (Tune) tu;
	JLabel title = new JLabel("Tune: " + tune.getName());
	title.setForeground(Color.RED);
	title.setAlignmentY(TOP_ALIGNMENT);
	title.setAlignmentX(RIGHT_ALIGNMENT);
	add(title);
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(1,2));
	panel.add(new JLabel("Composed by"));
	panel.add(new JLabel(tune.getcomposer()));
	panel.setAlignmentY(CENTER_ALIGNMENT);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	add(panel);
}

private void albumInfo(Controller album) {
	List<Controller> records = Controller.getListRecords(id,"album");
	Album alb =  (Album) album;
	Media med= alb.getMedia();
	JLabel title = new JLabel("Album: " + alb.getName());
	title.setForeground(Color.RED);
	title.setAlignmentY(TOP_ALIGNMENT);
	title.setAlignmentX(RIGHT_ALIGNMENT);
	add(title);
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2,2));
	panel.add(new JLabel("Short name"));
	panel.add(new JLabel(alb.getShortName()));
	panel.add(new JLabel("Media"));
	panel.add(new JLabel(med.getName()));
	panel.setAlignmentY(CENTER_ALIGNMENT);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	add(panel);
	recordTable(records);
	setupTable("recordings");
	spTable.setAlignmentX(CENTER_ALIGNMENT);
	spTable.setAlignmentY(LEFT_ALIGNMENT);
	add(spTable);

}
	// Wanxin
	private void danceInfo(Controller dan) {
		Dance dance = (Dance) dan;
		Publication pub = dance.getPublication();
		JLabel title = new JLabel("Dance: " + dance.getName());
		title.setForeground(Color.RED);
		title.setAlignmentY(TOP_ALIGNMENT);
		title.setAlignmentX(RIGHT_ALIGNMENT);
		add(title);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		panel.add(new JLabel("Type"));
		panel.add(new JLabel(dance.getType()));
		panel.add(new JLabel("Shape"));
		panel.add(new JLabel(dance.getShape()));
		panel.add(new JLabel("Devised by"));
		panel.add(new JLabel(dance.getAuthorName()));
		panel.add(new JLabel("Bars/Repeat"));
		panel.add(new JLabel("" + dance.getBarsperrepeat()));
		panel.add(new JLabel("Published in"));
		panel.add(new JLabel("" + pub.getName()));
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panel.setAlignmentY(CENTER_ALIGNMENT);
		add(panel);

		List<Formation> formations = dance.getFormations();
		formationTable(formations);
		setupTable("formation");
		spTable.setAlignmentX(CENTER_ALIGNMENT);
		spTable.setAlignmentY(LEFT_ALIGNMENT);
		add(spTable);
	}

	private void formationTable(List<Formation> formations) {
		Object[][] data = new Object[formations.size()][Formation.columns.length];
		for (int i = 0; i < formations.size(); i++) {
			Formation formation = formations.get(i);
			data[i][0] = formation.getId();
			data[i][1] = formation.getName();
		}
		model = createModel(data, Formation.columns);

	}
	//
private void setupTable(String tableName){
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
			JPanel panel = new DetailedResult(Integer.toString(row),tableName);
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
