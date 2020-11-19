package com.tyss.bookmydoctor.app.dao;

import java.util.List;

import com.tyss.bookmydoctor.app.dto.*;

public interface PatientDAO {
	public Patient addPatient(Patient patient);

	public Patient updatePatient(Patient patient);
	
	public Patient deletePatient(String email);
	
	public List<Doctor> viewAllDoctors(Doctor viewAllDoctor);
	
	public DoctorAvailability bookAppointment(DoctorAvailability availability);
	
	
	public RatingDetails giveRatings(RatingDetails rating);
	
	

}
