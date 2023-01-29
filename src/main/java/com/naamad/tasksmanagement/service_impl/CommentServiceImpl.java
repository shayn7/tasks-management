package com.naamad.tasksmanagement.service_impl;

import com.naamad.tasksmanagement.dto.CommentRequest;
import com.naamad.tasksmanagement.entity.Comment;
import com.naamad.tasksmanagement.entity.Task;
import com.naamad.tasksmanagement.repository.CommentRepository;
import com.naamad.tasksmanagement.service.CommentService;
import com.naamad.tasksmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;

    @Override
    public Long addComment(CommentRequest commentRequest) {

        Optional<Task> task = taskService.findTaskById(commentRequest.getTask().getTaskId());
        if (task.isEmpty()) throw new RuntimeException("Task does not exist!");

        if (!Objects.equals(commentRequest.getUser().getUserId(), task.get().getAssignee().getUserId()))
            throw new RuntimeException("This task does not belongs to the user");

        LocalDateTime localDateTime = LocalDateTime.now();

        Comment comment = Comment
                .builder()
                .user(commentRequest.getUser())
                .task(task.get())
                .created(localDateTime)
                .comment(commentRequest.getComment())
                .build();

        return commentRepository.save(comment).getCommentId();
    }
}
