import axios from 'axios';

// Create an Axios instance with default configs
const api = axios.create({
  baseURL: 'http://localhost:8080', // Backend API URL
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  },
  // Enable CORS 
  withCredentials: false
});

// Add a request interceptor to add auth token to all requests
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Add a response interceptor to handle token expiration
api.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    // Handle unauthorized responses (token expired)
    if (error.response && error.response.status === 401) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      // Redirect to login page or refresh the token
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

export default api; 