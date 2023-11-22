package com.fazrina.simpleappone.controller;

import com.fazrina.simpleappone.entity.Task;
import com.fazrina.simpleappone.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    @PostMapping
    public Task createTask(@RequestBody Task request){
        return taskRepository.create(request);
    }

    @GetMapping
    public List<Task> getAll(){
        return taskRepository.getAll();
    }

    @GetMapping("/done")
    public List<Task> getAllDone(){
        return taskRepository.getAllDone();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskRepository.delete(id);
    }

    @PutMapping
    public void updateMenu(@RequestBody Task task) {
         taskRepository.update(task);
    }
}
