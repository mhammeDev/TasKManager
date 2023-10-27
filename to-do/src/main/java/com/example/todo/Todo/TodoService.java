package com.example.todo.Todo;

import com.example.todo.Todo.Models.Task;
import com.example.todo.Todo.Models.TaskPriority;
import com.example.todo.Todo.Models.TaskState;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //To precize that this class is a bin --> autowired and because this is a for a service class
public class TodoService {

    public List<Task> toDo() {
        return List.of(
                new Task(
                        1,
                        "Homework",
                        "Exercize 1 of part 3",
                        LocalDate.now(),
                        TaskState.TODO,
                        TaskPriority.Weak
                )
        );
    }
}

