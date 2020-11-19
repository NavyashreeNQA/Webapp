package com.tyss.bookmydoctor.app.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.BeanUtils;

import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.User;

public class UserDAOImpl implements UserDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	public User addUser(User user) {
		EntityManager manager = factory.createEntityManager(); 
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;
	}

	@Override
	public User removeUser(int userID) {
		EntityManager manager = factory.createEntityManager(); 
		User user1=manager.find(User.class,userID);
		if(user1!=null) {
			manager.getTransaction().begin();
			manager.remove(user1);
			manager.getTransaction().commit();
			manager.close();
			return user1;
		}
		else {
			manager.close();
		return null;
		}
	}
	
	
	@Override
	public User updateUser(User user) {
		EntityManager manager = factory.createEntityManager(); 
		
		User user1=manager.find(User.class, user.getUserId());
		if(user1!=null) {
		manager.getTransaction().begin();
		BeanUtils.copyProperties(user,user1);
		manager.getTransaction().commit();
		manager.close();
		return user1;	
		}
		else {
			manager.close();
			return null;
		}
	}

	@Override
	public List<User> getUser(String userName) {
		EntityManager manager = factory.createEntityManager(); 
		TypedQuery<User> query = manager.createNamedQuery("FROM User U Where U.email =:value OR U.userName=:value", User.class);
		query.setParameter("value","%"+userName+"%");
		List<User> userList =  query.getResultList();
		if(userList.isEmpty()) {
			manager.close();
			return null;
		}
		else {
			manager.close();
			return userList;
		}
	}
		
	@Override
	public User userAuthentication(String email, String passowrd) {

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<User> query = manager
				.createQuery("SELECT u FROM User u WHERE u.email= :emailId AND u.passowrd = :password", User.class);
		query.setParameter("email", email);
		query.setParameter("password", passowrd);
		User user=query.getSingleResult();
		if (user != null) {
			manager.close();
			return user;
		} else {
			manager.close();
			return null;
		}

	}

	@Override
	public Doctor registerDoctor(Doctor doctor) {
		EntityManager manager = factory.createEntityManager(); 
		manager.getTransaction().begin();
		manager.persist(doctor);
		manager.getTransaction().commit();
		manager.close();
		return doctor;
	}

	@Override
	public Patient registerPatient(Patient patient) {
		EntityManager manager = factory.createEntityManager(); 
		manager.getTransaction().begin();
		manager.persist(patient);
		manager.getTransaction().commit();
		manager.close();
		return patient;
	}

	
	
	
}
