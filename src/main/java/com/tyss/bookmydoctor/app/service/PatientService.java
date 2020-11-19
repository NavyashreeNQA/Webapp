package com.tyss.bookmydoctor.app.service;

import java.util.List;

import com.tyss.bookmydoctor.app.dto.*;

public interface PatientService {
	public Patient addPatient(Patient patient);

	public Patient updatePatient(Patient patient);
	
	public Patient deletePatient(String email);
	
	public List<Doctor> viewAllDoctors(Doctor viewAllDoctor);
	
	public DoctorAvailability bookAppointment(DoctorAvailability availability);
	
	
	public RatingDetails giveRatings(RatingDetails rating);
	
	

}
