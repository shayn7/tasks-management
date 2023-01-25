package com.naamad.tasksmanagement.service;

import com.naamad.tasksmanagement.dto.UserRequest;
import com.naamad.tasksmanagement.dto.UserResponse;
import com.naamad.tasksmanagement.entity.User;

import java.util.Optional;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);
    Optional<User> findUserById(Long id);
}
