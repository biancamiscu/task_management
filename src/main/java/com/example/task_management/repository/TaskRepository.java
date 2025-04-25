package com.example.task_management.repository;

import com.example.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByResponsibleAndDueDate(String responsible, LocalDate dueDate);
    public List<Task> findByResponsible(String responsible);
    public List<Task> findDueDate(LocalDate dueDate);
}
