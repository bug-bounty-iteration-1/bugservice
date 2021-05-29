package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bugbounty.models.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {

	
	
	@Modifying
	@Query("update solutions s set s.status = ?1 where s.solution_id = ?2")
	public void updateStatus(boolean solutionStatus, int solutionId);
	
	@Query("select * from solutions s  where s.bug_id_fk = ?1")
	public List<Solution> allSolutionsForABug(int bug_id_fk);
	
	
}
