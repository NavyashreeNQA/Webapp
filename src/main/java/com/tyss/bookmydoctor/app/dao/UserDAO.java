package com.tyss.bookmydoctor.app.dao;

import java.util.List;

import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.User;

public interface UserDAO {
	public User addUser(User user);
	public Doctor registerDoctor(Doctor doctor);
	public Patient registerPatient(Patient patient);
	public User removeUser(int userID);
	public User updateUser(User user);
	public List<User> getUser(String email);
	public User userAuthentication(String username,String password); 
}
