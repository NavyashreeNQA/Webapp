package com.tyss.bookmydoctor.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;

import com.tyss.bookmydoctor.app.dto.Appointment;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;

public class AdminDAOImpl implements AdminDAO{
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
	public Doctor removeDoctor(String email) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Doctor doctor = manager.find(Doctor.class, email);
		manager.remove(doctor);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return doctor;
	}
	
	@Override
	public Patient removePatient(String email) {
		
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
	public List<Appointment> viewAllAppointments(){
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Appointment> query = manager.createQuery("FROM Appointment", Appointment.class);
		return query.getResultList();
	}
	
	@Override
	public Doctor updateDoctor(Doctor doctor) {
		
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
	public List<Doctor> getAllDoctor(){
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Doctor> query = manager.createQuery("FROM Doctor", Doctor.class);
		return query.getResultList();
	}
	
	@Override
	public List<Patient> getAllPatient(){
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Patient> query = manager.createQuery("FROM Patient", Patient.class);
		return query.getResultList();
	}
	
	@Override
	public Appointment removeAppointment(int appointmentId) {
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Appointment deleteAppointment = manager.find(Appointment.class, appointmentId);
		manager.remove(deleteAppointment);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return deleteAppointment;
	}
}
