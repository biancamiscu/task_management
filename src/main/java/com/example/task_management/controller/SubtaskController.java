package com.example.task_management.controller;

import com.example.task_management.model.Subtask;
import com.example.task_management.service.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtasks")
public class SubtaskController {
    @Autowired
    private SubtaskService subtaskService;

    @PostMapping
    public Subtask createSubtask(@RequestBody Subtask subtask){
        return subtaskService.addSubtask(subtask);
    }
}
