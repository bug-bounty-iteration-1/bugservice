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

	@PostMapping("/new-bug")
	public ResponseEntity<String> insertBug(@RequestBody Bug bug){
		this.bugServ.insertBug(bug.getBugDescription(), bug.getBugSubmissionDate(), bug.getBugOwner());
		return new ResponseEntity<String>("Bug Created", HttpStatus.CREATED);
	}

	
	@GetMapping("/accepted")
	public ResponseEntity<List<Bug>> getAllAcceptedBugs(){
		return new ResponseEntity<List<Bug>>(bugServ.getAllAcceptedAndResolvedBugs(), HttpStatus.OK);
	}

//	@PostMapping("/update-bugStatus/{statusId}")
//	public ResponseEntity<Integer> updateBugStatus(@RequestBody Bug bug, @PathVariable int statusId){
//				
//		return new ResponseEntity<Integer>(bugServ.updateBugStatus(bug, statusId), HttpStatus.OK);
//	}
	
	
	
	@PostMapping("/update-bugStatus")
	public ResponseEntity<Integer> updateBugStatus(@RequestBody Bug bug){
		
						
		return new ResponseEntity<Integer>(bugServ.updateBugStatus(bug), HttpStatus.OK);
	}

}
