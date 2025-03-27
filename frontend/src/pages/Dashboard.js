import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button, Badge } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import ProgramService from '../services/ProgramService';
import TaskService from '../services/TaskService';
import PageHeader from '../components/common/PageHeader';
import Loader from '../components/common/Loader';

const Dashboard = () => {
  const { currentUser } = useAuth();
  const [loading, setLoading] = useState(true);
  const [programs, setPrograms] = useState([]);
  const [tasks, setTasks] = useState([]);
  const [stats, setStats] = useState({
    totalTasks: 0,
    completedTasks: 0,
    inProgressTasks: 0,
    pendingTasks: 0,
    overdueTask: 0
  });

  useEffect(() => {
    const fetchDashboardData = async () => {
      try {
        setLoading(true);
        
        // Fetch user's programs
        const programsResponse = await ProgramService.getProgramsByUser(currentUser.id);
        setPrograms(programsResponse.programList || []);
        
        // Fetch tasks assigned to user
        // Note: This is a placeholder - adjust based on your actual API
        const tasksResponse = await TaskService.getTasksByAssignee(currentUser.id);
        const taskList = tasksResponse || [];
        setTasks(taskList);
        
        // Calculate statistics
        const completed = taskList.filter(task => task.status === 'COMPLETED').length;
        const inProgress = taskList.filter(task => task.status === 'IN_PROGRESS').length;
        const pending = taskList.filter(task => task.status === 'PENDING').length;
        const overdue = taskList.filter(task => {
          return new Date(task.deadline) < new Date() && task.status !== 'COMPLETED';
        }).length;
        
        setStats({
          totalTasks: taskList.length,
          completedTasks: completed,
          inProgressTasks: inProgress,
          pendingTasks: pending,
          overdueTasks: overdue
        });
        
      } catch (error) {
        console.error('Error fetching dashboard data:', error);
      } finally {
        setLoading(false);
      }
    };
    
    fetchDashboardData();
  }, [currentUser]);

  if (loading) {
    return <Loader />;
  }

  // Helper function to get status badge
  const getStatusBadge = (status) => {
    const statusMap = {
      'COMPLETED': <Badge bg="success">Completed</Badge>,
      'IN_PROGRESS': <Badge bg="primary">In Progress</Badge>,
      'PENDING': <Badge bg="warning">Pending</Badge>,
      'OVERDUE': <Badge bg="danger">Overdue</Badge>
    };
    
    return statusMap[status] || <Badge bg="secondary">Unknown</Badge>;
  };

  return (
    <Container>
      <PageHeader 
        title={`Welcome, ${currentUser.username}`}
        subtitle="Here's an overview of your tasks and programs"
      />
      
      {/* Stats Cards */}
      <Row className="mb-4">
        <Col md={3} sm={6} className="mb-3 mb-md-0">
          <Card className="h-100 border-0 shadow-sm">
            <Card.Body className="d-flex flex-column align-items-center text-center">
              <div className="rounded-circle bg-primary bg-opacity-10 p-3 mb-3">
                <i className="fas fa-tasks text-primary" style={{ fontSize: '24px' }}></i>
              </div>
              <h3 className="mb-1 fw-bold">{stats.totalTasks}</h3>
              <p className="text-muted mb-0">Total Tasks</p>
            </Card.Body>
          </Card>
        </Col>
        <Col md={3} sm={6} className="mb-3 mb-md-0">
          <Card className="h-100 border-0 shadow-sm">
            <Card.Body className="d-flex flex-column align-items-center text-center">
              <div className="rounded-circle bg-success bg-opacity-10 p-3 mb-3">
                <i className="fas fa-check text-success" style={{ fontSize: '24px' }}></i>
              </div>
              <h3 className="mb-1 fw-bold">{stats.completedTasks}</h3>
              <p className="text-muted mb-0">Completed</p>
            </Card.Body>
          </Card>
        </Col>
        <Col md={3} sm={6} className="mb-3 mb-md-0">
          <Card className="h-100 border-0 shadow-sm">
            <Card.Body className="d-flex flex-column align-items-center text-center">
              <div className="rounded-circle bg-primary bg-opacity-10 p-3 mb-3">
                <i className="fas fa-spinner text-primary" style={{ fontSize: '24px' }}></i>
              </div>
              <h3 className="mb-1 fw-bold">{stats.inProgressTasks}</h3>
              <p className="text-muted mb-0">In Progress</p>
            </Card.Body>
          </Card>
        </Col>
        <Col md={3} sm={6}>
          <Card className="h-100 border-0 shadow-sm">
            <Card.Body className="d-flex flex-column align-items-center text-center">
              <div className="rounded-circle bg-danger bg-opacity-10 p-3 mb-3">
                <i className="fas fa-exclamation-triangle text-danger" style={{ fontSize: '24px' }}></i>
              </div>
              <h3 className="mb-1 fw-bold">{stats.overdueTasks}</h3>
              <p className="text-muted mb-0">Overdue</p>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      
      {/* Recent Tasks and Programs */}
      <Row>
        <Col lg={7} className="mb-4">
          <Card className="border-0 shadow-sm h-100">
            <Card.Header className="bg-white py-3 d-flex justify-content-between align-items-center">
              <h5 className="mb-0">Recent Tasks</h5>
              <Button 
                as={Link} 
                to="/tasks" 
                variant="outline-primary" 
                size="sm"
              >
                View All
              </Button>
            </Card.Header>
            <Card.Body className="p-0">
              {tasks.length > 0 ? (
                <div className="task-list">
                  {tasks.slice(0, 5).map((task) => (
                    <div key={task.id} className="p-3 border-bottom d-flex justify-content-between align-items-center">
                      <div>
                        <h6 className="mb-1">
                          <Link to={`/tasks/${task.id}`} className="text-decoration-none text-dark">
                            {task.name}
                          </Link>
                        </h6>
                        <p className="text-muted small mb-0">
                          {task.description ? `${task.description.substring(0, 60)}...` : 'No description'}
                        </p>
                      </div>
                      <div className="d-flex align-items-center">
                        {getStatusBadge(task.status)}
                      </div>
                    </div>
                  ))}
                </div>
              ) : (
                <div className="text-center p-4">
                  <p className="mb-2">No tasks found</p>
                  <Button 
                    as={Link} 
                    to="/tasks/create" 
                    variant="primary" 
                    size="sm"
                  >
                    Create Task
                  </Button>
                </div>
              )}
            </Card.Body>
          </Card>
        </Col>
        
        <Col lg={5} className="mb-4">
          <Card className="border-0 shadow-sm h-100">
            <Card.Header className="bg-white py-3 d-flex justify-content-between align-items-center">
              <h5 className="mb-0">My Programs</h5>
              <Button 
                as={Link} 
                to="/programs" 
                variant="outline-primary" 
                size="sm"
              >
                View All
              </Button>
            </Card.Header>
            <Card.Body className="p-0">
              {programs.length > 0 ? (
                <div className="program-list">
                  {programs.slice(0, 4).map((program) => (
                    <div key={program.id} className="p-3 border-bottom">
                      <Link to={`/programs/${program.id}`} className="text-decoration-none">
                        <h6 className="text-dark mb-1">{program.name}</h6>
                      </Link>
                      <p className="text-muted small mb-0">
                        {program.taskCount || 0} tasks · Created by {program.createdBy === currentUser.id ? 'you' : program.creatorName || 'Unknown'}
                      </p>
                    </div>
                  ))}
                </div>
              ) : (
                <div className="text-center p-4">
                  <p className="mb-2">No programs found</p>
                  <Button 
                    as={Link} 
                    to="/programs/create" 
                    variant="primary" 
                    size="sm"
                  >
                    Create Program
                  </Button>
                </div>
              )}
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default Dashboard; 