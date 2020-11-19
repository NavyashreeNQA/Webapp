package com.tyss.bookmydoctor.app.dto;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctor_availability")
public class DoctorAvailability {
	
	@Column(name="availability_status")
	private String availabilityStatus;
	
	@Column(name="book_appointment")
	private String bookAppointment;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "availability")
	private List<Patient> patients = new ArrayList<>();
	private Patient patient;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "availability")
	private List<Doctor> doctors = new ArrayList<>();
	private Doctor doctor;


}