
# Task Management Application

This project is a Task Management Application built with a Spring Boot backend and an Angular frontend. The application allows users to create, update, delete, and view tasks in an organized manner, ensuring seamless task management.

## Tech Stack

### Backend:
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

### Frontend:
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

### Database:
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)

### Other Tools:
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## Features

- Create new tasks
- View all tasks
- Edit task details
- Delete tasks
- Mark tasks as complete/incomplete
- Real-time updates with Angular frontend

## Project Structure

```
📁 task-management-app/
    ├── 📁 backend/
    │   ├── src/
    │   │   └── main/
    │   │       ├── java/
    │   │       │   └── com/taskmanagement/
    │   │       └── resources/
    │   └── pom.xml
    ├── 📁 frontend/
    │   └── src/
    │       └── app/
    ├── README.md  # Project documentation (this file)
    └── docker-compose.yml  # For containerization (optional)
```

## Installation and Setup

### Prerequisites

- **Backend**:
  - Java 11 or higher
  - Maven
  - MongoDB

- **Frontend**:
  - Node.js (v14.x or higher)
  - Angular CLI (v12.x or higher)

### Running the Application

#### 1. Clone the Repository

```bash
git clone https://github.com/your-username/task-management-app.git
cd task-management-app
```

#### 2. Set Up the Backend (Spring Boot)

1. **Install and Run MongoDB**:
   Make sure MongoDB is installed and running on your local machine or in the cloud (e.g., MongoDB Atlas).

2. **Configure `application.properties`**:

   Open the `application.properties` file in `backend/src/main/resources/` and update the MongoDB configuration:
   ```properties
   spring.data.mongodb.database=task_management
   spring.data.mongodb.uri=mongodb://localhost:27017/task_management
   ```

   If using MongoDB Atlas, the connection string will look something like this:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/task_management?retryWrites=true&w=majority
   ```

3. **Build and Run the Backend**:
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

   The Spring Boot server will run at:
   ```
   http://localhost:8080
   ```

#### 3. Set Up the Frontend (Angular)

1. **Install Dependencies**:
   Navigate to the `frontend` directory and install the required dependencies:

   ```bash
   cd ../frontend
   npm install
   ```

2. **Run the Angular Development Server**:

   ```bash
   ng serve
   ```

   The Angular app will run at:
   ```
   http://localhost:4200
   ```

#### 4. Access the Application

Open your browser and navigate to the frontend:
```
http://localhost:4200
```

You will see the Task Management UI where you can start adding and managing tasks.

## Usage

- **Create Task**: Add new tasks using the task form.
- **View Tasks**: See all your tasks listed on the dashboard.
- **Edit Task**: Click on a task to edit its details.
- **Delete Task**: Remove tasks that are no longer needed.
- **Task Status**: Mark tasks as complete or incomplete.

## Running with Docker (Optional)

You can use Docker to run both the Spring Boot and Angular applications with the provided `docker-compose.yml`.

```bash
docker-compose up --build
```

The backend will be available on `http://localhost:8080`, and the frontend will be available on `http://localhost:4200`.

## Contributing

Feel free to fork this repository, make changes, and submit a pull request. All contributions are welcome!

