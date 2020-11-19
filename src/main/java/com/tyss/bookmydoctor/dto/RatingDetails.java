package com.tyss.bookmydoctor.dto;
import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class RatingDetails implements Serializable{
	private int patientId;
	private String doctorName;
	private String feedback;
	private int ratings;
	

}
