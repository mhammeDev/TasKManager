import axios from 'axios';

const TASK_API = 'http://localhost:8080/api/v1/todo';

async function getTasks() {
    try {
        const response = await axios.get(TASK_API);
        console.log(response.data)
        return response;
    } catch (error) {
        console.error('Error getting tasks:', error);
        throw error; // Vous pouvez gérer l'erreur ici ou laisser le composant Vue.js le gérer.
    }
}

async function removeTask(id) {
    try {
        await axios.delete(`${TASK_API}/${id}`);
    } catch (error) {
        console.error('Error deleting task:', error);
        throw error;
    }
}

async function addTask(taskData) {
    try {
        const response = await axios.post(TASK_API, taskData);
        return response.data.task;
    } catch (error) {
        console.error('Error adding task:', error);
        throw error;
    }
}

async function updateTask(id, taskData) {
    try {
        const response = await axios.put(`${TASK_API}/${id}`, taskData);
        return response.data;
    } catch (error) {
        console.error('Error updating task:', error);
        throw error;
    }
}

export default {
    getTasks,
    addTask,
    removeTask,
    updateTask
};
