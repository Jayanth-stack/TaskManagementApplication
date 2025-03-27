import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../../components/common/PageHeader';

const TaskBoard = () => {
  return (
    <Container>
      <PageHeader 
        title="Task Board"
        subtitle="Manage and track your tasks"
      />
      <div className="text-center py-5">
        <p>Task board will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default TaskBoard; 