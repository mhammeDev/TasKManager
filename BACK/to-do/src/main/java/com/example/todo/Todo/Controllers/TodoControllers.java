package com.example.todo.Todo.Controllers;

import java.time.LocalDate;
import java.util.*;

import com.example.todo.Todo.Models.Task;
import com.example.todo.Todo.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoControllers {
    private TodoService todoService;

    @Autowired // this @ allow Todoservice to auto wired for us , so todoService will be magically instanced and injected in this constructor
    public TodoControllers(TodoService t){
        this.todoService = t;
    }

    @GetMapping
    public List<Task> getTask() {
        return todoService.getTask();
    }

    //method post
    //@RequestBody precize that Spring have to convert the receive data (like JSON)
    @PostMapping
    public void addTask(@RequestBody Task task){
        todoService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void removeTask(@PathVariable("taskId") int taskId){
        todoService.removeTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") int taskId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String taskState,
            @RequestParam(required = false) String taskPriority
            ){
        todoService.updateTask(taskId,title,description,date,taskState,taskPriority);
    }
}
