package com.bugbounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugbounty.service.UserService;

@RestController
public class UserController {

	private UserService userServ;

	@Autowired
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}

	public UserController() {

	}

}
