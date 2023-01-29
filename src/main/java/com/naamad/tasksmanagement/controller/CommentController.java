package com.naamad.tasksmanagement.controller;

import com.naamad.tasksmanagement.dto.CommentRequest;
import com.naamad.tasksmanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addComment(@Valid @RequestBody CommentRequest commentRequest){
        return commentService.addComment(commentRequest);
    }

}
