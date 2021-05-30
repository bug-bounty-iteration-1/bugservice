package com.bugbounty.controller;

import com.bugbounty.models.Bug;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bugbounty.service.BugService;

import java.util.List;

@RestController
@RequestMapping(value = "/bug")
@CrossOrigin("*")
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

	@GetMapping()
	public ResponseEntity<List<Bug>> getAllBugs(){
		return new ResponseEntity<List<Bug>>(bugServ.getAllBugs(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<String> insertBug(@RequestBody Bug bug){
		System.out.println(bug);

		int userId = bug.getBugOwner().getUserId();

		//check if user exists


		bugServ.insertBug(bug);

		return new ResponseEntity<String>("Bug Created", HttpStatus.CREATED);
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<List<Bug>> getAllBugsByUserId(@PathVariable int userId){
		return new ResponseEntity<List<Bug>>(bugServ.getAllBugsByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("accepted/{statusId}")
	public ResponseEntity<List<Bug>> getAllAcceptedBugs(@PathVariable int statusId){
		statusId = 2;
		return new ResponseEntity<List<Bug>>(bugServ.getAllAcceptedBugs(statusId), HttpStatus.OK);
	}


}
