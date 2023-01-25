package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.enums.Active;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = "Name field can not be null or empty")
    private String name;
    @Email
    private String email;
    @NotNull
    private Active active;
    @NotBlank(message = "Password field can not be null or empty")
    private String password;
}
