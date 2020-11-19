package com.tyss.bookmydoctor.app.service;
import java.util.Date;
import java.util.List;

import com.tyss.bookmydoctor.app.dto.*;
public interface DoctorService {
		public Doctor addDoctor(Doctor doctor);
		
		public Doctor updateDoctor(Doctor doctor);
		
		public Doctor removeDoctor(int doctorId);
		
		public List<RatingDetails> getAllRatings();
	    
	    public List<Appointment> getAllScheduledAppointment();
	    
	    public DoctorAvailability updateAvailability(DoctorAvailability availability); 
	    
	   	public List<DoctorTimeslot> updateTimeslot(Date timeslotFrom,Date timeslotTo); 
}


