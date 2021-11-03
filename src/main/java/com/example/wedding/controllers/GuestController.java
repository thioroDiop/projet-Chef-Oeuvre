package com.example.wedding.controllers;

import com.example.wedding.models.Gift;
import com.example.wedding.models.Guest;
import com.example.wedding.models.Role;
import com.example.wedding.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping//Liste des invités par Ordre alphabetique
    public List<Guest> getAllGuest() {
        return guestRepository.findAllByOrderByLastNameAsc();
    }

    @GetMapping("/guest/{guestId}")
    public Optional<Guest> getGuestByID(@PathVariable Long guestId) {
        return guestRepository.findById(guestId);
    }

    //Supprimer un invité
    @DeleteMapping("/{guestId}")
    public void deleteGuest(@PathVariable Long guestId) {
        guestRepository.deleteById(guestId);
    }


    //Ajouter un invité
    @PostMapping()
    public ResponseEntity<Guest> createGuest(@RequestBody Guest newGuest) {
        try {
            return ResponseEntity.ok(this.guestRepository.save(newGuest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Transactional
    @PutMapping(value = "/guest/update")
    public ResponseEntity<Guest> updateCustomer(@RequestBody Guest oldGuest) {
        return new ResponseEntity<Guest>(guestRepository.save(oldGuest), HttpStatus.OK);
    }

    //Mettre à jour un invité
    @PutMapping("/{identifiant}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long identifiant,
                                             @RequestBody Guest oldGuest) {
        if (!oldGuest.getId().equals(identifiant)) {
            return new ResponseEntity<>(oldGuest
                    , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Guest>(guestRepository.save(oldGuest)
                , HttpStatus.OK);
    }

    @GetMapping("/{coupleId}") //Liste des invités par Marié
    public List<Guest> getAllGuestByBridalId(@PathVariable Long coupleId) {
        return guestRepository.findAllByBridal_Id(coupleId);
    }

    //liste des invités par table (via id)
    @GetMapping("/table/{tableId}")
    public List<Guest> getAllGuestByTableId(@PathVariable Long tableId) {
        return guestRepository.findAllByTable_Id(tableId);
    }

    //Qui fait quoi? liste des invités par tache
    @GetMapping("/tache/{taskId}")
    public List<Guest> getAllGuestByTaskId(@PathVariable Long taskId) {
        return guestRepository.findAllByTaskId(taskId);
    }

    // liste des invités par Role
    @GetMapping("/role/{roleId}")
    public List<Guest> getAllGuestByRoleId(@PathVariable Long roleId) {
        return guestRepository.findAllByRoleId(roleId);
    }


    //liste des invité par relationID pour les Photos
    @GetMapping("/relation/{relationId}")
    public List<Guest> getAllGuestByRelationId(@PathVariable Long relationId) {
        return guestRepository.findAllByRelationShipId(relationId);
    }

    //liste des personnes à remercier pour leur cadeau
    @GetMapping("gifts")
    public List<Guest> getAllGuestByGift() {
        return guestRepository.getAllByGiftIsNotNull();
    }


    //liste des personnes par cadeau à remercier pour leur cadeau
    @GetMapping("gifts/{giftId}")
    public List<Guest> getAllGuestByGiftID(@PathVariable Long giftId) {
        return guestRepository.getAllByGift_Id(giftId);
    }

    // liste des invités par Hebergement
    @GetMapping("/accommodation/{accName}")
    public List<Guest> getAllGuestByAccommodation(@PathVariable String accName) {
        return guestRepository.findAllByAccommodationEquals(accName);
    }


    //liste des invités a placé sur les tables et donné une tache
    @GetMapping("/placed")
    public List<Guest> getAllGuestToPlace() {
        return guestRepository.findAllByTableIsNullAndRoleIsNullAndTaskIsNull();
    }

}
