package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {

	@Modifying
	@Query("update Solution s set s.solutionStatus = solutionStatus where s.solutionId = solutionId")
	public void updateStatus(boolean solutionStatus, int solutionId);

	@Query("select s from Solution s where s.bug.bugId =: bugId")
	public List<Solution> allSolutionsForABug(@Param("bugId") int bugId);

	public List<Solution> findByBug(Bug bug);	
}
