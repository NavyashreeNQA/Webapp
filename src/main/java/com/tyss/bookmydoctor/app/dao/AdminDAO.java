package com.tyss.bookmydoctor.app.dao;
import java.util.List;


import com.tyss.bookmydoctor.app.dto.*;
public interface AdminDAO {
	public Doctor addDoctor(Doctor doctor);
	
	public Doctor removeDoctor(String email);
	
	public Patient removePatient(String email);
	
	public List<Appointment> viewAllAppointments();
	
	public Doctor updateDoctor(Doctor doctor);
	
	public Patient updatePatient(Patient patient);
	
	public List<Doctor> getAllDoctor();
	
	public List<Patient> getAllPatient();
	
	public Appointment removeAppointment(int appointmentId);
	

	
}
