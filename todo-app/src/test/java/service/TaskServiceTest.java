package service;

import com.example.todoapp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testCreateTask() {
        String description = "Test task";
        Task savedTask = new Task("1", description);
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        Task result = taskService.createTask(description);

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Test task", result.getDescription());
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "Task 1"),
                new Task("2", "Task 2")
        );
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getDescription());
    }
}