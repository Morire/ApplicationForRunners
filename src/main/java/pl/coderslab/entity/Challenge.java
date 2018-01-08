package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Challenge")
public class Challenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private double distance;
	private String place;
	private String type;
	
	@OneToMany(mappedBy = "challenge")
	private List<DreamRun> dreamRun = new ArrayList<DreamRun>();
	
	@OneToMany(mappedBy = "challenge")
	private List<Checkpoints> checkpoints = new ArrayList<Checkpoints>();

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
//	public List<Checkpoints> getCheckpoints() {
//		return checkpoints;
//	}
//	public void setCheckpoints(List<Checkpoints> checkpoints) {
//		this.checkpoints = checkpoints;
//	}
		

}
