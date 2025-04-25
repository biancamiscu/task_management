package com.example.task_management.service;

import com.example.task_management.model.Comment;
import com.example.task_management.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //Metoda pentru adaugarea unui comentariu la un task
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    //Metoda pentru afisarea tuturor comentariilor pentru un task
    public List<Comment> getCommentForTask(Long taskId){
        return commentRepository.findByTaskId(taskId);
    }

}
