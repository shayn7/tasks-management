package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.entity.Comment;
import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.enums.Status;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {

    private Long taskId;
    private String title;
    private String description;
    private Status status;
    //private User assignee;
    private List<CommentResponse> comments;

}
