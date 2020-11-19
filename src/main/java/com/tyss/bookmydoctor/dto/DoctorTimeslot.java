package com.tyss.bookmydoctor.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class DoctorTimeslot implements Serializable{
	private int doctorId;
	private int timeslotId;
	private String timeslotFrom;
	private String timeslotTo;
	private Date dueDate;
	
	
}
