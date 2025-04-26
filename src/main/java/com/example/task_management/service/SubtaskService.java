package com.example.task_management.service;

import com.example.task_management.model.Subtask;
import com.example.task_management.model.Task;
import com.example.task_management.repository.SubtaskRepository;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtaskService {
    @Autowired
    private SubtaskRepository subtaskRepository;
    @Autowired
    private TaskRepository taskRepository;

    //Metoda pentru adaugarea unui subtask
    public Subtask addSubtask(Subtask subtask) {

        Long taskId = subtask.getTask().getId();
        Task task=taskRepository.findById(taskId).orElse(null);

        if(task!=null){
            subtask.setTask(task);
            return subtaskRepository.save(subtask);
        }else {
            return null;
        }
    }
}
