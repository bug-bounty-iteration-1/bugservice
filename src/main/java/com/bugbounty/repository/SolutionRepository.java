package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {

	@Modifying
	@Query("update Solution s set s.solutionStatus = solutionStatus where s.solutionId = solutionId")
	public void updateStatus(boolean solutionStatus, int solutionId);

	@Query("select s from Solution s where s.bug.bugId = bug_id_fk")
	public List<Solution> allSolutionsForABug(int bug_id_fk);

	public List<Solution> findByBug(Bug bug);
}
