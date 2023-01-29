package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.entity.Task;
import com.naamad.tasksmanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {

    private User user;
    private Task task;
    @Size(min = 1, max = 250)
    private String comment;
}
