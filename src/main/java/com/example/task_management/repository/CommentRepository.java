package com.example.task_management.repository;

import com.example.task_management.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    //Metoda pentru a gasi comentarii asociate unui task, dupa id-ul task-ului
    public List<Comment> findByTaskId(Long taskId);
}
