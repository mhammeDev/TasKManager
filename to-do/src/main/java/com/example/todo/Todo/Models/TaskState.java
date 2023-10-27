package com.example.todo.Todo.Models;

public enum TaskState {
    TODO("To do"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed"),
    POSTPONED("Post poned"),
    CANCELED("Canceled"),
    ON_HOLD("On hold"),
    DRAFT("Draft"),
    UNDER_REVIEW("Under review"),
    UNASSIGNED("Unassigned");

    private final String label;

    TaskState(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}