package com.example.wedding.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
public class WeddingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_id_seq")
    @SequenceGenerator(name = "table_id_seq", allocationSize = 1)
    private Long id;

    private String tableName;

    private String imageUrl;
    @JsonIgnore
    @OneToMany(mappedBy = "tableMarie")
    private List<BridalCouple> coupleList;


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

    public List<Guest> getGuestList() {
        return guestList;
    }
}
