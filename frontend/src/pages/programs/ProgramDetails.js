import React from 'react';
import { Container } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import PageHeader from '../../components/common/PageHeader';

const ProgramDetails = () => {
  const { id } = useParams();
  
  return (
    <Container>
      <PageHeader 
        title="Program Details"
        subtitle={`Program ID: ${id}`}
      />
      <div className="text-center py-5">
        <p>Program details will be implemented soon.</p>
      </div>
    </Container>
  );
};

export default ProgramDetails; 