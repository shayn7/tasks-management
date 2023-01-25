package com.naamad.tasksmanagement.service;

import com.naamad.tasksmanagement.dto.TaskRequest;
import com.naamad.tasksmanagement.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();
    Long addTask(TaskRequest taskRequest);
}
