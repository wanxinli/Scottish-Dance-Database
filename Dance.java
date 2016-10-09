/**
 * 
 */
//package objects;

import java.util.Date;

/**
 * @author Pat
 *
 */
public class Dance {
	
	/**
	 * @param id
	 * @param type_id
	 * @param intensity
	 * @param shape_id
	 * @param couples_id
	 * @param devisor_id
	 * @param data_verified
	 * @param progression_id
	 * @param steps_verified
	 * @param tunes_verified
	 * @param medley_type_id
	 * @param bars_per_repeat
	 * @param intensity_per_turn
	 * @param formations_verified
	 * @param created
	 * @param devised
	 * @param last_modified
	 * @param name
	 * @param notes
	 * @param ucname
	 * @param intensity_bars
	 */
	public Dance(int id, int type_id, int intensity, int shape_id, int couples_id, int devisor_id, int data_verified,
			int progression_id, int steps_verified, int tunes_verified, int medley_type_id, int bars_per_repeat,
			int intensity_per_turn, int formations_verified, Date created, Date devised, Date last_modified,
			String name, String notes, String ucname, String intensity_bars) {
//		super();
		this.id = id;
		this.type_id = type_id;
		this.intensity = intensity;
		this.shape_id = shape_id;
		this.couples_id = couples_id;
		this.devisor_id = devisor_id;
		this.data_verified = data_verified;
		this.progression_id = progression_id;
		this.steps_verified = steps_verified;
		this.tunes_verified = tunes_verified;
		this.medley_type_id = medley_type_id;
		this.bars_per_repeat = bars_per_repeat;
		this.intensity_per_turn = intensity_per_turn;
		this.formations_verified = formations_verified;
		this.created = created;
		this.devised = devised;
		this.last_modified = last_modified;
		this.name = name;
		this.notes = notes;
		this.ucname = ucname;
		this.intensity_bars = intensity_bars;
	}

	private int id;
	private int type_id;
	private int intensity;
	private int shape_id;
	private int couples_id;
	private int devisor_id;
	private int data_verified;
	private int progression_id;
	private int steps_verified;
	private int tunes_verified;
	private int medley_type_id;
	private int bars_per_repeat;
	private int intensity_per_turn;
	private int formations_verified;
	
	private Date created;
	private Date devised;
	private Date last_modified;
	
	private String name;
	private String notes;
	private String ucname;
	private String intensity_bars;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUcname() {
		return ucname;
	}

	public void setUcname(String ucname) {
		this.ucname = ucname;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getBars_per_repeat() {
		return bars_per_repeat;
	}

	public void setBars_per_repeat(int bars_per_repeat) {
		this.bars_per_repeat = bars_per_repeat;
	}

	public int getMedley_type_id() {
		return medley_type_id;
	}

	public void setMedley_type_id(int medley_type_id) {
		this.medley_type_id = medley_type_id;
	}

	public int getShape_id() {
		return shape_id;
	}

	public void setShape_id(int shape_id) {
		this.shape_id = shape_id;
	}

	public int getCouples_id() {
		return couples_id;
	}

	public void setCouples_id(int couples_id) {
		this.couples_id = couples_id;
	}

	public int getProgression_id() {
		return progression_id;
	}

	public void setProgression_id(int progression_id) {
		this.progression_id = progression_id;
	}

	public int getDevisor_id() {
		return devisor_id;
	}

	public void setDevisor_id(int devisor_id) {
		this.devisor_id = devisor_id;
	}

	public Date getDevised() {
		return devised;
	}

	public void setDevised(Date devised) {
		this.devised = devised;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getintensity() {
		return intensity;
	}

	public void setintensity(int intensity) {
		this.intensity = intensity;
	}

	public String getintensity_bars() {
		return intensity_bars;
	}

	public void setintensity_bars(String intensity_bars) {
		this.intensity_bars = intensity_bars;
	}

	public int getData_verified() {
		return data_verified;
	}

	public void setData_verified(int data_verified) {
		this.data_verified = data_verified;
	}

	public int getSteps_verified() {
		return steps_verified;
	}

	public void setSteps_verified(int steps_verified) {
		this.steps_verified = steps_verified;
	}

	public int getFormations_verified() {
		return formations_verified;
	}

	public void setFormations_verified(int formations_verified) {
		this.formations_verified = formations_verified;
	}

	public int getTunes_verified() {
		return tunes_verified;
	}

	public void setTunes_verified(int tunes_verified) {
		this.tunes_verified = tunes_verified;
	}

	public int getIntensity_per_turn() {
		return intensity_per_turn;
	}

	public void setIntensity_per_turn(int intensity_per_turn) {
		this.intensity_per_turn = intensity_per_turn;
	}
	
}
