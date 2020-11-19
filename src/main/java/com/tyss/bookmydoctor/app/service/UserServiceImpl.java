package com.tyss.bookmydoctor.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.bookmydoctor.app.dao.UserDAO;
import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.User;
import com.tyss.bookmydoctor.app.exception.BookMyDoctorException;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;
	
	@Override
	public User userAuthentication(String username, String password) {
		
		User user= userDao.userAuthentication(username, password);
		
		if(user!=null) {
			return user;
		} else {
			throw new BookMyDoctorException("Invalid credentials");
		}
	}

	@Override
	public User addUser(User user) {
		User user1= userDao.addUser(user);
		
		if(user1!=null) {
			return user1;
		} else {
			throw new BookMyDoctorException("Unable to add user");
		}
	}

	@Override
	public User removeUser(int userID) {
		User user2= userDao.removeUser(userID);
		
		if(user2!=null) {
			return user2;
		} else {
			throw new BookMyDoctorException("Invalid userId");
		}
	}

	@Override
	public User updateUser(User user) {
		User user3= userDao.updateUser(user);
		
		if(user3!=null) {
			return user3;
		} else {
			throw new BookMyDoctorException("Unable to update user details");
		}
	}

	@Override
	public List<User> getUser(String email) {
		 List<User> users = userDao.getUser(email);
		if(users!=null) {
			return users;
		} else {
			throw new BookMyDoctorException("User not found");
		}
	}

	@Override
	public Doctor registerDoctor(Doctor doctor) {
		 Doctor addDoctor = userDao.registerDoctor(doctor);
		if(addDoctor!=null) {
			return addDoctor;
		} else {
			throw new BookMyDoctorException("Unable to register");
		}

	}

	@Override
	public Patient registerPatient(Patient patient) {
		Patient addPatient = userDao.registerPatient(patient);
		if(addPatient!=null) {
			return addPatient;
		} else {
			throw new BookMyDoctorException("Unable to register");
		}

	}

}
