package com.tyss.bookmydoctor.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;



@Entity
@Data
@Table(name="doctor")
public class Doctor  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private int doctorId;
	
	@NotNull(message="Doctor name cannot be null")
	@Pattern(regexp="[^0-9}*",message="Enter only alphabets")
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="specialisation")
	private String specialisation;

	@Column(name="practicing_from")
	private String practicingFrom;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="ratings")
	private String ratings;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
	
	List<Appointment> orders = new ArrayList<>();
	
}
