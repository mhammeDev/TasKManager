<template>
  <div class="task" style="margin: 4%">
    <div class="card mb-3  border-2" :style="getPriorityClass(task.taskPriority)">
      <div class="card-header" :style="getPriorityClass(task.taskPriority)" >{{ task.title }}</div>
      <div class="card-body" style="background-color: white;">
        <h5 class="card-title">Task Description</h5>
        <div class="card-text">
        <p>{{ task.description }}</p>
        <p>Due Date: {{ task.date }}</p>
        <p>Task State: {{ task.taskState }}</p>
        <p>Task Priority: {{ task.taskPriority }}</p>
                  <button class="btn btn-danger" @click="deleteTasks(task.id)" style="margin: 1%">Delete Task</button>
          <button class="btn btn-warning" @click="editTask(task.id)">Edit task</button>
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
    editTask(taskID) {
      this.$root.$emit('edit-task', taskID);
    },
    getPriorityClass(priority) {
      switch (priority) {
        case "Weak":
          return 'background-color: #F4D03F;';
        case 'Average':
          return 'background-color: orange';
        case 'High':
          return 'background-color: #F08080 ;';
        default:
          return '';
      }
    }
  }

}

</script>

<style>
.card-header{
  font-weight: bold;
  color: white;
}

.card-body{

}

</style>