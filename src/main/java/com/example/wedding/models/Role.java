package com.example.wedding.models;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
import javax.persistence.*;

@Entity
@JsonIdentityInfo( scope = Role.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq",allocationSize = 1)
    private Long id;

    private String description;

    @OneToMany (mappedBy = "role")
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
