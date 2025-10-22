package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(String description) {
        return taskRepository.save(new Task(null, description));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
