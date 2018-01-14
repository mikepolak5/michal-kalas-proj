package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
<<<<<<< HEAD
import org.springframework.stereotype.Component;
=======
>>>>>>> b3582f926a26477e13d9f44ca57ea3bde264e8ff

import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
@Component
=======
>>>>>>> b3582f926a26477e13d9f44ca57ea3bde264e8ff
public class TaskMapper {
    public Task mapToTask(final TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getContent());
    }

    public TaskDto mapToTaskDto(final Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getContent());
    }

    public List<TaskDto> mapToTaskDtoList (final List<Task> tasksList) {
        return tasksList.stream()
                .map(task -> new TaskDto(task.getId(), task.getTitle(), task.getContent()))
                .collect(Collectors.toList());
    }
}
