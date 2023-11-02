import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TaskGroup from "@/views/TaskGroup.vue";
import LeftPart from "@/views/LeftPart.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/todoGroup',
    name: 'todoGroup',
    component: TaskGroup

  },
  {
    path: '/leftpart',
    name:'leftpart',
    component: LeftPart
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
