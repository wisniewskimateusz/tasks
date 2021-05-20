package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "new task", "test content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getId(), 1L);
        assertEquals(task.getTitle(), "new task");
        assertEquals(task.getContent(), "test content");
    }


    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "new task", "test content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), 1L);
        assertEquals(taskDto.getContent(), "test content");
        assertEquals(taskDto.getTitle(), "new task");
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "new task 1", "content 1");
        Task task2 = new Task(2L, "new task 2", "content 2");

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(List.of(task1, task2));

        //Then
        assertEquals(taskDtoList.size(), 2);

    }

    @Test
    void testMapToTaskList() {
        //Given
        TaskDto taskDto1 = new TaskDto(1L, "new task 1", "content 1");
        TaskDto taskDto2 = new TaskDto(2L, "new task 2", "content 2");

        //When
        List<Task> taskList = taskMapper.mapToTaskList(List.of(taskDto1, taskDto2));

        //Then
        assertEquals(taskList.size(), 2);
    }
}
