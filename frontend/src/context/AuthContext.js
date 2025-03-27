import React, { createContext, useState, useEffect, useContext } from 'react';
import AuthService from '../services/AuthService';

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [currentUser, setCurrentUser] = useState(null);
  const [token, setToken] = useState(localStorage.getItem('token'));
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    // Check if user is already logged in
    const checkLoggedIn = async () => {
      if (token) {
        try {
          const userData = AuthService.getCurrentUser();
          setCurrentUser(userData);
        } catch (err) {
          // Token might be invalid or expired
          localStorage.removeItem('token');
          setToken(null);
          setError('Session expired. Please login again.');
        }
      }
      setLoading(false);
    };

    checkLoggedIn();
  }, [token]);

  const login = async (username, password) => {
    try {
      setLoading(true);
      const response = await AuthService.login(username, password);
      localStorage.setItem('token', response.accessToken);
      localStorage.setItem('user', JSON.stringify({
        id: response.id,
        username: response.username,
        authorities: response.authorities
      }));
      setToken(response.accessToken);
      setCurrentUser({
        id: response.id,
        username: response.username,
        authorities: response.authorities
      });
      setError('');
      return true;
    } catch (err) {
      setError('Invalid username or password');
      return false;
    } finally {
      setLoading(false);
    }
  };

  const register = async (username, email, password, userType) => {
    try {
      setLoading(true);
      await AuthService.register(username, email, password, userType);
      setError('');
      return true;
    } catch (err) {
      setError('Registration failed. Please try again.');
      return false;
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    setToken(null);
    setCurrentUser(null);
  };

  const value = {
    currentUser,
    loading,
    error,
    login,
    register,
    logout,
    isAuthenticated: !!token,
    token
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}; 