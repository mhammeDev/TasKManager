    package com.todo.list.Model;
    import java.time.LocalDate;

    public class Task{
        private String title;
        private String description;
        private LocalDate date;
        private TaskState taskState;
        private TaskPriority taskPriority;

        public Task(){
            this.title = "";
            this.description = "";
            this.date = null;
            this.taskState = TaskState.TODO;
            this.taskPriority = TaskPriority.Average;
        }

        public Task(String title, String description, LocalDate date, TaskState taskState, TaskPriority taskPriority){
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