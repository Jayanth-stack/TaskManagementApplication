import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../../components/common/PageHeader';

const SettingsPage = () => {
  return (
    <Container>
      <PageHeader 
        title="Settings"
        subtitle="Manage your account settings"
      />
      <div className="text-center py-5">
        <p>User settings page will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default SettingsPage; 