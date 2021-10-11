package com.example.wedding.repositories;

import com.example.wedding.models.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

 @Repository
public interface AppUserRepository extends JpaRepository<AppUsers, Long> {


    /**
     * fonction de recupération d'un utilisation par son user name en ignorant la casse
     *
     * @param username le username à chercher
     * @return un optional avec l'utilisateur s'il existe dans la BDD
     */
    Optional<AppUsers> findByUsernameIgnoreCase(String username);
}
