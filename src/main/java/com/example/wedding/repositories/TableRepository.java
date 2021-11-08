package com.example.wedding.repositories;

import com.example.wedding.models.WeddingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<WeddingTable, Long> {

    //liste des tables par Nom par ordre alphabetique
    List<WeddingTable> findAllByOrderByTableNameAsc();

    @Query(value = "select w.*\n" +
            "from wedding_table w left join guest g on w.id = g.table_id\n" +
            "group by w.id having count(g.id)<4", nativeQuery = true)
    List<WeddingTable> findATableNotFull();

}
