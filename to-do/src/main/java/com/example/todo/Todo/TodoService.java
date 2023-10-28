package com.example.todo.Todo;

import com.example.todo.Todo.Models.Task;
import com.example.todo.Todo.Models.TaskPriority;
import com.example.todo.Todo.Models.TaskState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //To precize that this class is a bin --> autowired and because this is a for a service class
public class TodoService {

    private TaskRepository taskRepository;

    @Autowired //inject automaticaly depence in Spring's class, and spring take care to automaticcaly implement methode, like findAll() in jpaRepository, where sprind detect that it's a method from jpa repository he implement it
    public TodoService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;

    }

    //Diplay all of task
    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public void addTask(Task t){
        taskRepository.save(t);
    }

    public void addTask(String title, String description, LocalDate date,TaskState taskState, TaskPriority taskPriority){
        taskRepository.save(new Task(title,description,date,taskState,taskPriority));

    }

    public void removeTask(int id){
        taskRepository.deleteById(id);
    }

    public void removeTask(Task t){
        taskRepository.delete(t);
    }

    public void updateTask(){

    }


}

