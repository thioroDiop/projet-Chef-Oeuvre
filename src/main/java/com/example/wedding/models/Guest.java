package com.example.wedding.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity


//serialise un id au lieu d'un objet et remplace le Json Ignore

public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_id_seq")
    @SequenceGenerator(name = "guest_id_seq", allocationSize = 1)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String accommodation;
    private Double amountParticipation;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private BridalCouple bridal;

    //@JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Role role;

    //@JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private RelationShip relationShip;

    //pour arrêter la récursivité au niveau de la guestlist, n'affiche pas les invités dans la Table
    @JsonIgnoreProperties("guestList")

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private WeddingTable table;

    //  @JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private Task task;

    // @JsonIgnore
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

    public Double getAmountParticipation() {
        return amountParticipation;
    }

    public String getEmail() {
        return email;
    }

    public BridalCouple getBridal() {
        return bridal;
    }

    public Role getRole() {
        return role;
    }

    public RelationShip getRelationShip() {
        return relationShip;
    }

    public WeddingTable getTable() {
        return table;
    }

    public Task getTask() {
        return task;
    }

    public Gift getGift() {
        return gift;
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

    public void setAmountParticipation(Double amountParticipation) {
        this.amountParticipation = amountParticipation;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
