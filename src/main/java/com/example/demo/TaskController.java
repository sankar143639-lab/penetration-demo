package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskProcessingService taskService;

    public TaskController(TaskProcessingService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/start")
    public String startTask() {
        String taskId = UUID.randomUUID().toString();
        taskService.executeBackgroundTask(taskId);
        return "Task initiated in background with ID: " + taskId;
    }

    @GetMapping("/status")
    public String status() {
        return "Task Service is healthy and active.";
    }
}
