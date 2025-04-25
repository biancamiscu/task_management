package com.example.task_management.service;

import com.example.task_management.model.Subtask;
import com.example.task_management.repository.SubtaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtaskService {
    @Autowired
    private SubtaskRepository subtaskRepository;

    //Metoda pentru adaugarea unui subtask
    public Subtask addSubtask(Subtask subtask) {
        return subtaskRepository.save(subtask);
    }
}
