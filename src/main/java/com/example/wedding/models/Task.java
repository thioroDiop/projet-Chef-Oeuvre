package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq",allocationSize = 1)
    private Long id;

    private String description;

   // @JsonIgnore
    @OneToMany(mappedBy = "task")
    private List<Guest> guestList;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public String getDescription() {
        return description;
    }


}
