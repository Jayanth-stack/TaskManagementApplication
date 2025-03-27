import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../../components/common/PageHeader';

const CreateTask = () => {
  return (
    <Container>
      <PageHeader 
        title="Create Task"
        subtitle="Create a new task for your project"
      />
      <div className="text-center py-5">
        <p>Task creation form will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default CreateTask; 