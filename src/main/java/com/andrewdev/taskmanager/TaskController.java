package com.andrewdev.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskRepository taskRepository;

    // GET /tasks - Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // GET /tasks/{id} - Get one task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable @NonNull Long id) {
        return taskRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    // POST /tasks - Create a new task
    @PostMapping
    public Task createTask(@RequestBody @NonNull Task task) {
        return taskRepository.save(task);
    }

    // PUT /tasks/{id} - Update a task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable @NonNull Long id, @RequestBody Task taskDetails) {
        return taskRepository.findById(id)
        .map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return ResponseEntity.ok(taskRepository.save(task));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /tasks/{id} - Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable @NonNull Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
