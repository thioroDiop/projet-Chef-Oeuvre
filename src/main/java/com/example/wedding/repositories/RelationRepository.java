package com.example.wedding.repositories;


import com.example.wedding.models.Guest;
import com.example.wedding.models.RelationShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<RelationShip,Long> {

}
