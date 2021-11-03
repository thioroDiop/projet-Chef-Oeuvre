package com.example.wedding.controllers;

import com.example.wedding.models.BridalCouple;
import com.example.wedding.models.Gift;
import com.example.wedding.repositories.CoupleRepository;
import com.example.wedding.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/couple")
public class CoupleController {
    @Autowired
    private CoupleRepository coupleRepository;

    public CoupleController(CoupleRepository coupleRepository) {
        this.coupleRepository = coupleRepository;
    }
//nombre d'invités par marié
    @GetMapping("/nbGuest")
    public Object getGuestByCoupleID(){
        return coupleRepository.countGuestByBridal();
    }

    @GetMapping
    public List<BridalCouple> getCouple(){
        return coupleRepository.findAll();
    }
}

