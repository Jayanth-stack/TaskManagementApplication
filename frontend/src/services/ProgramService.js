import api from './api';

const ProgramService = {
  getAllPrograms: async () => {
    try {
      const response = await api.get('/getAllProgram');
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getProgramsByAdmin: async (userId) => {
    try {
      const response = await api.get(`/getAllProgramByAdmin/${userId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  getProgramsByUser: async (userId) => {
    try {
      const response = await api.get(`/getAllProgramByUser/${userId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  createProgram: async (userId, programData) => {
    try {
      const response = await api.post(`/createProgram/${userId}`, programData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  enterProgram: async (userId, code) => {
    try {
      const response = await api.get('/enterPrg', {
        data: {
          uid: userId,
          code: code
        }
      });
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};

export default ProgramService; 