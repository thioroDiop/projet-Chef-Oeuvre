package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity

public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gift_id_seq")
    @SequenceGenerator(name = "gift_id_seq",allocationSize = 1)
    private Long id;
    private String Name;
    @Column(length = 355)
    private String description;
    private Double price;

    private String imageUrl;



    @JsonIgnore

    @OneToMany(mappedBy = "gift")
    private List<Guest> guestList;

    public Gift() {
    }

    public Double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }


}
