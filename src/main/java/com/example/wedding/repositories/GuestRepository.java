package com.example.wedding.repositories;

import com.example.wedding.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    List<Guest> findAllByOrderByLastNameAsc();
    List<Guest> findAllByBridal_Id(Long bridalId);


    List<Guest> findAllByTable_Id (Long tableId);


    void deleteById(Long guestId);


    void deleteAllById(Long guestId);
}
