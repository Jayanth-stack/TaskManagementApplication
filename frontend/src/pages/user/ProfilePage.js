import React from 'react';
import { Container } from 'react-bootstrap';
import { useAuth } from '../../context/AuthContext';
import PageHeader from '../../components/common/PageHeader';

const ProfilePage = () => {
  const { currentUser } = useAuth();
  
  return (
    <Container>
      <PageHeader 
        title="My Profile"
        subtitle={`Welcome, ${currentUser?.username || 'User'}`}
      />
      <div className="text-center py-5">
        <p>User profile page will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default ProfilePage; 