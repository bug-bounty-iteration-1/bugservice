package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;
import com.bugbounty.models.User;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
	
	public List<Solution> findByBug(Bug bug);
	
	public List<Solution> findAllByUser(User user);
}
