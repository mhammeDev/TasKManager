package com.example.todo.Todo.Configuration;

import com.example.todo.Todo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//this interface allow us to access and implement some methode from JPA, example it will help us for the crud
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT t from Task t where t.title = ?1") //Verify if tittle already exist;
    Optional<Task> findTaskByTitle(String title);
    //In this case optionnal will allow us to see if a title already exists with the isPresent() and isEmpty() method;
}
