import React from 'react';
import { Container, Row, Col, Button, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const LandingPage = () => {
  const { isAuthenticated } = useAuth();

  return (
    <div className="landing-page">
      {/* Hero Section */}
      <section className="hero-section bg-primary text-white py-5">
        <Container>
          <Row className="align-items-center py-5">
            <Col lg={6} className="py-lg-5">
              <h1 className="display-4 fw-bold mb-4 fade-in">Manage Tasks. Boost Productivity.</h1>
              <p className="lead mb-4 fade-in">
                A powerful task management platform designed for teams to collaborate efficiently and deliver on time.
              </p>
              <div className="fade-in">
                {isAuthenticated ? (
                  <Button 
                    as={Link} 
                    to="/dashboard" 
                    variant="light" 
                    size="lg" 
                    className="me-3 text-primary"
                  >
                    Go to Dashboard
                  </Button>
                ) : (
                  <>
                    <Button 
                      as={Link} 
                      to="/register" 
                      variant="light" 
                      size="lg" 
                      className="me-3 text-primary"
                    >
                      Get Started
                    </Button>
                    <Button 
                      as={Link} 
                      to="/login" 
                      variant="outline-light" 
                      size="lg"
                    >
                      Sign In
                    </Button>
                  </>
                )}
              </div>
            </Col>
            <Col lg={6} className="mt-5 mt-lg-0 text-center fade-in">
              <img 
                src="https://placehold.co/600x400/4A6CF7/FFFFFF?text=Task+Management" 
                alt="Task Management" 
                className="img-fluid rounded shadow"
                style={{ maxWidth: '100%' }}
              />
            </Col>
          </Row>
        </Container>
      </section>

      {/* Features Section */}
      <section className="py-5">
        <Container>
          <div className="text-center mb-5">
            <h2 className="fw-bold mb-3">Why Choose TaskMaster?</h2>
            <p className="text-muted mx-auto" style={{ maxWidth: '700px' }}>
              Our platform simplifies task management, enhances team collaboration, and helps you deliver projects on time.
            </p>
          </div>
          
          <Row>
            <Col md={4} className="mb-4">
              <Card className="h-100 border-0 shadow-sm">
                <Card.Body className="text-center p-4">
                  <div className="feature-icon bg-primary bg-opacity-10 text-primary rounded-circle mb-3 mx-auto" style={{ width: '70px', height: '70px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                    <i className="fas fa-tasks fa-2x"></i>
                  </div>
                  <h4 className="mb-3">Task Management</h4>
                  <p className="text-muted">
                    Create, assign, and track tasks with ease. Set priorities, deadlines, and monitor progress in real-time.
                  </p>
                </Card.Body>
              </Card>
            </Col>
            
            <Col md={4} className="mb-4">
              <Card className="h-100 border-0 shadow-sm">
                <Card.Body className="text-center p-4">
                  <div className="feature-icon bg-success bg-opacity-10 text-success rounded-circle mb-3 mx-auto" style={{ width: '70px', height: '70px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                    <i className="fas fa-users fa-2x"></i>
                  </div>
                  <h4 className="mb-3">Team Collaboration</h4>
                  <p className="text-muted">
                    Foster seamless collaboration with shared workspaces, comments, and program management features.
                  </p>
                </Card.Body>
              </Card>
            </Col>
            
            <Col md={4} className="mb-4">
              <Card className="h-100 border-0 shadow-sm">
                <Card.Body className="text-center p-4">
                  <div className="feature-icon bg-warning bg-opacity-10 text-warning rounded-circle mb-3 mx-auto" style={{ width: '70px', height: '70px', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                    <i className="fas fa-chart-line fa-2x"></i>
                  </div>
                  <h4 className="mb-3">Progress Tracking</h4>
                  <p className="text-muted">
                    Monitor project progress with visual dashboards, status updates, and performance metrics.
                  </p>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </section>

      {/* CTA Section */}
      <section className="bg-light py-5">
        <Container>
          <Row className="justify-content-center text-center">
            <Col lg={8}>
              <h2 className="fw-bold mb-3">Ready to boost your team's productivity?</h2>
              <p className="lead text-muted mb-4">
                Join thousands of teams that use TaskMaster to manage their projects effectively.
              </p>
              {!isAuthenticated && (
                <Button 
                  as={Link} 
                  to="/register" 
                  variant="primary" 
                  size="lg" 
                  className="px-4 py-2"
                >
                  Start Free Trial
                </Button>
              )}
            </Col>
          </Row>
        </Container>
      </section>
    </div>
  );
};

export default LandingPage; 