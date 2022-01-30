package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query("select b from Branch b where upper(b.branch_name) = upper(?1)")
    List<Branch> findByBranch_nameIgnoreCase(String branch_name);



}