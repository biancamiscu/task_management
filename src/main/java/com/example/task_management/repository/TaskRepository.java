package com.example.task_management.repository;

import com.example.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Metoda pentru a gasi task-urile pe baza responsabilului si a datei de finalizare
    public List<Task> findByResponsibleAndDueDate(String responsible, LocalDate dueDate);

    //Metoda pentru a gasi task-urile asociate unui responsabil
    public List<Task> findByResponsible(String responsible);

    //Metoda pentru a gasi task-urile care au o anumita data de finalizare
    public List<Task> findByDueDate(LocalDate dueDate);
}
