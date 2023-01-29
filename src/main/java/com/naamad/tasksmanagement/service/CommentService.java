package com.naamad.tasksmanagement.service;

import com.naamad.tasksmanagement.dto.CommentRequest;

public interface CommentService {

    Long addComment(CommentRequest commentRequest);
}
