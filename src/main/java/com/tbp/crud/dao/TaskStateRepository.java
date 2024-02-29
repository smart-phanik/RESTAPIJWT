package com.tbp.crud.dao;

import com.tbp.crud.entity.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

// TaskStateRepository.java
public interface TaskStateRepository extends JpaRepository<TaskState, Long> {
    // Additional custom queries if needed
}

