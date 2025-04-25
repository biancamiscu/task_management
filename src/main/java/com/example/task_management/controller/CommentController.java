package com.example.task_management.controller;

import com.example.task_management.model.Comment;
import com.example.task_management.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/tasks/{taskId}")
    public List<Comment> getCommentsForTask(@PathVariable Long taskId){
        return commentService.getCommentForTask(taskId);
    }
}
