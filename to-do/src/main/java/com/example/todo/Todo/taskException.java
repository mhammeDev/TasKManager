package com.example.todo.Todo;

import com.example.todo.Todo.Models.Task;

public class taskException extends Exception{
    Task t;

    int typeError;

    public taskException(Task t, int typeError){
        super("");
        this.typeError = typeError
        this.t = t;
    }

    public String getMessage(){
        String msg = "";
        if(typeError==0){
            msg = "Impossible de créer la tâche le texte existe déjà"
        }
        return msg;
    }
}
