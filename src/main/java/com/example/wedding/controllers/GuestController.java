package com.example.wedding.controllers;

import com.example.wedding.models.Guest;
import com.example.wedding.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4100")
@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping//Liste des invités par Ordre alphabetique
    public List<Guest> getAllGuest(){
        return guestRepository.findAllByOrderByLastNameAsc();
    }

    //Supprimer un invité
    @DeleteMapping("/{guestId}")
    public void deleteGuest(Long guestId){guestRepository.deleteById(guestId);}


    //Ajouter un invité
    @PostMapping()
public ResponseEntity<Guest> createGuest(@RequestBody Guest newGuest){
        try {
            return ResponseEntity.ok(this.guestRepository.save(newGuest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    //Mettre à jour un invité
    @PutMapping("/{identifiant}")
    public  ResponseEntity<Guest> updateGuest(@PathVariable("identifiant") Long id,
                                                      @RequestBody Guest oldGuest){
        if(!oldGuest.getId().equals(id)){
            return new ResponseEntity<>(oldGuest
                    , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Guest>(guestRepository.save(oldGuest)
                ,HttpStatus.OK);

    }

    @GetMapping("/{coupleId}") //Liste des invités par Marié
    public List<Guest> getAllGuestByBridalId(@PathVariable Long coupleId){
        return guestRepository.findAllByBridal_Id(coupleId);
    }

//liste des invités par table (via id)
    @GetMapping("/table/{tableId}")
    public List<Guest> getAllGuestByTableId(@PathVariable Long tableId){
        return  guestRepository.findAllByTable_Id(tableId);
    }
}
