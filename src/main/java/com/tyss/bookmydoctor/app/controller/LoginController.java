package com.tyss.bookmydoctor.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.bookmydoctor.app.dto.Doctor;
import com.tyss.bookmydoctor.app.dto.Patient;
import com.tyss.bookmydoctor.app.dto.User;
import com.tyss.bookmydoctor.app.service.UserService;

@RestController
public class LoginController {
	@Autowired
	
	private UserService userService;
	
	@GetMapping("/register")
	public String getRegister(User user) {
		User user1 = userService.addUser(user);
		if(user1!=null) {
			return ("Registration is successful");
		} else {
			return ("Registration is unsuccessful");
		}
	}
	
	@GetMapping("/register-doctor")
	public String registerDoctor(Doctor doctor) {
		Doctor doctor1 = userService.registerDoctor(doctor);
		if(doctor1!=null) {
			return ("Registration is successful");
		} else {
			return ("Registration is unsuccessful");
		}
	}
	
	@GetMapping("/register-patient")
	public String registerPatient(Patient patient) {
		Patient patient1 = userService.registerPatient(patient);
		if(patient1!=null) {
			return ("Registration is successful");
		} else {
			return ("Registration is unsuccessful");
		}
	}
	
	@PostMapping("/login")
	public String getLogin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		User user = userService.userAuthentication(email, password);
		if (user != null) {
			return "Login is successfull";
		} else {
			return "Unable to login";
		}
	}

}
