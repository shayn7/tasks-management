package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {

    private Long taskId;
    private String title;
    private String description;
    private Status status;
    private User assignee;
}
