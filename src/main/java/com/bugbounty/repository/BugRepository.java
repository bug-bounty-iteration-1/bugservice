package com.bugbounty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bugbounty.models.Bug;
import com.bugbounty.models.Status;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer>{

    public List<Bug> findAll();

    @Query("select b from Bug b JOIN b.bugOwner bo where bo.userId = userId")
    public List<Bug> findAllFromUserId(int userId);

    public Bug findByBugId(int bugId);

//    @Query("select b from Bug b JOIN b.bugStatus bs where bs.statusId = 2")
//    public List<Bug> findAllAcceptedBugs(int statusId);
    
    public List<Bug> findByBugStatus(Status status);
    

}
