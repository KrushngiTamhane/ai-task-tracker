package com.taskTracker.ai.controller;

import com.taskTracker.ai.entity.Task;
//import com.taskTracker.ai.exception.ResourceNotFoundException;
import com.taskTracker.ai.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL TASKS
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        Task task = taskService.getTaskById(id);

        return ResponseEntity.ok(task);
    }

    // CREATE TASK
    @PostMapping
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody Task task) {

        Task savedTask = taskService.saveTask(task);

        return ResponseEntity.ok(savedTask);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task updatedTask) {

        Task existingTask = taskService.getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());

        Task savedTask = taskService.saveTask(existingTask);

        return ResponseEntity.ok(savedTask);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable Long id) {

        Task existingTask = taskService.getTaskById(id);


        taskService.deleteTask(id);

        return ResponseEntity.ok(
                "Task deleted successfully");
    }
}