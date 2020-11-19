package com.tyss.bookmydoctor.app.dto;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="rating_details")
public class RatingDetails {
	@Column(name="Feedback")
	private String feedback;
	
	@Column(name="ratings")
	private int ratings;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId", referencedColumnName = "patient_id")
	private Patient patient;
	

}
