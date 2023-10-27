package com.example.todo.Todo;

import java.util.*;

import com.example.todo.Todo.Models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoControllers {
    private TodoService todoService;

    @Autowired // this @ allow Todoservice to auto wired for us , so todoService will be magically instanced and injected in this constructor
    public TodoControllers(TodoService t){
        this.todoService = t;
    }

    @GetMapping
    public List<Task> toDo() {
        return todoService.toDo();
    }
}
