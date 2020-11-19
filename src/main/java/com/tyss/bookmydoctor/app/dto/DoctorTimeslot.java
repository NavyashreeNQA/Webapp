package com.tyss.bookmydoctor.app.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="doctor_timeslot")
public class DoctorTimeslot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="timeslot_id")
	private int timeslotId;
	
	@DateTimeFormat
	@Column(name="timeslot_from")
	private String timeslotFrom;
	
	@DateTimeFormat
	@Column(name="timeslot_to")
	private String timeslotTo;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId", referencedColumnName = "doctor_id")
	private Doctor doctor;

}
