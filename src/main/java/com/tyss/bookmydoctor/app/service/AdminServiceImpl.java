package com.tyss.bookmydoctor.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.app.dao.AdminDAO;
import com.tyss.bookmydoctor.app.dto.Appointment;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.exception.BookMyDoctorException;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDao;
	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		Doctor addDoctor = adminDao.addDoctor(doctor);
		if(addDoctor!=null) {
			return addDoctor;
		} else {
			throw new BookMyDoctorException("Unable to add doctor");
		} 
	}

	@Override
	public Doctor removeDoctor(String email) {
		Doctor deleteDoctor = adminDao.removeDoctor(email);
		if(deleteDoctor!=null) {
			return deleteDoctor;
		} else {
			throw new BookMyDoctorException("Invalid doctor emailId ");
		} 
	}

	@Override
	public Patient removePatient(String email) {
				Patient deletePatient = adminDao.removePatient(email);
				if(deletePatient!=null) {
					return deletePatient;
				} else {
					throw new BookMyDoctorException("Invalid patient emailId");
				}
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		
		List<Appointment> viewAppointments = adminDao.viewAllAppointments();
		if(viewAppointments!=null) {
			return viewAppointments;
		} else {
			throw new BookMyDoctorException("Unable to fetch all appointments");
		}
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor updateDoctor = adminDao.updateDoctor(doctor);
		if(updateDoctor!=null) {
			return updateDoctor;
		} else {
			throw new BookMyDoctorException("Unable to update doctor");
		}
	
	}

	@Override
	public Patient updatePatient(Patient patient) {
		Patient updatePatient = adminDao.updatePatient(patient);
		if(updatePatient!=null) {
			return updatePatient;
		} else {
			throw new BookMyDoctorException("Unable to update patient");
		}
		 
	}

	@Override
	public List<Doctor> getAllDoctor() {
		
		List<Doctor> getDoctors = adminDao.getAllDoctor();
		if(getDoctors!=null) {
			return getDoctors;
		} else {
			throw new BookMyDoctorException("Unable to fetch all doctors info");
		}
	}

	@Override
	public List<Patient> getAllPatient() {
		List<Patient> getPatients = adminDao.getAllPatient();
		if(getPatients!=null) {
			return getPatients;
		} else {
			throw new BookMyDoctorException("Unable to fetch all patients info");
		}
	}

	@Override
	public Appointment removeAppointment(int appointmentId) {
		
		Appointment delAppointment = adminDao.removeAppointment(appointmentId);
		if(delAppointment!=null) {
			return delAppointment;
		} else {
			throw new BookMyDoctorException("Invalid appointmentId");
		}
	}

}
