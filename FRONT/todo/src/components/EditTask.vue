<template>
  <div class="formulaire" style="border: solid #F4D03F 3px;margin-bottom: 10px;padding: 8%;border-radius: 10px" >
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text" id="basic-addon1">Title</span>
      </div>
      <input v-model="title" type="text" :placeholder=title class="form-control" aria-describedby="basic-addon1">
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text" id="basic-addon1">Description</span>
      </div>
      <input v-model="description" type="text" placeholder="Enter the description" class="form-control" aria-describedby="basic-addon1">
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text" id="basic-addon1">Date</span>
      </div>
      <input v-model="date" type="date"  min="2023-01-01" max="2025-12-31" class="form-control" aria-describedby="basic-addon1">
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <label class="input-group-text" for="inputGroupSelect01">Task State</label>
      </div>
      <select v-model="taskState" class="custom-select form-control"  id="inputGroupSelect01" >
        <option selected>Choose...</option>
        <option value="TO_DO">To do</option>
        <option value="IN_PROGRESS">In progress</option>
        <option value="ON_HOLD">On hold</option>
        <option value="COMPLETED">Completed</option>
      </select>
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <label class="input-group-text" for="inputGroupSelect01">Task Priority</label>
      </div>
      <select v-model="taskPriority" class="custom-select form-control"  id="inputGroupSelect01" >
        <option selected="selected">Choose...</option>
        <option value="Weak">Weak</option>
        <option value="Average">Average</option>
        <option value="High">High</option>
      </select>
    </div>
    <div class="button" style="display: flex;gap: 20%">
    <button  @click="$root.$emit('not-editing')" type="button" class="btn btn-danger">Cancel</button>
    <button  @click="this.updateTask" type="button" class="btn btn-warning">Update task</button>
    </div>

  </div>
</template>

<style>

</style>

<script>
import { mapActions, mapState } from 'vuex';

export default {
  name: 'EditTask',
  props: {
    taskId: Number,
  },
  data: () => ({
    title: '',
    description: '',
    date: '',
    taskState: '',
    taskPriority: '',
  }),
  computed: {
    ...mapState(['tasks']),
  },
  watch: {
    taskId: 'loadTaskData',
  },
  methods: {
    ...mapActions(['updateTasks', 'getTasks']),
    updateTask(){
      var data =   {
        "title": this.title,
        "description": this.description,
        "date": this.date,
        "taskState": this.taskState,
        "taskPriority": this.taskPriority
      }
      const task = this.tasks.find((t) => t.id === this.taskId);

      if(task.title === data.title){
        delete data.title;
      }

      if(task.description === data.description){
        delete data.description;
      }

      if(task.date === data.date){
        delete  data.date;
      }

      if(task.taskState === data.taskState){
        delete data.taskState;
      }

      if(task.taskPriority === data.taskPriority){
        delete data.taskPriority;
      }
      this.updateTasks({id:this.taskId,taskData:data});
      this.$root.$emit('not-editing');
    },
    loadTaskData() {
      if (this.taskId) {
        const task = this.tasks.find((t) => t.id === this.taskId);
        if (task) {
          this.title = task.title;
          this.description = task.description;
          this.date = task.date;
          this.taskState = task.taskState;
          this.taskPriority = task.taskPriority;
        }
      } else {
        // Réinitialiser les valeurs si taskId est nul
        this.title = '';
        this.description = '';
        this.date = '';
        this.taskState = '';
        this.taskPriority = '';
      }
    }
  },
  created() {
    this.loadTaskData(); // Appel initial pour charger les données
  },
};
</script>