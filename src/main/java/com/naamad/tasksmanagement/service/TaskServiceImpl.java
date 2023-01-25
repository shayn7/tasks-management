package com.naamad.tasksmanagement.service;

import com.naamad.tasksmanagement.dto.TaskRequest;
import com.naamad.tasksmanagement.dto.TaskResponse;
import com.naamad.tasksmanagement.entity.Task;
import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::mapToTaskResponse).collect(Collectors.toList());
    }

    @Override
    public Long addTask(TaskRequest taskRequest) {
        Optional<User> user = userService.findUserById(taskRequest.getAssignee().getUserId());
        if(user.isEmpty()) throw new RuntimeException("User does not exist!");

        Task task = Task
                .builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .status(taskRequest.getStatus())
                .assignee(user.get())
                .build();

        return taskRepository.save(task).getTaskId();
    }


    private TaskResponse mapToTaskResponse(Task task) {
        return TaskResponse
                .builder()
                .taskId(task.getTaskId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .assignee(task.getAssignee())
                .build();
    }
}
