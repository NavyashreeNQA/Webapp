package com.tyss.bookmydoctor.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.bookmydoctor.app.dto.Appointment;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.RatingDetails;
import com.tyss.bookmydoctor.app.service.DoctorService;
@RestController
public class DoctorController {
	@Autowired
	private DoctorService docService;
	
	@GetMapping("/register-doctor")
	@ResponseBody
	public Doctor getDoctor(Doctor doctor) {
		Doctor doctor1 = docService.addDoctor(doctor);
		if(doctor1!=null) {
			return doctor1;
		} else {
			return null;
		}
	}
	
	@PutMapping("/update-profile")
	public String updateDoctor(@RequestBody Doctor doctor) {
		Doctor doctor2=docService.updateDoctor(doctor);
		if(doctor2!=null) {
			return ("Doctor's data updated successfully");
		} else {
			return ("Unable to update data");
		}
	}
	
	@DeleteMapping("/remove-doctor/{doctorId}")
	public String removeDoctor(@PathVariable int doctorId) {
		Doctor delDoctor=docService.removeDoctor(doctorId);
		if(delDoctor!=null) {
			return ("Doctor profile removed successfully");
		} else {
			return ("Failed to remove doctor profile");
		}
	}
	
	@GetMapping("/getallratings")
	public String getAllRatings() {
		 List<RatingDetails> getRatings = docService.getAllRatings();
		 if(getRatings!=null) {
			 return ("Ratings available");
		 } else {
			 return ("Ratings not available");
		 }
		 
	}
	
	@GetMapping("/scheduled-appointment")
	public String getAllScheduledAppointment(){
		 List<Appointment> getScheduledAppointment = docService.getAllScheduledAppointment();
		 if(getScheduledAppointment!=null) {
			 return ("Appointment is scheduled");
		 } else {
			 return ("Appointment is not scheduled");
		 }
		 
	}
	
	@PutMapping("/update-availability")
	 public String updateAvailability(DoctorAvailability availability) {
		 DoctorAvailability updateAvailability = docService.updateAvailability(availability);
		 if(updateAvailability!=null) {
			 return ("Updated successfully");
		 } else {
			 return ("Failed to update");
		 }
		 
	 }
}
