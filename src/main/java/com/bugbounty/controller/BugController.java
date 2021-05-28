package com.bugbounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugbounty.service.BugService;

@RestController
public class BugController {

	private BugService bugServ;

	@Autowired
	public BugController(BugService bugServ) {
		super();
		this.bugServ = bugServ;
	}

	public BugController() {
		super();
	}

}
