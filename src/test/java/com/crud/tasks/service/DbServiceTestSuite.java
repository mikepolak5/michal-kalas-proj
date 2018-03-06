package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {
        //Given
        Task task1 = new Task(1L, "Task 1", "content");
        Task task2 = new Task(2L, "Task 2", "content2");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> result = dbService.getAllTasks();

        //Then
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void getTaskTest() {
        //Given
        Task task = new Task(1L, "Task", "content");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(task));

        //When
        Optional<Task> result = dbService.getTask(1L);

        //Then
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    public void saveTaskTest() {
        //Given
        Task task = new Task(1L, "Task", "content");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        String result = dbService.saveTask(task).getContent();

        //Then
        Assert.assertEquals("content", result);
    }

    @Test
    public void deleteTaskTest() {
        //Given
        Task task = new Task(1L, "Task", "content");

        //When
        dbService.deleteTask(1L);

        //Then
        verify(taskRepository, times(1)).deleteById(1L);
    }
}
