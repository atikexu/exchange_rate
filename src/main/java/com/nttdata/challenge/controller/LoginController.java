package com.nttdata.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.challenge.config.JWTAuthtenticationConfig;
import com.nttdata.challenge.dto.UserDto;

@RestController
public class LoginController {
	
	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;
    
	@PostMapping("/login")
	public UserDto login(@RequestParam("user") String username,@RequestParam("pass") String pass) {

		String token = jwtAuthtenticationConfig.getJWTToken(username);
		return new UserDto(username, pass,token);
		
	}

}
