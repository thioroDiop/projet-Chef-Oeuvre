package com.example.wedding.controllers;

import com.example.wedding.models.Gift;
import com.example.wedding.models.Role;
import com.example.wedding.models.Task;
import com.example.wedding.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public Optional<Gift> getGiftByID(@PathVariable Long giftId) {
        return giftRepository.findById(giftId);
    }

    /**
     * Fonction de récupération de toutes les cadeaux (de manière paginée)
     *
     * @param pageable Les paramètres de pagination que l'on veut spécifier
     *                 On peut utiliser :
     *                 page=x pour spécifier le numéro de page
     *                 size=y pour spécifier la taille de la page
     *                 sort=sortParams pour spécifier le tri des données
     *                 Exemple d'appel : /api/quotes?page=2&size=35&sort=movie,asc,ignorecase
     * @return le contenu de la page demandée
     */
    @GetMapping
    //responseEntity permet de jouer avec la réponse http si ça se passe bien ou mal qu'est ce que je fais
    public ResponseEntity<List<Gift>> getAllGift(Pageable pageable) {
        return ResponseEntity.ok(giftRepository.findAll(pageable).getContent());
        //getContent() transforme un type de donnée en liste
    }
    // @GetMapping
   /* public List<Gift> getAllGift(){
        return giftRepository.findAll();
    }*/

    /**
     * fonction qui compte le total de cadeaux dans ma BDD
     *
     * @return le nombre de cadeaux
     */
    @GetMapping("/count")
    ResponseEntity<Long> getTotalGiftsNumber() {
        return ResponseEntity.ok(giftRepository.count());
    }

    //fonction qui retourne la liste des cadeaux avec les montants injectées
@GetMapping("amount")
    public ResponseEntity<List<Object>> getGiftWithAmount() {
    return ResponseEntity.ok(giftRepository.amountByGift());
}

}
