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
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.service.AdminService;
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/register-doctor")
	@ResponseBody
	public Doctor getDoctor(Doctor doctor) {
		Doctor doctor1 = adminService.addDoctor(doctor);
		if(doctor1!=null) {
			return doctor1;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/remove-doctor/{email}")
	public String removeDoctor(@PathVariable String email) {
		Doctor delDoctor=adminService.removeDoctor(email);
		if(delDoctor!=null) {
			return ("Doctor profile removed successfully");
		} else {
			return ("Failed to remove doctor profile");
		}
	}
	
	@DeleteMapping("/delete-patient/{email}")
	public String removePatient(@PathVariable String email) {
		Patient delPatient=adminService.removePatient(email);
		if(delPatient!=null) {
			return ("Deleted profile successfully");
		} else {
			return ("failed to delete profile");
		}
	}
	
	@GetMapping("/view-appointments")
	public String viewAllAppointments() {
		List<Appointment> viewAppointments = adminService.viewAllAppointments();
		if(viewAppointments!=null) {
			return ("Appointment list available");
		} else {
			return ("Appointment list not available");
		}
	}
	
	@PutMapping("/update-profile-byadmin")
	public String updateDoctor(@RequestBody Doctor doctor) {
		Doctor doctor2=adminService.updateDoctor(doctor);
		if(doctor2!=null) {
			return ("Doctor's data updated successfully");
		} else {
			return ("Unable to update data");
		}
	}
	
	@PutMapping("/update-patient")		
	public String updatePatient(@RequestBody Patient patient) {
		Patient updatePatient=adminService.updatePatient(patient);
		if(updatePatient!=null) {
			return ("Successfully updated patient's profile");
		} else {
			return("Failed to update patient's profile");
		}
	}
	
	@GetMapping("/get-doctors")
	public String getAllDoctor() {
		 List<Doctor> getAllDoctors = adminService.getAllDoctor();
		if(getAllDoctors!=null) {
			return ("Doctors available");
		} else {
			return("Doctors not available");
		}
	}
	
	@GetMapping("/all-patients")
	public String getAllPatient() {
		 List<Patient> getAllPatient = adminService.getAllPatient();
		if(getAllPatient!=null) {
			return ("Patients available");
		} else {
			return("Patients not available");
		}
	}
	
	@DeleteMapping("/remove-appointment/{appointmentId}")
	public String removeAppointment(@PathVariable int appointmentId) {
		Appointment removeAppointment = adminService.removeAppointment(appointmentId);
		if(removeAppointment!=null) {
			return ("Appointment removed successfully");
		} else {
			return("Failed to remove appointment");
		}
	}

}
