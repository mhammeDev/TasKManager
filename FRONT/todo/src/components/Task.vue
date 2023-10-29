<template>
   <template>
    <div class="task">
      <div class="card mb-3 border-" :class="getPriorityClass(task.taskPriority)">
        <div class="card-header">{{ task.title }}</div>
        <div class="card-body text-" :class="getPriorityClass(task.taskPriority)">
          <h5 class="card-title">Task Description</h5>
          <p class="card-text">{{ task.description }}</p>
          <p>Due Date: {{ task.date }}</p>
          <p>Task State: {{ task.taskState }}</p>
          <p>Task Priority: {{ task.taskPriority }}</p>
          <button class="btn btn-danger" @click="deleteTask(task.id)">Delete Task</button>
          <button class="btn btn-warning" @click="">Update task</button>
        </div>
      </div>
    </div>
  </template>
</template>

<script>
import {mapState,mapActions} from 'vuex'
export default {
  name:"Task",
  props: {
    task : Object
  },
  data: ()=>{

  },
  computed : {
    ...mapState(['tasks'])
  },
  methods: {
    ...mapActions(['deleteTasks']),
    getPriorityClass(priority) {
      switch (priority) {
        case 'Weak':
          return 'success';
        case 'Average':
          return 'warning';
        case 'High':
          return 'danger';
        default:
          return '';
      }
    },
  }

}

</script>

<style>

</style>