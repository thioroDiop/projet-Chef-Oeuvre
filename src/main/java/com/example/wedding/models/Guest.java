package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo( scope = Guest.class,// l'id est unique sur cette classe "Item"
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "guest_id_seq")
    @SequenceGenerator(name = "guest_id_seq",allocationSize = 1)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String accommodation;

    @ManyToOne
    private BridalCouple bridal;
//JsonIgnore
    @ManyToOne
    private Role role;
   // @JsonIgnore
    @ManyToOne
    private RelationShip relationShip;
   // @JsonIgnore
    @ManyToOne
    private WeddingTable table;
   // @JsonIgnore
    @ManyToOne
    private Task task;

  //  @JsonIgnore
    @ManyToOne
    private Gift gift;

    public Guest() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public String getEmail() {
        return email;
    }



    public String getAccommodation() {
        return accommodation;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public void setBridal(BridalCouple bridal) {
        this.bridal = bridal;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRelationShip(RelationShip relationShip) {
        this.relationShip = relationShip;
    }

    public void setTable(WeddingTable table) {
        this.table = table;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
