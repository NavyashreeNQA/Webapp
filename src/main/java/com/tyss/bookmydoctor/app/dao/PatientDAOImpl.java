package com.tyss.bookmydoctor.app.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;

import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.DoctorAvailability;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.RatingDetails;


public class PatientDAOImpl implements PatientDAO{
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	
	public Patient addPatient(Patient patient) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		manager.persist(patient);
		manager.getTransaction().commit();
		manager.close();
		return patient;
	}

	@Override
	
	public Patient updatePatient(Patient updatePatient) {
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Patient updatedPatient = manager.find(Patient.class, updatePatient.getPatientId());
		BeanUtils.copyProperties(updatePatient, updatePatient);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return updatedPatient;
	}

	@Override
	public Patient deletePatient(String email) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Patient deletePatient = manager.find(Patient.class, email);
		manager.remove(deletePatient);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deletePatient;
		
	}


	@Override
	public DoctorAvailability bookAppointment(DoctorAvailability availability) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		DoctorAvailability bookNewAppointment = new DoctorAvailability();
		BeanUtils.copyProperties(availability, bookNewAppointment);
		manager.persist(bookNewAppointment);
		return bookNewAppointment;
	}

	@Override
	public List<Doctor> viewAllDoctors(Doctor viewAllDoctor) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Doctor> query = manager.createQuery("FROM Doctor", Doctor.class);
		return query.getResultList();
	}

	
	@Override
	public RatingDetails giveRatings(RatingDetails rating) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager manager = factory.createEntityManager();
		RatingDetails newRating = new RatingDetails();
		BeanUtils.copyProperties(rating, newRating);
		manager.persist(newRating);
		return rating;
	}

}
