package com.bugbounty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugbounty.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
