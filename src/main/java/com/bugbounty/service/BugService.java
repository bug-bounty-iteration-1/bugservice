package com.bugbounty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
