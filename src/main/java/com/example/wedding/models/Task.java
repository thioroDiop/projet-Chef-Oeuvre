package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo( scope = Task.class,// l'id est unique sur cette classe "Task"
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq",allocationSize = 1)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "task")
    private List<Guest> guestList;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


}
