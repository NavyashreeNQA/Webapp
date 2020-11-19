package com.tyss.bookmydoctor.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class Patient implements Serializable {

	private int patientId;
	private String patientName;
	private String address;
	private long contactNo;
	private String email;
	private int age;
	private String gender;
	
	
	
}
