package com.example.wedding.repositories;

import com.example.wedding.models.BridalCouple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<BridalCouple,Long> {
}
