package com.tyss.bookmydoctor.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.app.dao.DoctorDAO;
import com.tyss.bookmydoctor.app.dto.Appointment;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.DoctorTimeslot;
import com.tyss.bookmydoctor.app.dto.RatingDetails;
import com.tyss.bookmydoctor.app.exception.BookMyDoctorException;
@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorDAO doctorDao;
	@Override
	public Doctor addDoctor(Doctor doctor) {
			
			Doctor addDoctor = doctorDao.addDoctor(doctor);
			if(addDoctor!=null) {
				return addDoctor;
			} else {
				throw new BookMyDoctorException("Unable to add doctor");
			}
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		
		Doctor updateDoctor = doctorDao.updateDoctor(doctor);
		if(updateDoctor!=null) {
			return updateDoctor;
		} else {
			throw new BookMyDoctorException("Unable to update doctor");
		}
	}

	@Override
	public Doctor removeDoctor(int doctorId) {
	Doctor delDoctor = doctorDao.removeDoctor(doctorId);
		if(delDoctor!=null) {
			return delDoctor;
		} else {
			throw new BookMyDoctorException("Invalid doctorId");
		}
		
	}

	@Override
	public List<RatingDetails> getAllRatings() {
		
		List<RatingDetails> ratingDetails = doctorDao.getAllRatings();
		if(ratingDetails!=null) {
			return ratingDetails;
		} else {
			throw new BookMyDoctorException("Ratings is not available");
		}
	}

	@Override
	public List<Appointment> getAllScheduledAppointment() {
		
		 List<Appointment> scheduledAppointments = doctorDao.getAllScheduledAppointment();
		if(scheduledAppointments!=null) {
			return scheduledAppointments;
		} else {
			throw new BookMyDoctorException("There is no appointment scheduled");
		}
	}

	@Override
	public DoctorAvailability updateAvailability(DoctorAvailability availability) {
		
		DoctorAvailability updateavailability = doctorDao.updateAvailability(availability);
		if(updateavailability!=null) {
			return updateavailability;
		} else {
			throw new BookMyDoctorException("Unable to update doctor's availability");
		}
	}

	@Override
	public List<DoctorTimeslot> updateTimeslot(Date timeslotFrom, Date timeslotTo) {
		
		List<DoctorTimeslot> updateTimeslot = doctorDao.updateTimeslot(timeslotFrom, timeslotTo);
		if(updateTimeslot!=null) {
			return updateTimeslot;
		} else {
			throw new BookMyDoctorException("Unable to update timeslot");
		}
	}

}
