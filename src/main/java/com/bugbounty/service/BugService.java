package com.bugbounty.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;
import com.bugbounty.models.Status;
import com.bugbounty.models.User;
import com.bugbounty.repository.BugRepository;
import com.bugbounty.repository.RoleRepository;
import com.bugbounty.repository.SolutionRepository;
import com.bugbounty.repository.StatusRepository;
import com.bugbounty.repository.UserRepository;

@Service
public class BugService {

	private BugRepository bugRepo;
	private RoleRepository roleRepo;
	private SolutionRepository solutionRepo;
	private StatusRepository statusRepo;
	private UserRepository userRepo;

	@Autowired
	public BugService(BugRepository bugRepo, RoleRepository roleRepo, SolutionRepository solutionRepo,
			StatusRepository statusRepo, UserRepository userRepo) {
		super();
		this.bugRepo = bugRepo;
		this.roleRepo = roleRepo;
		this.solutionRepo = solutionRepo;
		this.statusRepo = statusRepo;
		this.userRepo = userRepo;
	}

	public BugService() {

	}

	public int insertBug(String description, LocalDateTime submissionDate, User bugOwner) {
		Bug bug = new Bug();
		bug.setBugDescription(description);
		bug.setBugSubmissionDate(submissionDate);
		bug.setBugOwner(bugOwner);
		bug.setBugStatus(statusRepo.getById(1));

		return bugRepo.save(bug).getBugId();
	}

	public List<Bug> getAllBugs() {
		return bugRepo.findAll();
	}

	// get all resolved bugs for point calculation
	public List<Bug> getAllResolvedBugs() {
		List<Bug> bugsResolved = bugRepo.findByBugStatus(statusRepo.getById(3));
		return bugsResolved;
	}

	public List<Bug> getAllAcceptedAndResolvedBugs() {
		List<Bug> bugsAccepted = bugRepo.findByBugStatus(statusRepo.getById(2));
		List<Bug> bugsResolved = bugRepo.findByBugStatus(statusRepo.getById(3));
		bugsAccepted.addAll(bugsResolved);
		return bugsAccepted;
	}

//	public int updateBugStatus(Bug bug, int statusId) {
//		Status status = statusRepo.getById(statusId);
//		bug.setBugStatus(status);
//		return bugRepo.save(bug).getBugId();
//	}

	public int updateBugStatus(Bug bug) {

		// Status status = statusRepo.getById(statusId);
		// bug.setBugStatus(status);
		// bug.setBugStatus(statusRepo.getById(bug.getBugStatus().getStatusId()));

		Bug mybug = bugRepo.getById(bug.getBugId());
		if (bug.getBugStatus() != null) {
			mybug.setBugStatus(bug.getBugStatus());
		}

		return bugRepo.save(mybug).getBugId();
	}
	
	// get all bugs by userId
	public List<Bug> getAllBugsByUser(User user) {
		List<Bug> bugs = new ArrayList<>();
		bugs = bugRepo.findAllByBugOwner(user);
		return bugs;
	}

}
