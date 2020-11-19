package com.tyss.bookmydoctor.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name="patient")
public class Patient  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int patientId;
	
	@NotNull(message="Patient name cannot be null")
	@Pattern(regexp="[^0-9}*",message="Enter only alphabets")
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="address")
	private String address;
	
	@Max(value=10,message="Invalid contact number")
	@Column(name="contact_no")
	private long contactNo;
	
	@Email(message="Invalid email")
	@Column(name="email")
	private String email;
	
	@Max(value=120,message="Maximum age should be 120 years")
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne(mappedBy = "patient")
	private RatingDetails ratingdetails;
	
	
}
