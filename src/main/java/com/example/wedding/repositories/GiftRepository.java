package com.example.wedding.repositories;

import com.example.wedding.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {

}
