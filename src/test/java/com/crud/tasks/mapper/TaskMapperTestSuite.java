package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "task", "content");

        //When
        String title = taskMapper.mapToTask(taskDto).getTitle();

        //Then
        Assert.assertEquals("task", title);
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "task", "content");

        //When
        String title = taskMapper.mapToTaskDto(task).getTitle();

        //Then
        Assert.assertEquals("task", title);
    }


    @Test
    public void mapToTaskDtoListTest() {
        //Given
        Task task = new Task(1L, "task", "content");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        //When
        String content = taskMapper.mapToTaskDtoList(tasks).get(0).getContent();

        //Then
        Assert.assertEquals("content", content);
    }
}
