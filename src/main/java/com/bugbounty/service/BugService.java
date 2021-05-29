package com.bugbounty.service;

import com.bugbounty.models.Bug;
import com.bugbounty.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugbounty.repository.BugRepository;
import com.bugbounty.repository.RoleRepository;
import com.bugbounty.repository.SolutionRepository;
import com.bugbounty.repository.StatusRepository;
import com.bugbounty.repository.UserRepository;

import java.util.List;

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

	public List<Bug> getAllBugsByUserId(int userId){
		return bugRepo.findAllFromUserId(userId);
	}

	public Bug updateBug(Bug bug)
	{
		return bugRepo.save(bug);
	}

	public int insertBug(Bug bug){
		return bugRepo.save(bug).getBugId();
	}

	public List<Bug> getAllBugs(){
		return bugRepo.findAll();
	}

	public List<Bug> getAllAcceptedBugs(int statusId){
		return bugRepo.findAllAcceptedBugs(statusId);
	}



}
