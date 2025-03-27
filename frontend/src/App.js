import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';

// Pages
import LandingPage from './pages/LandingPage';
import LoginPage from './pages/auth/LoginPage';
import RegisterPage from './pages/auth/RegisterPage';
import ForgotPasswordPage from './pages/auth/ForgotPasswordPage';
import Dashboard from './pages/Dashboard';
import ProgramList from './pages/programs/ProgramList';
import ProgramDetails from './pages/programs/ProgramDetails';
import CreateProgram from './pages/programs/CreateProgram';
import TaskBoard from './pages/tasks/TaskBoard';
import TaskDetails from './pages/tasks/TaskDetails';
import CreateTask from './pages/tasks/CreateTask';
import ProfilePage from './pages/user/ProfilePage';
import SettingsPage from './pages/user/SettingsPage';
import NotFoundPage from './pages/NotFoundPage';

// Components
import PrivateRoute from './components/common/PrivateRoute';
import PublicRoute from './components/common/PublicRoute';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import Loader from './components/common/Loader';

function App() {
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Simulate initial loading
    const timer = setTimeout(() => {
      setLoading(false);
    }, 1000);
    
    return () => clearTimeout(timer);
  }, []);

  if (loading) {
    return <Loader />;
  }

  return (
    <AuthProvider>
      <Router>
        <div className="app">
          <Header />
          <main className="main-content">
            <Routes>
              {/* Public Routes */}
              <Route path="/" element={<LandingPage />} />
              <Route path="/login" element={<PublicRoute><LoginPage /></PublicRoute>} />
              <Route path="/register" element={<PublicRoute><RegisterPage /></PublicRoute>} />
              <Route path="/forgot-password" element={<PublicRoute><ForgotPasswordPage /></PublicRoute>} />

              {/* Protected Routes */}
              <Route path="/dashboard" element={<PrivateRoute><Dashboard /></PrivateRoute>} />
              <Route path="/programs" element={<PrivateRoute><ProgramList /></PrivateRoute>} />
              <Route path="/programs/create" element={<PrivateRoute><CreateProgram /></PrivateRoute>} />
              <Route path="/programs/:id" element={<PrivateRoute><ProgramDetails /></PrivateRoute>} />
              <Route path="/tasks" element={<PrivateRoute><TaskBoard /></PrivateRoute>} />
              <Route path="/tasks/create" element={<PrivateRoute><CreateTask /></PrivateRoute>} />
              <Route path="/tasks/:id" element={<PrivateRoute><TaskDetails /></PrivateRoute>} />
              <Route path="/profile" element={<PrivateRoute><ProfilePage /></PrivateRoute>} />
              <Route path="/settings" element={<PrivateRoute><SettingsPage /></PrivateRoute>} />

              {/* Fallback */}
              <Route path="/404" element={<NotFoundPage />} />
              <Route path="*" element={<Navigate to="/404" replace />} />
            </Routes>
          </main>
          <Footer />
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App; 