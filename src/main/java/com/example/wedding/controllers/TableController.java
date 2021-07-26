package com.example.wedding.controllers;

import com.example.wedding.models.WeddingTable;
import com.example.wedding.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4100")
@RestController
@RequestMapping("api/tables")
public class TableController {
@Autowired
private TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping()
    public List<WeddingTable> getAllTable(){
       return tableRepository.findAllByOrderByTableNameAsc();
    }



}
