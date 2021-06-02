package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Status;
import com.bugbounty.models.User;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer>{

    public List<Bug> findAll();
    
    public Bug findByBugId(int bugId);
    
    public List<Bug> findByBugStatus(Status status);
    
    public List<Bug> findAllByBugOwner(User bugOwner);
}
