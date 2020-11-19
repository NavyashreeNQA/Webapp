package com.tyss.bookmydoctor.dto;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class DoctorAvailability implements Serializable{
	private int doctorId;
	private int timeslotId;
	@NotNull(message="Please provide your availability status")
	private String availabilityStatus;
	private String bookAppointment;
	
	
	
	
}