import api from './api';

const UserService = {
  getUserProfile: async (userId) => {
    try {
      const response = await api.get(`/users/${userId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  updateUserProfile: async (userId, userData) => {
    try {
      const response = await api.put(`/users/${userId}`, userData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  changePassword: async (userId, passwordData) => {
    try {
      const response = await api.post(`/users/${userId}/change-password`, passwordData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getUserSettings: async (userId) => {
    try {
      const response = await api.get(`/users/${userId}/settings`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  updateUserSettings: async (userId, settingsData) => {
    try {
      const response = await api.put(`/users/${userId}/settings`, settingsData);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};

export default UserService; 