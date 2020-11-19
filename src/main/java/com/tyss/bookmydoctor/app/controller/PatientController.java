package com.tyss.bookmydoctor.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.RatingDetails;
import com.tyss.bookmydoctor.app.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/add-patient")
	public String addPatient(Patient patient) {
		Patient addPatient=patientService.addPatient(patient);
		if(addPatient!=null) {
			return ("Successfully added patient details");
		} else {
			return ("Failed to add patient details");
		}
	}
	
	
	@PutMapping("/update-patient")		
	public String updatePatient(@RequestBody Patient patient) {
		Patient updatePatient=patientService.updatePatient(patient);
		if(updatePatient!=null) {
			return ("Successfully updated patient's profile");
		} else {
			return("Failed to update patient's profile");
		}
	}
	
	@DeleteMapping("/delete-patient/{email}")
	public String deletePatient(@PathVariable String email) {
		Patient delPatient=patientService.deletePatient(email);
		if(delPatient!=null) {
			return ("Deleted profile successfully");
		} else {
			return ("failed to delete profile");
		}
	}
	
	@GetMapping("/book-appointment")
	public String bookAppointment(DoctorAvailability availability) {
		 DoctorAvailability bookAppointment = patientService.bookAppointment(availability);
		if(bookAppointment!=null) {
			return ("Appointment booked successfully");
		} else {
			return("Failed to book appointment");
			
		}
	}
	
	@PutMapping("/rating-details")
	
	public String giveRatings(RatingDetails rating) {
		RatingDetails giveRatings = patientService.giveRatings(rating);
		if(giveRatings!=null) {
			return ("Ratings submitted successfully");
		} else {
			return("Failed to submit ratings");
		}
	}
	
	@GetMapping("/view-doctors")
	public String viewAllDoctors(Doctor viewAllDoctor) {
	List<Doctor> viewAllDoctors=patientService.viewAllDoctors(viewAllDoctor);
	if(viewAllDoctors!=null) {
		return ("Doctor is present");
	} else {
		return ("Doctor isnot present");
	}
	}
	
	
}
