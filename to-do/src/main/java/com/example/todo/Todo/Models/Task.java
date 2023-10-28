    package com.example.todo.Todo.Models;
    import jakarta.persistence.*;
    import jakarta.persistence.criteria.CriteriaBuilder;

    import java.time.LocalDate;

    @Entity
    @Table
    public class Task{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(
                name = "id",
                updatable = false
        )
        protected int id;

        @Column(
                name="title",
                nullable = false,
                unique = true
        )
        private String title;

        @Column(
                name = "description",
                nullable = false,
                columnDefinition = "TEXT"

        )
        private String description;

        @Column(
                name = "date",
                nullable = false
        )
        private LocalDate date;

        @Column(
                name = "task_skate",
                nullable = false
        )
        @Enumerated(EnumType.STRING)
        private TaskState taskState;

        @Column(
                name = "task_priority",
                nullable = false
        )
        @Enumerated(EnumType.STRING)
        private TaskPriority taskPriority;

        public Task(String title, String description, LocalDate date,TaskState taskState, TaskPriority taskPriority){
            this.title = title;
            this.description = description;
            this.date = date;
            this.taskState = taskState;
            this.taskPriority = taskPriority;
        }

        public Task() {

        }

        public String getTitle(){
            return this.title;
        }

        public String getDescription(){
            return this.description;
        }

        public LocalDate getDate(){
            return this.date;
        }

        public TaskState getTaskState(){
            return this.taskState;
        }

        public TaskPriority getTaskPriority() {
            return this.taskPriority;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setTaskPriority(TaskPriority taskPriority) {
            this.taskPriority = taskPriority;
        }

        public void setTaskState(TaskState taskState) {
            this.taskState = taskState;
        }
    }