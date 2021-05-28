package com.bugbounty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugbounty.models.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
