package com.bugbounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugbounty.service.SolutionService;

@RestController
public class SolutionController {

	private SolutionService solutionServ;

	@Autowired
	public SolutionController(SolutionService solutionServ) {
		super();
		this.solutionServ = solutionServ;
	}

	public SolutionController() {
		super();
	}

}
