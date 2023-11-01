<template>
  <div class="task-group" >

    <div class="card mb-3 border-2 border-success">
      <div class="card-header bg-success">To do</div>
      <div v-if="tasks.length>0" class="card-text" style="min-height: 50px">
        <div class="card-text"  v-for="(t, index) in tasks" :key="index">
          <div v-if="t.taskState == 'TO_DO'">
            <TaskItem :task="t"/>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Loading ...</p>
      </div>
    </div>

    <div class="card mb-3 border-2 border-success">
      <div class="card-header bg-success">In Progress</div>
      <div v-if="tasks.length>0" class="card-text" style="min-height: 50px">
        <div class="card-text" v-for="(t, index) in tasks" :key="index">
          <div v-if="t.taskState == 'IN_PROGRESS'">
            <TaskItem :task="t"/>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Loading ...</p>
      </div>
    </div>

    <div class="card mb-3 border-2 border-success">
      <div class="card-header bg-success">On hold</div>
      <div v-if="tasks.length>0" class="card-text" style="min-height: 50px">
        <div class="card-text" v-for="(t, index) in tasks" :key="index">
          <div v-if="t.taskState == 'ON_HOLD'">
            <TaskItem :task="t"/>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Loading ...</p>
      </div>
    </div>

    <div class="card mb-3 border-2 border-success">
      <div class="card-header bg-success">Completed</div>
      <div v-if="tasks.length>0" class="card-text" style="min-height: 50px">
        <div class="card-text" v-for="(t, index) in tasks" :key="index">
          <div v-if="t.taskState == 'COMPLETED'">
            <TaskItem :task="t"/>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Loading ...</p>
      </div>
    </div>

  </div>
</template>

<script>
import {mapState, mapActions} from "vuex";
import TaskItem from "@/components/TaskItem.vue";

export default {
  name: "TaskGroup",
  computed: {
    ...mapState(['tasks']),
  },
  methods: {
    ...mapActions(['getTasks'])
  },
  props: {
    priority: String,
  },
  components: {
    TaskItem,
  },
  mounted() {
    this.getTasks() // Déclenche l'action pour récupérer les données et initialiser tasks
        .then(() => {
          console.log("Data loaded:", this.tasks);
        })
        .catch((error) => {
          console.error("Error loading data:", error);
        });
  }
};
</script>

<style scoped>

.task-group {
  display: flex;
  align-items: flex-start;
  gap: 1%;
}

.card {
  border: 2px solid #28a745;
}

.card-header {
  font-weight: bold;
  color: white;
}

.card-text {
  width: 240px;
  min-height: 0px;
}
</style>
