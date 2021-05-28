package com.bugbounty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugbounty.models.Bug;

public interface BugRepository extends JpaRepository<Bug, Integer>{

}
