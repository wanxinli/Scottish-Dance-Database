package View;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.Album;
import Controller.Controller;
import Controller.Dance;
import Controller.Formation;
import Controller.Media;
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
	private JTextField textfield = new JTextField(20);
	private JButton button;
	private JScrollPane spTable;
	private JTable table;
	private DefaultTableModel model;
	private boolean flag = false;
	private List<Controller> records;
	
	public DetailedResult(String id, String category) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.id = id;
		this.category = category;
		display();
	}
	
	public void display(){
		removeAll();
		switch(category){
			case "album":
				Controller album = (Album) Album.searchByID(id,"album");							
				if(album == null)
					ThrowError.errorMessage("You should click on a record in the table");
				else{
					albumInfo(album);
				}
				break;
			case "recording":
				Controller recording = Record.searchByID(id,"recording");
				if(recording == null)
					ThrowError.errorMessage("You should click on a record in the table");
				else{
					recordingInfo(recording);
				}
				break; 
			case "publication":
				Controller publication = Publication.searchByID(id,"publication");
				System.out.println(id);
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
		if(!flag){
			JPanel panel = new JPanel();
			Checkbox cb1 = new Checkbox();
			cb1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(category) {		
				case "album":
					Controller.mark(id,category);
					List<Controller> collection = Controller.getList(id,category);
					for(Controller el: collection) {
						Controller.mark(""+el.getId(),"recording");						
					}
					SuccessfulMsg.message("The record has been marked successfully");
					break;
				case "publication":
					Controller.mark(id,category);
					List<Controller> colexion = Publication.getList(id,"publication");
					for(Controller el: colexion) {
						Controller.mark(""+el.getId(),"dance");
					}
					SuccessfulMsg.message("The record has been marked successfully");
					break;
				default:
					Controller.mark(id,category);
					SuccessfulMsg.message("The record has been marked successfully");
					break;
				}
			//	removeAll();
				display();
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
    }
	
	private void recordingInfo(Controller recording) {
		Record record =  (Record) recording;
		JLabel title = new JLabel("Recording: " + record.getName());
		title.setForeground(Color.RED);
		title.setAlignmentY(TOP_ALIGNMENT);
		title.setAlignmentX(RIGHT_ALIGNMENT);
		add(title);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,2));
		panel1.add(new JLabel("Played by"));
		panel1.add(new JLabel(record.getArtist()));
		panel1.add(new JLabel("Type"));
		panel1.add(new JLabel(record.getTypeName() + " " + record.getReps() + " x " + record.getBarsPerRepeat() +" bars"));
		
		String indexCode= Controller.getCodeIndex(Integer.parseInt(id),"recording");
		panel1.add(new JLabel("Index code"));
		if(indexCode!=null)
			panel1.add(new JLabel(indexCode));
		else
			panel1.add(new JLabel("Unknown"));
		panel1.add(new JLabel("album name"));
		Controller album = Controller.getAlbumFromRecording(record.getId());
		if(album!=null)
			panel1.add(new JLabel (album.getName()));
		else
			panel1.add(new JLabel ("Unknown"));
		panel1.setAlignmentY(CENTER_ALIGNMENT);
		panel1.setAlignmentX(CENTER_ALIGNMENT);
		add(panel1);
		List<Controller> tunes = Controller.getList(id, "recording");
		tuneTable(tunes);
		setupTable("tune");
		spTable.setAlignmentX(CENTER_ALIGNMENT);
		spTable.setAlignmentY(LEFT_ALIGNMENT);
		add(spTable);
		if(Controller.checkMarked(record.getId(), category)=='*')
			flag = true;	
	}
	private void tuneTable(List<Controller> tunes){
		Object [][] data = new Object[tunes.size()][Tune.columns.length];
		for(int i=0; i<tunes.size(); i++){
			Tune tune =  (Tune)tunes.get(i);
			data[i][0] = tune.getId();
			data[i][1] = tune.getName();
			data[i][2] = tune.getcomposer();
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
			data[i][4] = Controller.getCodeIndex(record.getId(),"recording");
			data[i][5] = Controller.checkMarked(record.getId(),"recording"); 
			
		}
		model = createModel(data,Record.columns);
		
	}
	
	private void danceTable(List<Controller> dances) {
		Object [][] data = new Object[dances.size()][Dance.columns2.length];
		
		for (int i = 0; i < dances.size(); i++) {
			Dance dance = (Dance) dances.get(i);
			data[i][0] = dance.getId();
			data[i][1] = dance.getName();
			data[i][2] = dance.getType();
			data[i][3] = dance.getBarsperrepeat();
			data[i][4] = Controller.checkMarked(dance.getId(),"dance");
		}
		model = createModel(data, Dance.columns2);
	}
