package com.example.wedding.controllers;

import com.example.wedding.models.WeddingTable;
import com.example.wedding.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/tables")
public class TableController {
    @Autowired
    private TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping()
    public List<WeddingTable> getAllTable() {
        return tableRepository.findAllByOrderByTableNameAsc();
    }

    @GetMapping("/{id}")
    public Optional<WeddingTable> getById(@PathVariable Long id) {
        return tableRepository.findById(id);
    }


    @GetMapping("/listeTableNonRempli")
    public List<WeddingTable> findTableNotFull() {
        return tableRepository.findATableNotFull();
    }
}
