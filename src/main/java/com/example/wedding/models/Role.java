package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", allocationSize = 1)
    private Long id;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Guest> guestList;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


}
