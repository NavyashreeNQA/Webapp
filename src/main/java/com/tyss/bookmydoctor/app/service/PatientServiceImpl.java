package com.tyss.bookmydoctor.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.app.dao.PatientDAO;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.RatingDetails;
import com.tyss.bookmydoctor.app.exception.BookMyDoctorException;
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDAO patientDao;
	@Override
	public Patient addPatient(Patient patient) {
		
		Patient addPatient = patientDao.addPatient(patient);
		if(addPatient!=null) {
			return addPatient;
		} else {
			throw new BookMyDoctorException("Unable to add patient");
		}
	}

	@Override
	public Patient updatePatient(Patient patient) {
		
		Patient updatePatient = patientDao.updatePatient(patient);
		if(updatePatient!=null) {
			return updatePatient;
		} else {
			throw new BookMyDoctorException("Unable to update patient");
		}
	}

	@Override
	public Patient deletePatient(String email) {
		
		Patient delPatient = patientDao.deletePatient(email);
		if(delPatient!=null) {
			return delPatient;
		} else {
			throw new BookMyDoctorException("Invalid emailId");
		}
	}

	@Override
	public List<Doctor> viewAllDoctors(Doctor viewAllDoctor) {
		
		List<Doctor> getDoctors = patientDao.viewAllDoctors(viewAllDoctor);
		 if(getDoctors!=null) {
				return getDoctors;
			} else {
				throw new BookMyDoctorException("Unable to fetch all doctors info");
			}
	}

	@Override
	public DoctorAvailability bookAppointment(DoctorAvailability availability) {
		
		DoctorAvailability bookAppointment = patientDao.bookAppointment(availability);
		if(bookAppointment!=null) {
			return bookAppointment;
		} else {
			throw new BookMyDoctorException("Unable to book an appointment");
		}
	}

	@Override
	public RatingDetails giveRatings(RatingDetails rating) {
		
		RatingDetails ratingDetails = patientDao.giveRatings(rating);
		if(ratingDetails!=null) {
			return ratingDetails;
		} else {
			throw new BookMyDoctorException("Unable to provide ratings");
		}
	}

}
