    package com.example.todo.Todo.Models;
    import jakarta.persistence.Entity;
    import jakarta.persistence.EnumType;
    import jakarta.persistence.Enumerated;
    import jakarta.persistence.Id;
    import jakarta.persistence.criteria.CriteriaBuilder;

    import java.time.LocalDate;

    @Entity
    public class Task{
        @Id
        private Integer id;
        private String title;
        private String description;
        private LocalDate date;
        @Enumerated(EnumType.STRING)
        private TaskState taskState;
        @Enumerated(EnumType.STRING)
        private TaskPriority taskPriority;

        public Task(Integer id,String title, String description, LocalDate date,TaskState taskState, TaskPriority taskPriority){
            this.id = id;
            this.title = title;
            this.description = description;
            this.date = date;
            this.taskState = taskState;
            this.taskPriority = taskPriority;
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