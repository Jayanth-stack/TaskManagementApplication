#!/bin/bash

# Stop running containers
echo "Stopping any running containers..."
docker-compose down

# Build and start containers in detached mode
echo "Building and starting containers..."
docker-compose up -d --build

# Check if containers are running
echo "Checking container status..."
docker-compose ps

echo ""
echo "Deployment completed! Your application is now running at:"
echo "Frontend: http://localhost"
echo "Backend API: http://localhost:8080"
echo "MongoDB: localhost:27017" 