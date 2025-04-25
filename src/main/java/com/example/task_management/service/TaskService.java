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

    //Metoda pentru adaugarea unui task
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    //Metoda pentru obtinerea tuturor task-urilor
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //Metoda pentru actualizarea unui task existent
    public Task updateTask(Long id, Task task){
        if(taskRepository.existsById(id)){
            task.setId(id);
            return taskRepository.save(task);
        }else{
            throw new RuntimeException("Task not found");
        }
    }

    //Metoda pentru stergerea unui task existent
    public void deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Task not found");
        }
    }

    //Metoda pentru obtinerea unui task dupa id
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    //Metoda pentru filtrarea unui task dupa resonsabil si data de finalizare
    public List<Task> getTasksByFilter(String responsible, String dueDate){
        if(responsible!= null && dueDate!=null){
            return taskRepository.findByResponsibleAndDueDate(responsible, LocalDate.parse(dueDate));
        }
        else if(responsible!=null){
            return taskRepository.findByResponsible(responsible);
        }
        else if(dueDate!=null){
            return taskRepository.findByDueDate(LocalDate.parse(dueDate));
        }
        else {
            return  taskRepository.findAll();
        }
    }
}
