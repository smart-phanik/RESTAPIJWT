package com.tbp.crud.service;

import com.tbp.crud.dao.TaskRepository;
import com.tbp.crud.dao.TaskStateRepository;
import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskStateRepository taskStateRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository,
                       TaskStateRepository taskStateRepository,
                       ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskStateRepository = taskStateRepository;
        this.modelMapper = modelMapper;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    return taskRepository.save(task);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
