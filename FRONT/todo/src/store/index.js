import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import TaskServices from "@/services/TaskServices";

export default new Vuex.Store({
  state: {
    tasks: []
  },
  getters: {
  },
  mutations: {
    updateTask(state, task){
      state.tasks = task;
    }
  },
  actions: {
    async getTasks({commit}){
      let response = await TaskServices.getTasks();
      if(response.error === 0){
        commit('updateTask', response.data);
      }else{
        console.log(response.data)
      }
    },
    async deleteTasks({commit},id){
      let response = await TaskServices.removeTask(id)
      if(response.error === 0){
        commit('updateTask', response.data);
      }else console.log(response.data);
    },
    async addTask({commit},taskData){
      let response= await TaskServices.addTask(taskData);
      if(response.error === 0){
        commit('updateTask',response.data);
      }else console.log(response.data);
    },
    async updateTask({commit},id,taskData){
      let response = await TaskServices.updateTask(id,taskData);
      if(response.error === 0){
        commit('updateTask',response.data);
      }else console.log(response.data);
    }
  },
})