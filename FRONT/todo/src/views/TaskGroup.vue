<template>
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-4 col-sm-6 mb-4" v-for="(taskState, index) in taskStates" :key="index">
        <div class="card border-3" :class="getBorderClass(taskState)">
          <div class="card-header" :class="getHeaderClass(taskState)">{{ taskState }}</div>
          <div v-if="tasks.length > 0" class="card-text">
            <div v-for="(t, i) in tasks" :key="i">
              <div v-if="t.taskState === taskState">
                <TaskItem :task="t" />
              </div>
            </div>
          </div>
          <div v-else>
            <p>Loading ...</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import TaskItem from "@/components/TaskItem.vue";

export default {
  name: "TaskGroup",
  computed: {
    ...mapState(['tasks']),
    taskStates() {
      // Extract unique task states from tasks
      return ['TO_DO','IN_PROGRESS','ON_HOLD','COMPLETED']
    },
  },
  methods: {
    ...mapActions(['getTasks']),
    getBorderClass(priority) {
      // Define border classes based on priority
      const borderClasses = {
        TO_DO: 'border-secondary',
        IN_PROGRESS: 'border-warning',
        ON_HOLD: 'border-danger',
        COMPLETED: 'border-success',
      };
      return borderClasses[priority] || '';
    },
    getHeaderClass(priority) {
      // Define header classes based on priority
      const headerClasses = {
        TO_DO: 'bg-secondary text-light',
        IN_PROGRESS: 'bg-warning',
        ON_HOLD: 'bg-danger',
        COMPLETED: 'bg-success',
      };
      return headerClasses[priority] || '';
    },
  },
  components: {
    TaskItem,
  },
  mounted() {
    this.getTasks()
        .then(() => {
          console.log("Data loaded:", this.tasks);
        })
        .catch((error) => {
          console.error("Error loading data:", error);
        });
  },
};
</script>

<style scoped>
.container{
  margin-top: 10px;
}
.card {
  min-height: 100px;
}
</style>