private void publicationInfo(Controller publication) {
		
		Publication pub =  (Publication) publication;
		System.out.println(pub.getId());
		System.out.println(id);
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
		panel.setAlignmentY(CENTER_ALIGNMENT);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		add(panel);
		List<Controller> dances = Controller.getList(id, "publication");
		danceTable(dances);
		setupTable("dance");
		spTable.setAlignmentX(CENTER_ALIGNMENT);
		spTable.setAlignmentY(LEFT_ALIGNMENT);
		add(spTable);
		if(Controller.checkMarked(pub.getId(), category)=='*')
			flag = true;
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
	flag = true;
}

private void albumInfo(Controller album) {
	Album alb =  (Album) album;
	Media med= alb.getMedia();
	JLabel title = new JLabel("Album: " + alb.getName());
	records = Controller.getList(id,"album");
	title.setForeground(Color.RED);
	title.setAlignmentY(TOP_ALIGNMENT);
	title.setAlignmentX(RIGHT_ALIGNMENT);
	add(title);
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(3,2));
	panel.add(new JLabel("Short name"));
	panel.add(new JLabel(alb.getShortName()));
	panel.add(new JLabel("Media"));
	panel.add(new JLabel(med.getName()));
	String indexCode= Controller.getCodeIndex(Integer.parseInt(id),"album");
	panel.add(new JLabel("Index code"));
	if(indexCode!=null){
		panel.add(new JLabel(indexCode));
	}
	else{
		JPanel panelIndex= new JPanel();
		panelIndex.setLayout(new FlowLayout());
		panelIndex.add(textfield);
		button = new JButton("submit");
		panelIndex.add(button);
		button.addActionListener(new CustomActionListener());
		panel.add(panelIndex);
	}
	panel.setAlignmentY(CENTER_ALIGNMENT);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	add(panel);
	recordTable(records);
	setupTable("recording");
	spTable.setAlignmentX(CENTER_ALIGNMENT);
	spTable.setAlignmentY(LEFT_ALIGNMENT);
	add(spTable);
	if(Controller.checkMarked(alb.getId(), category)=='*')
		flag = true;
}
	// Wanxin
	private void danceInfo(Controller dan) {
		
		Dance dance = (Dance) dan;
		Publication pub = dance.getPublication();
		String pubName;
		if(pub!=null)
			pubName = pub.getName();
		else
			pubName = "Unknown";
		
		JLabel title = new JLabel("Dance: " + dance.getName());
		title.setForeground(Color.RED);
		title.setAlignmentY(TOP_ALIGNMENT);
		title.setAlignmentX(RIGHT_ALIGNMENT);
		add(title);
		if(Controller.checkMarked(dance.getId(), category)=='*')
			flag = true;
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
		panel.add(new JLabel(pubName));
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panel.setAlignmentY(CENTER_ALIGNMENT);
		add(panel);

		List<Formation> formations = dance.getFormations();
		formationTable(formations);
		setupTable("formation");
		spTable.setAlignmentX(CENTER_ALIGNMENT);
		spTable.setAlignmentY(LEFT_ALIGNMENT);
		add(spTable);
		if(Controller.checkMarked(dance.getId(), category)=='*')
			flag = true;
	}

	private void formationTable(List<Formation> formations) {
		Object[][] data = new Object[formations.size()][Formation.columns.length];
		for (int i = 0; i < formations.size(); i++) {
			Formation formation = formations.get(i);
			//data[i][0] = formation.getId();
			data[i][0] = formation.getName();
		}
		model = createModel(data, Formation.columns);

	}
private void setupTable(String tableName){
	table = new JTable(model);
	spTable = new JScrollPane(table);
  //  table.setPreferredScrollableViewportSize(new Dimension(900, 500));
	if(!tableName.equals("formation")){
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

private class CustomActionListener implements ActionListener{
public void actionPerformed(ActionEvent e) {
	if(button!=null){
		boolean f = Controller.addIndexCode(id,textfield.getText(),"album");
		if(f){
			for(int i=0; i<records.size(); i++){
				f = Controller.addIndexCode(""+records.get(i).getId(),textfield.getText(),"recording");
			}
			if(f)
				SuccessfulMsg.message("The index code has been saved successfully");
			else
				ThrowError.errorMessage("Error: stroing index");
		}
		else
			ThrowError.errorMessage("Error: stroing index");
		display();
//	removeAll();
	}
}
}
}