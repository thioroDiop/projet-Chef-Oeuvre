package com.example.wedding.controllers;

import com.example.wedding.models.Task;
import com.example.wedding.repositories.TableRepository;
import com.example.wedding.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4100")
@RestController
@RequestMapping("api/taches")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTask(){
       return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable Long id){
        return taskRepository.findById(id);
    }
}
