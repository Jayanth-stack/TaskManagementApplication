import React from 'react';
import { Container } from 'react-bootstrap';
import PageHeader from '../../components/common/PageHeader';

const ProgramList = () => {
  return (
    <Container>
      <PageHeader 
        title="Programs"
        subtitle="View and manage your programs"
      />
      <div className="text-center py-5">
        <p>Program list will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default ProgramList; 