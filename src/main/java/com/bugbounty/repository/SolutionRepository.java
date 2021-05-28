package com.bugbounty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugbounty.models.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {

}
