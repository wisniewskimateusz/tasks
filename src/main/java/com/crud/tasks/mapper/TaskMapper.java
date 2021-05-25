package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
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

    public List<TaskDto> mapToTaskDtoList(final List<Task> taskList) {
        return taskList.stream()
                .map(t -> new TaskDto(t.getId(), t.getTitle(), t.getContent()))
                .collect(Collectors.toList());
    }

    public List<Task> mapToTaskList(final List<TaskDto> taskDtoList) {
        return taskDtoList.stream()
                .map(this::mapToTask)
                .collect(Collectors.toList());
    }
}