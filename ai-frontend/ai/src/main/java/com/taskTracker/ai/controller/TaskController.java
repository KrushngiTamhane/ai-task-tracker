package com.taskTracker.ai.controller;

import com.taskTracker.ai.entity.Task;
//import com.taskTracker.ai.exception.ResourceNotFoundException;
import com.taskTracker.ai.service.AiSuggestionService;
import com.taskTracker.ai.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final AiSuggestionService aiSuggestionService;

    public TaskController(TaskService taskService,
                          AiSuggestionService aiSuggestionService) {

        this.taskService = taskService;
        this.aiSuggestionService = aiSuggestionService;
    }

    // DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("tasks",
                taskService.getAllTasks());

        return "dashboard";
    }

    // CREATE PAGE
    @GetMapping("/create")
    public String createPage(Model model) {

        model.addAttribute("task", new Task());

        return "create-task";
    }

    // SAVE TASK
    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {

        taskService.saveTask(task);

        return "redirect:/dashboard";
    }

    // EDIT PAGE
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id,
                           Model model) {

        Task task = taskService.getTaskById(id);


        model.addAttribute("task", task);

        return "edit-task";
    }

    // DELETE TASK
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {

        Task task = taskService.getTaskById(id);

        taskService.deleteTask(id);

        return "redirect:/dashboard";
    }

    // AI DESCRIPTION
    @PostMapping("/generate-description")
    @ResponseBody
    public String generateDescription(
            @RequestParam String title) {

        return aiSuggestionService.generateSuggestion(title);
    }
}