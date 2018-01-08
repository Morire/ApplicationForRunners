package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Checkpoints {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double checkpointDist;
	private String checkpointTime;
	private int personId;
	
	
	public Checkpoints() {
		
	}

	public Checkpoints(Challenge challenge, double checkpointDist, String checkpointTime, int personId) {
		this.challenge = challenge;
		this.checkpointDist = checkpointDist;
		this.checkpointTime = checkpointTime;
		this.personId = personId;
	}

	@ManyToOne
	private Challenge challenge;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCheckpointDist() {
		return checkpointDist;
	}

	public void setCheckpointDist(double checkpointDist) {
		this.checkpointDist = checkpointDist;
	}

	public String getCheckpointTime() {
		return checkpointTime;
	}

	public void setCheckpointTime(String checkpointTime) {
		this.checkpointTime = checkpointTime;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Checkpoints [checkpointDist=" + checkpointDist + ", checkpointTime=" + checkpointTime + ", personId="
				+ personId + ", challenge=" + challenge + "]";
	}
	
	

}
