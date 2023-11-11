package com.example.todo.Todo.Models;

public enum TaskPriority{
    Weak("Weak"),
    Average("Average"),
    High("High");

    private final String label;

    TaskPriority(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}


