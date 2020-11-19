package com.tyss.bookmydoctor.dto;

import java.io.Serializable;

import lombok.Data;




@SuppressWarnings("serial")
@Data

public class Doctor implements Serializable  {
	
	private int doctorId;
	private String doctorName;
	private String specialisation;
	private String practicingFrom;
	private String qualification;
	private String ratings;	
}
