package com.naamad.tasksmanagement.controller;

import com.naamad.tasksmanagement.dto.UserRequest;
import com.naamad.tasksmanagement.dto.UserResponse;
import com.naamad.tasksmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@Valid @RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

}
