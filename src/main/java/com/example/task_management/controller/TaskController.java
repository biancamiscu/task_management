package com.example.task_management.controller;

import com.example.task_management.model.Task;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //Endpoint pentru crearea unui task nou
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    //Endpoint pentru obtinerea listei de task-uri
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    //Endpoint pentru actualizarea unui task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    //Endpoint pentru stergerea unui task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    //Endpoint pentru obtinerea unui task specific dupa id
    @GetMapping
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    //Endpoint pentru filtrarea task-urilor in functie de responsabil si data
    @GetMapping
    public List<Task> getTasksByFilter(@RequestParam(required = false)String responsible,
                                       @RequestParam(required = false) String dueDate){
        return taskService.getTasksByFilter(responsible,dueDate);
    }
}
