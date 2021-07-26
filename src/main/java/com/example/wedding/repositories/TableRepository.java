package com.example.wedding.repositories;

import com.example.wedding.models.WeddingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<WeddingTable,Long> {

   //liste des tables par Nom par ordre alphabetique
   List<WeddingTable> findAllByOrderByTableNameAsc();

}
