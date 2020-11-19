package com.tyss.bookmydoctor.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;



@SuppressWarnings("serial")
@Data


public class Appointment implements Serializable{
	
	private int appointmentId;
	private String patientName;
	private int doctorId;
	private String doctorName;
	private String patientSymptoms;
	private Date date;
	private int time;
	private String appointmentStatus; 
	
	
	
	
}
