import api from './api';

const AuthService = {
  login: async (username, password) => {
    try {
      const response = await api.post('/auth/signin', {
        username,
        password
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  register: async (username, email, password, user) => {
    try {
      const response = await api.post('/auth/signup', {
        username,
        email,
        password,
        user // 'U' for User, 'A' for Admin
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getCurrentUser: () => {
    const userStr = localStorage.getItem('user');
    if (userStr) {
      return JSON.parse(userStr);
    }
    return null;
  },

  forgotPassword: async (email) => {
    try {
      const response = await api.post('/auth/forgot-password', { email });
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  resetPassword: async (token, newPassword) => {
    try {
      const response = await api.post('/auth/reset-password', {
        token,
        newPassword
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};

export default AuthService; 