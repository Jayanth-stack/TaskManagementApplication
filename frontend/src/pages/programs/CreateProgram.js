import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../../components/common/PageHeader';

const CreateProgram = () => {
  return (
    <Container>
      <PageHeader 
        title="Create Program"
        subtitle="Create a new program for your team"
      />
      <div className="text-center py-5">
        <p>Program creation form will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default CreateProgram; 