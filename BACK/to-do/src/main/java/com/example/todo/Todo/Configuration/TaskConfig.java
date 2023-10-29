package com.example.todo.Todo.Configuration;

import com.example.todo.Todo.Models.Task;
import com.example.todo.Todo.Models.TaskPriority;
import com.example.todo.Todo.Models.TaskState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;


/**
 * This file is a configuration file's we can see with the @Configuration
 * @Bean Spring detect all @Bean method and call their to obtain the instance that correspond and manage it
 * CommandLineRunner it's an execute line where the program start
 * In our case this file create a task when the program start, to doesn't have an empty table when we start
 */
@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args -> {
            Task t1 = new Task(
                    "Homework",
                    "Exercize 1 of part 3",
                    LocalDate.now(),
                    TaskState.TO_DO,
                    TaskPriority.Weak
            );
            taskRepository.save(t1);
        };
    }
}
