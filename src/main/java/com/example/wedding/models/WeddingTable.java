package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@Entity
@JsonIdentityInfo( scope = WeddingTable.class,// l'id est unique sur cette classe "WeddingTable"
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class WeddingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "table_id_seq")
    @SequenceGenerator(name = "table_id_seq",allocationSize = 1)
    private Long id;

    private String tableName;

    private String imageUrl;


    @OneToMany(mappedBy = "table")
    private List<Guest> guestList;

    public WeddingTable() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }


}
