package com.example.wedding.controllers;

import com.example.wedding.models.Guest;
import com.example.wedding.models.RelationShip;
import com.example.wedding.models.Role;
import com.example.wedding.repositories.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/relationship")
public class RelationShipController {
    @Autowired
    private RelationRepository relationRepository;

    public RelationShipController(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

    @GetMapping
    public List<RelationShip> getAllRelation(){
        return  relationRepository.findAll();   }

    @GetMapping("/{relationId}")
    public Optional<RelationShip> getRelationByID(@PathVariable Long relationId){
        return relationRepository.findById(relationId);
    }



}
