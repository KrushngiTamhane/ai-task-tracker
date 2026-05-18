package com.taskTracker.ai.repository;

import com.taskTracker.ai.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}