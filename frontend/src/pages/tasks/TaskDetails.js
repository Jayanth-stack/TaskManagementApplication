import React from 'react';
import { Container } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import PageHeader from '../../components/common/PageHeader';

const TaskDetails = () => {
  const { id } = useParams();
  
  return (
    <Container>
      <PageHeader 
        title="Task Details"
        subtitle={`Task ID: ${id}`}
      />
      <div className="text-center py-5">
        <p>Task details will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default TaskDetails; 