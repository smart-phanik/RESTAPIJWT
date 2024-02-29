package com.tbp.crud.dao;

import com.tbp.crud.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// TaskRepository.java
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional custom queries if needed
}

