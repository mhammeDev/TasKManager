<template>
  <div class="task" style="margin: 3%;">
    <div :class="concat('card mb-3 border-2 bg-',getPriorityClass(task.taskPriority))">
      <div :class="concat('card-header bg-light border-',getPriorityClass(task.taskPriority))" style="font-weight: bold;color: black">{{ task.title }}</div>
      <div class="card-body text-" :class="getPriorityClass(task.taskPriority)">
        <h5 class="card-title" style="color: white">Task Description</h5>
        <div class="card-text" style="color: white">
        <p>{{ task.description }}</p>
        <p>Due Date: {{ task.date }}</p>
        <p>Task State: {{ task.taskState }}</p>
        <p>Task Priority: {{ task.taskPriority }}</p>
                  <button class="btn btn-light btn-outline-danger" @click="deleteTasks(task.id)">Delete Task</button>
                  <button class="btn btn-light btn-outline-warning" @onclick="deleteTask(task.id)" style="margin: 1%">Update task</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapState, mapActions} from 'vuex'

export default {
  name: 'TaskItem',
  props: {
    task: Object
  },
  computed: {
    ...mapState(['tasks'])
  },
  methods: {
    ...mapActions(['deleteTasks']),
    getPriorityClass(priority) {
      switch (priority) {
        case "Weak":
          return 'success';
        case 'Average':
          return 'warning';
        case 'High':
          return 'danger';
        default:
          return '';
      }
    },concat(text1,text2){
      return text1.concat(text2);
    }
  }

}

</script>

<style>

</style>