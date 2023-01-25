package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {

    @NotBlank(message = "Title field can not be null or empty")
    private String title;
    @NotBlank(message = "Description field can not be null or empty")
    private String description;
    @NotNull
    private Status status;
    private User assignee;

}
