<template>
  <div class="Tool" style="width: 500px;border: solid black 6px;display: flex;flex-direction: column;gap: 5px;align-items: center" >
    <img src="@/assets/logoTP.png" alt="Logo TaskManager" width="400px" style="margin-top: -50px;">
    <div class="formulaire" style="border: solid black 6px;margin-bottom: 10px;padding: 8%" >

      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text" id="basic-addon1">Title</span>
        </div>
        <input v-model="title" type="text" placeholder="Enter the title" class="form-control" aria-describedby="basic-addon1">
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
        <select v-model="taskState" class="custom-select"  id="inputGroupSelect01" >
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
        <select v-model="taskPriority" class="custom-select"  id="inputGroupSelect01" >
          <option selected="selected">Choose...</option>
          <option value="Weak">Weak</option>
          <option value="Average">Average</option>
          <option value="High">High</option>
        </select>
      </div>

      <button  @click="sendTask" type="button" class="btn btn-success">Add a task</button>


    </div>
  </div>

</template>

<script>
import {mapActions} from 'vuex';
export default {
  name:'LeftPart',
  data: () =>({
    title:"",
    description:"",
    date:"",
    taskState:"",
    taskPriority:""
}),
  computed:{

  },
  methods:{
    ...mapActions(['addTask']),
    sendTask(){
      if(this.title !="" && this.description!="" && this.date!="" && this.taskState!="" && this.taskPriority!=""){
        var data =   {
          "title": this.title,
          "description": this.description,
          "date": this.date,
          "taskState": this.taskState,
          "taskPriority": this.taskPriority
        }
        this.addTask(data);
      }else{
        window.alert("Please fill all filed");
      }
    }
  }
}

</script>

<style>

</style>