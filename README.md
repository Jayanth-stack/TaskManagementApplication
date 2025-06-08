# Task Management Application

A full-stack task management application built with Spring Boot, React, and MongoDB, containerized with Docker and deployable on Kubernetes.

## 🚀 Features

- **Task Management**
  - Create, read, update, and delete tasks
  - Assign tasks to users
  - Set task priorities and due dates
  - Track task status (TODO, IN_PROGRESS, DONE)

- **User Management**
  - User registration and authentication
  - Role-based access control (ADMIN, USER)
  - User profile management

- **Project Organization**
  - Create and manage projects
  - Assign tasks to projects
  - Track project progress

- **Modern UI/UX**
  - Responsive design
  - Dark/Light theme support
  - Interactive task board
  - Real-time updates

## 🏗️ Architecture

### Backend (Spring Boot)
- Java 17
- Spring Boot 3.x
- Spring Security with JWT
- MongoDB for data storage
- Maven for dependency management
- RESTful API design

### Frontend (React)
- React 18
- TypeScript
- Material-UI components
- Redux for state management
- Axios for API communication
- Nginx for serving static files

### Database
- MongoDB 6.0
- Document-based storage
- Indexed collections for performance

## 🛠️ Prerequisites

- Java 17 JDK
- Node.js 18+
- MongoDB 6.0+
- Docker and Docker Compose
- Kubernetes (for k8s deployment)

## 🚀 Getting Started

### Local Development

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd TaskManagement
   ```

2. Start MongoDB:
   ```bash
   docker-compose up -d mongodb
   ```

3. Start the backend:
   ```bash
   cd backend
   mvn spring-boot:run
   ```

4. Start the frontend:
   ```bash
   cd frontend
   npm install
   npm start
   ```

5. Access the application:
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080
   - MongoDB: mongodb://localhost:27017

### Docker Deployment

1. Build and start all services:
   ```bash
   docker-compose up -d --build
   ```

2. Access the application:
   - Frontend: http://localhost
   - Backend API: http://localhost:8080

### Kubernetes Deployment

1. Ensure Kubernetes cluster is running:
   ```bash
   kubectl get nodes
   ```

2. Deploy the application:
   ```bash
   ./k8s-deploy.sh
   ```

3. Add to hosts file:
   ```
   127.0.0.1 taskmanagement.local
   ```

4. Access the application:
   - Frontend: http://taskmanagement.local

## 📁 Project Structure

```
TaskManagement/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/taskmanagement/
│   │   │   │       ├── config/
│   │   │   │       ├── controller/
│   │   │   │       ├── model/
│   │   │   │       ├── repository/
│   │   │   │       ├── service/
│   │   │   │       └── security/
│   │   │   └── resources/
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   └── utils/
│   ├── Dockerfile
│   └── package.json
├── k8s/
│   ├── backend/
│   ├── frontend/
│   ├── mongodb/
│   └── ingress.yaml
├── docker-compose.yml
├── deploy.sh
└── k8s-deploy.sh
```

## 🔒 Security

- JWT-based authentication
- Password encryption with BCrypt
- Role-based authorization
- CORS configuration
- Input validation and sanitization

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
```

### Frontend Tests
```bash
cd frontend
npm test
```

## 📝 API Documentation

The API documentation is available at:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Spec: http://localhost:8080/v3/api-docs

## 🔄 CI/CD

The project includes:
- Docker containerization
- Kubernetes orchestration
- Automated deployment scripts
- Multi-stage builds for optimized images

## 🐛 Troubleshooting

### Common Issues

1. **MongoDB Connection Issues**
   - Check if MongoDB container is running
   - Verify connection string in application.properties
   - Check network connectivity

2. **Docker Build Failures**
   - Ensure Docker Desktop is running
   - Check for sufficient disk space
   - Verify Dockerfile syntax

3. **Kubernetes Deployment Issues**
   - Check cluster status
   - Verify resource limits
   - Check pod logs

## 📚 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [React Documentation](https://reactjs.org/)
- [MongoDB Documentation](https://www.mongodb.com/docs/)
- [Docker Documentation](https://docs.docker.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request



