package model;

import com.example.todoapp.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Task task = new Task("123", "Write unit test");

        assertEquals("123", task.getId());
        assertEquals("Write unit test", task.getDescription());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        Task task = new Task();
        task.setId("456");
        task.setDescription("Refactor code");

        assertEquals("456", task.getId());
        assertEquals("Refactor code", task.getDescription());
    }

    @Test
    void testEqualsAndHashCode() {
        Task task1 = new Task("1", "Test");
        Task task2 = new Task("1", "Test");

        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void testToString() {
        Task task = new Task("1", "Document code");
        String output = task.toString();

        assertTrue(output.contains("1"));
        assertTrue(output.contains("Document code"));
    }
}