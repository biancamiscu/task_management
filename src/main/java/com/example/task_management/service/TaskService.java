package com.example.task_management.service;

import com.example.task_management.model.Task;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task task){
        if(taskRepository.existsById(id)){
            task.setId(id);
            return taskRepository.save(task);
        }else{
            throw new RuntimeException("Task not found");
        }
    }

    public void deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Task not found");
        }
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    public List<Task> getTasksByFilter(String responsible, String dueDate){
        if(responsible!= null && dueDate!=null){
            return taskRepository.findByResponsibleAndDueDate(responsible, LocalDate.parse(dueDate));
        }
        else if(responsible!=null){
            return taskRepository.findByResponsible(responsible);
        }
        else if(dueDate!=null){
            return taskRepository.findDueDate(LocalDate.parse(dueDate));
        }
        else {
            return  taskRepository.findAll();
        }
    }
}
