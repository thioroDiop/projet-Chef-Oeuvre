package com.example.wedding.controllers;

import com.example.wedding.models.Gift;
import com.example.wedding.models.Role;
import com.example.wedding.models.Task;
import com.example.wedding.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/gifts")
public class GiftController {
    @Autowired
    private GiftRepository giftRepository;

    public GiftController(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @GetMapping("/{giftId}")
    public Optional<Gift> getGiftByID(@PathVariable Long giftId){
        return giftRepository.findById(giftId);
    }

    @GetMapping
    public List<Gift> getAllGift(){
        return giftRepository.findAll();
    }
}
