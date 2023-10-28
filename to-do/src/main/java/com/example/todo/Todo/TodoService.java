package com.example.todo.Todo;

import com.example.todo.Todo.Models.Task;
import com.example.todo.Todo.Models.TaskPriority;
import com.example.todo.Todo.Models.TaskState;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Task> optionalTask = taskRepository.findTaskByTitle(t.getTitle());
        if(optionalTask.isPresent()) throw new IllegalStateException("Impossible de créer la tâche le texte existe déjà");
        taskRepository.save(t);
    }

/**    public void addTask(String title, String description, LocalDate date,TaskState taskState, TaskPriority taskPriority){
        taskRepository.save(new Task(title,description,date,taskState,taskPriority));

    }**/

    public void removeTask(int id){
        if(!taskRepository.existsById(id)){
            throw new IllegalStateException("Task with id: "+id+" doesn't exist and can't be remove");
        }
        taskRepository.deleteById(id);
    }

    /**public void removeTask(Task t){
        taskRepository.delete(t);
    } **/

    @Transactional //Spring will manage the transaction (the update in this case)
    public void updateTask(int id,String title, String description, LocalDate date, String taskState, String taskPriority){
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalStateException("Task with id: "+id+" doesn't exist and can't be remove"));

        if(title != null
        && title.length() > 0
        && !Objects.equals(task.getTitle(),title)){
            if(taskRepository.findTaskByTitle(title).isPresent()){
                throw new IllegalStateException("Impossible de créer la tâche le texte existe déjà");
            }
            task.setTitle(title);
        }

        if(description != null
                && description.length() > 0
                && !Objects.equals(task.getDescription(),description)){
            task.setDescription(description);
        }

        if(date != null
                && date.isAfter(LocalDate.now())
                && !Objects.equals(task.getDate(),date)){
            task.setDate(date);
        }

        if(taskState != null
         && !Objects.equals(taskState,task.getTaskState().getLabel())){
            task.setTaskState(TaskState.valueOf(taskState.replace(" ","_").toUpperCase()));//To do -> TO_DO
        }

        if(taskPriority != null
        && !Objects.equals(taskPriority,task.getTaskPriority().getLabel())){
            task.setTaskPriority(TaskPriority.valueOf(taskPriority));
        }

    }


}

