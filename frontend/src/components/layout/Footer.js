import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Footer = () => {
  const currentYear = new Date().getFullYear();
  
  return (
    <footer className="bg-light py-4 mt-auto">
      <Container>
        <Row className="justify-content-between align-items-center">
          <Col md={4} className="text-center text-md-start">
            <h5 className="text-primary mb-3">TaskMaster</h5>
            <p className="text-muted small">
              Task management made simple and effective for teams of all sizes.
            </p>
          </Col>
          
          <Col md={4} className="d-flex justify-content-center my-3 my-md-0">
            <ul className="list-unstyled d-flex gap-4">
              <li>
                <Link to="/" className="text-decoration-none text-secondary">
                  Home
                </Link>
              </li>
              <li>
                <Link to="/about" className="text-decoration-none text-secondary">
                  About
                </Link>
              </li>
              <li>
                <Link to="/contact" className="text-decoration-none text-secondary">
                  Contact
                </Link>
              </li>
            </ul>
          </Col>
          
          <Col md={4} className="text-center text-md-end">
            <p className="text-muted small mb-0">
              &copy; {currentYear} TaskMaster. All rights reserved.
            </p>
          </Col>
        </Row>
      </Container>
    </footer>
  );
};

export default Footer; 