package com.naamad.tasksmanagement.service;

import com.naamad.tasksmanagement.dto.TaskRequest;
import com.naamad.tasksmanagement.dto.TaskResponse;
import com.naamad.tasksmanagement.entity.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskResponse> getAllTasks();
    Long addTask(TaskRequest taskRequest);

    Long updateTask(Long id, TaskRequest taskRequest);

    Optional<Task> findTaskById(Long id);

    void deleteTask(Long id);

    void markTaskAsCompleted(Long id);
}
