package com.bugbounty.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;
import com.bugbounty.models.User;
import com.bugbounty.repository.BugRepository;
import com.bugbounty.repository.RoleRepository;
import com.bugbounty.repository.SolutionRepository;
import com.bugbounty.repository.StatusRepository;
import com.bugbounty.repository.UserRepository;

@Service
public class SolutionService {

	private BugRepository bugRepo;
	private RoleRepository roleRepo;
	private SolutionRepository solutionRepo;
	private StatusRepository statusRepo;
	private UserRepository userRepo;
	private BugService bugServ;

	@Autowired
	public SolutionService(BugRepository bugRepo, RoleRepository roleRepo, SolutionRepository solutionRepo,
			StatusRepository statusRepo, UserRepository userRepo, BugService bugServ) {
		super();
		this.bugRepo = bugRepo;
		this.roleRepo = roleRepo;
		this.solutionRepo = solutionRepo;
		this.statusRepo = statusRepo;
		this.userRepo = userRepo;
		this.bugServ = bugServ;
	}

	public SolutionService() {
		super();
	}

	// Update solution status by user

	public boolean updateSolutionStatus(Solution solution) {
		Solution mySolution = this.solutionRepo.getById(solution.getSolutionId());
		mySolution.setSolutionStatus(solution.isSolutionStatus());
		this.solutionRepo.save(mySolution);
		return true;
	}

	// Create Solution

	public int insertSolution(String solution, LocalDateTime solutionSubmissionDate, Bug bug, User user) {

		if (bug.getBugOwner().getUserId() == user.getUserId()) {
			return -1;
		}

		Solution s = new Solution();

		s.setSolution(solution);
		s.setSolutionStatus(false);
		s.setSolutionSubmissionDate(solutionSubmissionDate);
		s.setBug(bug);
		s.setUser(user);

		return solutionRepo.save(s).getSolutionId();
	}

	// return list of all solutions for a particular bug

	public List<Solution> allSolutionsForBug(int bugId) {
		Bug bug = this.bugRepo.getById(bugId);
		List<Solution> solutions = this.solutionRepo.findByBug(bug);

		return solutions;
	}

	// get all solutions with status true
	public List<Solution> getAllSolutionResolved() {
		List<Bug> resolvedBugs = bugServ.getAllResolvedBugs();
		List<Solution> solutions = new ArrayList<>();
		for (Bug bug : resolvedBugs) {
			solutions.addAll(solutionRepo.findByBug(bug));
		}

		List<Solution> trueSolutions = new ArrayList<>();
		for (Solution solution : solutions) {
			if (solution.isSolutionStatus()) {
				trueSolutions.add(solution);
			}
		}

		return trueSolutions;
	}

	// get user from solutions resolved (solutions with status of true)
	public HashMap<User, Integer> getUserPointsMap() {
		HashMap<User, Integer> userPoints = new HashMap<>();
		List<Solution> solutionResolved = getAllSolutionResolved();
		for (Solution solution : solutionResolved) {
			User u = solution.getUser();
			if (userPoints.get(u) == null) {
				userPoints.put(u, 1);
			} else {
				userPoints.put(u, userPoints.get(u) + 1);
			}
		}
		return userPoints;
	}

}
