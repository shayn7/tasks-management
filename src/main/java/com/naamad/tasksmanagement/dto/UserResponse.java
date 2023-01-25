package com.naamad.tasksmanagement.dto;

import com.naamad.tasksmanagement.enums.Active;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private Active active;
}
