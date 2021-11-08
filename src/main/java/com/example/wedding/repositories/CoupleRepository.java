package com.example.wedding.repositories;

import com.example.wedding.models.BridalCouple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoupleRepository extends JpaRepository<BridalCouple, Long> {

    @Query(value = "select count (guest.id),bc.name\n" +
            "from guest join bridal_couple bc on bc.id = guest.bridal_id\n" +
            "group by bc.name", nativeQuery = true)
    List<Object> countGuestByBridal();
}
