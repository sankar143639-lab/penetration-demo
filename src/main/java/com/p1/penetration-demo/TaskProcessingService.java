package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TaskProcessingService {

    @Async
    public CompletableFuture<String> executeBackgroundTask(String taskId) {
        try {
            // Simulate processing work
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Task " + taskId + " processing completed successfully.");
    }
}
