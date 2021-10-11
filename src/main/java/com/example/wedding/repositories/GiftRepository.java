package com.example.wedding.repositories;

import com.example.wedding.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {

    //fonction qui envoie un object car n'existe pas dans les modeles
    @Query(value = "select g.*,sum(amount_participation)\n" +
            "from guest join gift g on g.id = guest.gift_id\n" +
            "group by g.id", nativeQuery = true)
    List<Object> amountByGift();
}
