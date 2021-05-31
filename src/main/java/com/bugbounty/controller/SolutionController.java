package com.bugbounty.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugbounty.models.Solution;
import com.bugbounty.models.User;
import com.bugbounty.repository.BugRepository;
import com.bugbounty.repository.SolutionRepository;
import com.bugbounty.service.SolutionService;

@RestController
@RequestMapping(value = "/solutions")
public class SolutionController {

	private SolutionService solutionServ;
	private BugRepository bugRepository;
	private SolutionRepository solutionRepository;

	@Autowired
	public SolutionController(SolutionService solutionServ, BugRepository bugRepository, SolutionRepository solutionRepository) {
		super();
		this.solutionServ = solutionServ;
		this.bugRepository = bugRepository;
		this.solutionRepository = solutionRepository;
	}

	public SolutionController() {
		super();
	}

	@PostMapping("/update-solution-status")
	public ResponseEntity<Boolean> updateSolutionStatus(@RequestBody Solution solution) {
		boolean result = this.solutionServ.updateSolutionStatus(solution);
		return new ResponseEntity<Boolean>(result, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{bugId}") 
	public ResponseEntity<List<Solution>> getSolutionByBug(@PathVariable("bugId") int id) {
		List<Solution> solutions = this.solutionServ.allSolutionsForBug(id);
		
		return new ResponseEntity<List<Solution>>(solutions, HttpStatus.OK);
	}

	// public int insertSolution(String solution, LocalDateTime solutionSubmissionDate, Bug bug, User user)
	
	@PostMapping("/new-solution")
	public ResponseEntity<Integer> createSolution(@RequestBody Solution solution) {
		int solutionId = this.solutionServ.insertSolution(solution.getSolution(), solution.getSolutionSubmissionDate(),
						solution.getBug(), solution.getUser());
		
		return new ResponseEntity<>(solutionId, HttpStatus.CREATED);
	}
	
	@GetMapping("/calc")
	public ResponseEntity<HashMap<User, Integer>> calculatePoints() {
		HashMap<User, Integer> points = new HashMap<>();
		points = solutionServ.getUserPointsMap();
		
		return new ResponseEntity<HashMap<User, Integer>>(points, HttpStatus.OK);
	}
}
