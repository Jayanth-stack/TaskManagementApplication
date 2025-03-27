import api from './api';

const TaskService = {
  getAllTasks: async (programId) => {
    try {
      const response = await api.get(`/tasks/program/${programId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getTaskById: async (taskId) => {
    try {
      const response = await api.get(`/tasks/${taskId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  createTask: async (taskData) => {
    try {
      const response = await api.post('/tasks/create', taskData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  updateTask: async (taskId, taskData) => {
    try {
      const response = await api.put(`/tasks/${taskId}`, taskData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  updateTaskStatus: async (taskId, status) => {
    try {
      const response = await api.patch(`/tasks/${taskId}/status`, { status });
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  deleteTask: async (taskId) => {
    try {
      const response = await api.delete(`/tasks/${taskId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  // Additional task-related methods as needed
  getTasksByAssignee: async (userId) => {
    try {
      const response = await api.get(`/tasks/assignee/${userId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getTasksByStatus: async (programId, status) => {
    try {
      const response = await api.get(`/tasks/program/${programId}/status/${status}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};

export default TaskService; 