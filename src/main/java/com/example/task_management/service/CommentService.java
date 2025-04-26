package com.example.task_management.service;

import com.example.task_management.model.Comment;
import com.example.task_management.model.Task;
import com.example.task_management.repository.CommentRepository;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TaskRepository taskRepository;

    //Metoda pentru adaugarea unui comentariu la un task
    public Comment addComment(Comment comment) {

        Long taskId = comment.getTask().getId();
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task != null) {
            comment.setTask(task);
            return commentRepository.save(comment);
        } else {
            return null;
        }
    }


    //Metoda pentru afisarea tuturor comentariilor pentru un task
    public List<Comment> getCommentForTask(Long taskId){
        return commentRepository.findByTaskId(taskId);
    }

}
