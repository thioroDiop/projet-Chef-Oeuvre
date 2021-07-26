package com.example.wedding.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class BridalCouple {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bridal_id_seq")
   @SequenceGenerator(name = "bridal_id_seq",allocationSize = 1)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bridal")
    private List<Guest> guests;

    public BridalCouple() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
