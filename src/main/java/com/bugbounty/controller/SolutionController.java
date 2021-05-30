package com.bugbounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugbounty.models.Solution;
import com.bugbounty.service.SolutionService;

@RestController
@RequestMapping(value = "/solutions")
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

	@PostMapping("/update-solution-status")
	public ResponseEntity<Boolean> updateSolutionStatus(@RequestBody Solution solution) {
		boolean result = this.solutionServ.updateSolutionStatus(solution);
		return new ResponseEntity<Boolean>(result, HttpStatus.ACCEPTED);
	}
	

}
