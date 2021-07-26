package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class RelationShip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "relation_id_seq")
    @SequenceGenerator(name = "relation_id_seq",allocationSize = 1)
    private Long id;

    private String relationType;
@JsonIgnore
    @OneToMany (mappedBy = "relationShip")
    private List<Guest> guestList;

    public RelationShip() {
    }

    public Long getId() {
        return id;
    }

    public String getRelationType() {
        return relationType;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }
}
