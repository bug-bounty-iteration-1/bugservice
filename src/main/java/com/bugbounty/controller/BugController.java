package com.bugbounty.controller;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;
import com.bugbounty.models.User;

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

	@PostMapping("/new-bug")
	public ResponseEntity<String> insertBug(@RequestBody Bug bug){
		this.bugServ.insertBug(bug.getBugDescription(), bug.getBugSubmissionDate(), bug.getBugOwner());
		return new ResponseEntity<String>("Bug Created", HttpStatus.CREATED);
	}

	
	@GetMapping("/accepted")
	public ResponseEntity<List<Bug>> getAllAcceptedBugs(){
		return new ResponseEntity<List<Bug>>(bugServ.getAllAcceptedAndResolvedBugs(), HttpStatus.OK);
	}

	
	@PostMapping("/update-bugStatus")
	public ResponseEntity<Integer> updateBugStatus(@RequestBody Bug bug){
		
						
		return new ResponseEntity<Integer>(bugServ.updateBugStatus(bug), HttpStatus.OK);
	}
	
	@GetMapping("/user-bug")
	public ResponseEntity<List<Bug>> getAllBugsByUser(@RequestBody User user) {
//		User user = "should be done at LoginService";
		
		List<Bug> bugs = bugServ.getAllBugsByUser(user);
		
		return new ResponseEntity<List<Bug>>(bugs, HttpStatus.OK);
	}

}
