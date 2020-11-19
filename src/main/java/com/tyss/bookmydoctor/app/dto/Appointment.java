package com.tyss.bookmydoctor.app.dto;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="appointment")

public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int appointmentId;
	
	@Column(name="patient_symptoms")
	private String patientSymptoms;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
	private int time;
	
	@Column(name="appointment_status")
	private String appointmentStatus; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({	
	@JoinColumn(name = "doctorId", referencedColumnName = "doctor_id"),
	@JoinColumn(name = "doctorName", referencedColumnName = "doctor_name"),
	
	})
	private Doctor doctor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientName", referencedColumnName = "patient_name")
	private Patient patient;

	
}
