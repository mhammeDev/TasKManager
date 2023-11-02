<template>
<div class="Tool" style="width: 500px; border: solid black 6px; display: flex; flex-direction: column; gap: 5px; align-items: center">
<img src="../assets/logoTP.png" alt="Logo TaskManager" width="400px" style="margin-top: -50px;">
  <div v-if="showAddTask">
    <AddTask />
  </div>
  <div v-else>
    <EditTask :taskId="editingTask" />
  </div>
<div class="filter">
</div>
</div>
</template>

<script>
import AddTask from "@/components/AddTask.vue";
import EditTask from "@/components/EditTask.vue";

export default {
  name: 'LeftPart',
  components: { AddTask,EditTask },
  data: () => ({
    editingTask: null,
    showAddTask: true,  }),
  methods: {
    editTask(taskId) {
      console.log("taskID : " + taskId)
      this.editingTask = taskId;
      this.showAddTask = false; // Cache AddTask
    },notEditingTask(){
      this.editingTask = null;
      this.showAddTask = true;
    }
  },created() {
       this.$root.$on('edit-task', (taskId) =>{
        this.editTask(taskId)
      });
       this.$root.$on('not-editing',() =>{
         this.notEditingTask();
    })

    },
};
</script>

<style>
</style>