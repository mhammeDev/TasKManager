<template>
  <div class="task-group">
    <h2>Taches</h2>
    <p>dsqdqsd {{tasks}}</p>
    <div v-for="(task, index) in tasks" :key="index">
      <TaskItem :task="task" />
    </div>
  </div>
</template>

<script>
import {mapState,mapActions} from "vuex";
import TaskItem from "@/components/TaskItem.vue";


export default {
  name : "TaskGroup",
  computed : {
    ...mapState(['tasks'])
  },
  methods:{
    ...mapActions(['getTasks'])
  },
  props: {
    priority: String,
  },
  components: {
    TaskItem,
  },
  mounted() {
    this.getTasks()
  }
};
</script>

<style scoped>
.task-group {
  margin-top: 20px;
  padding: 10px;
  border: 1px solid #ccc;
}
</style>