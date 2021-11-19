package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}