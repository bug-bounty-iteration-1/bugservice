package com.bugbounty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugbounty.models.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer>{

    public List<Bug> findAll();

    @Query("select b from Bug b JOIN b.bugOwner bo where bo.userId = userId")
    public List<Bug> findAllFromUserId(int userId);

    public Bug findByBugId(int bugId);




}
