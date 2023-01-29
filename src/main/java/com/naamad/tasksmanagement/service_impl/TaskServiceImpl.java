package com.naamad.tasksmanagement.service_impl;

import com.naamad.tasksmanagement.dto.CommentResponse;
import com.naamad.tasksmanagement.dto.TaskRequest;
import com.naamad.tasksmanagement.dto.TaskResponse;
import com.naamad.tasksmanagement.entity.Comment;
import com.naamad.tasksmanagement.entity.Task;
import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.enums.Status;
import com.naamad.tasksmanagement.repository.TaskRepository;
import com.naamad.tasksmanagement.service.TaskService;
import com.naamad.tasksmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::mapToTaskResponse).collect(Collectors.toList());
    }

    @Override
    public Long addTask(TaskRequest taskRequest) {
        User user = getUser(taskRequest);
        Task task = Task
                .builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDescription())
                .status(taskRequest.getStatus())
                .assignee(user)
                .build();

        return taskRepository.save(task).getTaskId();
    }

    @Override
    public Long updateTask(Long id, TaskRequest taskRequest) {
        Optional<Task> task = findTaskById(id);
        if (task.isEmpty()) throw new RuntimeException("Task not found!");
        User user = getUser(taskRequest);
        task.get().setTitle(taskRequest.getTitle());
        task.get().setDescription(taskRequest.getDescription());
        task.get().setStatus(taskRequest.getStatus());
        task.get().setAssignee(user);

        return taskRepository.save(task.get()).getTaskId();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteTask(Long id) {
        findTaskById(id).ifPresentOrElse(taskRepository::delete, () -> { throw new RuntimeException("Task does not exist!"); });
    }

    @Override
    public void markTaskAsCompleted(Long id) {
        Optional<Task> task = findTaskById(id);
        if (task.isEmpty()) throw new RuntimeException("Task not found!");
        task.get().setStatus(Status.COMPLETED);
        taskRepository.save(task.get());
    }


    private User getUser(TaskRequest taskRequest) {
        Optional<User> user = userService.findUserById(taskRequest.getAssignee().getUserId());
        if(user.isEmpty()) throw new RuntimeException("User does not exist!");
        return user.get();
    }

    private TaskResponse mapToTaskResponse(Task task) {

        return TaskResponse
                .builder()
                .taskId(task.getTaskId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .comments(task.getComments().stream().map(this::mapToCommentsResponse).collect(Collectors.toList()))
               // .assignee(task.getAssignee())
                .build();
    }

    private CommentResponse mapToCommentsResponse(Comment comment) {

       return CommentResponse
                .builder()
                .comment(comment.getComment())
                .created(comment.getCreated())
                .build();
    }
}
