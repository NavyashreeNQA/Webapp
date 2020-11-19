package com.tyss.bookmydoctor.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.tyss.bookmydoctor.app.dto.Appointment;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.DoctorTimeslot;
import com.tyss.bookmydoctor.app.dto.RatingDetails;
@Repository
public class DoctorDAOImpl implements DoctorDAO{
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	
	public Doctor addDoctor(Doctor doctor) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(doctor);
		manager.getTransaction().commit();
		manager.close();
		return doctor;
	}

	

	@Override
	
	public Doctor updateDoctor(Doctor doctor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Doctor updateDoctor = manager.find(Doctor.class, doctor.getDoctorId());
		BeanUtils.copyProperties(doctor, updateDoctor);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updateDoctor;
	}

	@Override
	public Doctor removeDoctor(int doctorId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Doctor doctor = manager.find(Doctor.class, doctorId);
		 manager.remove(doctor);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return doctor;
	}


	@Override
	public List<RatingDetails> getAllRatings() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<RatingDetails> query = manager.createQuery("FROM Appointment", RatingDetails.class);
		List<RatingDetails> allRatings = query.getResultList();
		return allRatings;
	}

	@Override
	
	public List<Appointment> getAllScheduledAppointment() {
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Appointment> query = manager.createQuery("FROM Appointment", Appointment.class);
		return query.getResultList();
	}

	@Override
	
	public DoctorAvailability updateAvailability(DoctorAvailability availability) {
	
		EntityManager manager = factory.createEntityManager();
		DoctorAvailability newAvailability = manager.find(DoctorAvailability.class, availability.getAvailabilityStatus());
		BeanUtils.copyProperties(availability, newAvailability);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return newAvailability;

	}
	
	@Override
	
	public List<DoctorTimeslot> updateTimeslot(Date timeslotsFrom,Date timeslotsTo){
		EntityManager manager = factory.createEntityManager();
		TypedQuery<DoctorTimeslot> query = manager.createQuery("UPDATE DoctorTimeslot set timeslotsFrom= :timeslotFrom, timeslotsTo= :timeslotTo where id= :doctorId", DoctorTimeslot.class);
		return query.getResultList();
	
	}
}

	
	
	
