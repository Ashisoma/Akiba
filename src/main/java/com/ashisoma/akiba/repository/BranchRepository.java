package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}