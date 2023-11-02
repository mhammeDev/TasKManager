import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import TaskServices from "@/services/TaskServices";

export default new Vuex.Store({
  state: {
    // tasks: [ { "title": "Homework", "description": "Exercize 1 of part 3", "date": "2023-10-31", "taskState": "TO_DO", "taskPriority": "Weak" }, { "title": "Cleaning room", "description": "My room", "date": "2023-10-31", "taskState": "TO_DO", "taskPriority": "Weak" }, { "title": "a room", "description": "My room", "date": "2023-10-31", "taskState": "TO_DO", "taskPriority": "Weak" }
    tasks : []
  },
  getters: {
  },
  mutations: {
    updateTask(state, task){
      console.log("ici")
     state.tasks = task;
    }
  },
  actions: {
    async getTasks({commit}){
      let response = await TaskServices.getTasks();
      if(response.status === 200){
        commit('updateTask', response.data);
      }else{
        console.log("12")
        console.log(response.data + "aaaa")
      }
    },
    async deleteTasks({commit},id){
      let response = await TaskServices.removeTask(id)
      if(response.status === 200){
        const updatedTasks = this.state.tasks.filter(task => task.id !== id);
        commit('updateTask', updatedTasks);
      }else console.log(response.data);
    },
    async addTask({ commit }, taskData) {
      try {
        const response = await TaskServices.addTask(taskData);
        if (response.status === 200) {
          // Make an API call to get the updated tasks data
          const updatedTasksResponse = await TaskServices.getTasks();
          if (updatedTasksResponse.status === 200) {
            commit('updateTask', updatedTasksResponse.data);
          } else {
            console.log(updatedTasksResponse.data);
          }
        } else {
          console.log(response.data);
        }
      } catch (error) {
        console.error('Error adding task:', error);
        throw error;
      }
    },
    async updateTasks({commit},{ id, taskData} ){
      try {
        const response = await TaskServices.updateTask(id,taskData);
        if (response.status === 200) {
          // Make an API call to get the updated tasks data
          const updatedTasksResponse = await TaskServices.getTasks();
          if (updatedTasksResponse.status === 200) {
            commit('updateTask', updatedTasksResponse.data);
          } else {
            console.log(updatedTasksResponse.data);
          }
        } else {
          console.log(response.data);
        }
      } catch (error) {
        console.error('Error updating task:', error);
        throw error;
      }
    }
  },
})
