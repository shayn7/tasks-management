package com.naamad.tasksmanagement.controller;

import com.naamad.tasksmanagement.dto.TaskRequest;
import com.naamad.tasksmanagement.dto.TaskResponse;
import com.naamad.tasksmanagement.entity.Task;
import com.naamad.tasksmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/task")
@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addTask(@Valid @RequestBody TaskRequest taskRequest){
        return taskService.addTask(taskRequest);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }}
