#!/bin/bash

# Set default namespace
NAMESPACE="default"

# Build Docker images
echo "Building Docker images..."
docker build -t taskmanagement-backend:latest ./backend
docker build -t taskmanagement-frontend:latest ./frontend

# Make sure Kubernetes is running
echo "Checking Kubernetes status..."
kubectl get nodes

# Create namespace if it doesn't exist
kubectl create namespace $NAMESPACE --dry-run=client -o yaml | kubectl apply -f -

# Apply MongoDB resources
echo "Deploying MongoDB..."
kubectl apply -f k8s/mongodb/deployment.yaml -n $NAMESPACE
kubectl apply -f k8s/mongodb/service.yaml -n $NAMESPACE

# Wait for MongoDB to start
echo "Waiting for MongoDB to start..."
kubectl rollout status statefulset/mongodb -n $NAMESPACE

# Apply backend resources
echo "Deploying backend service..."
kubectl apply -f k8s/backend/deployment.yaml -n $NAMESPACE
kubectl apply -f k8s/backend/service.yaml -n $NAMESPACE

# Wait for backend to start
echo "Waiting for backend to start..."
kubectl rollout status deployment/backend -n $NAMESPACE

# Apply frontend resources
echo "Deploying frontend service..."
kubectl apply -f k8s/frontend/deployment.yaml -n $NAMESPACE
kubectl apply -f k8s/frontend/service.yaml -n $NAMESPACE

# Apply ingress
echo "Setting up ingress..."
kubectl apply -f k8s/ingress.yaml -n $NAMESPACE

# Get service information
echo "Deployment completed!"
echo ""
echo "Services:"
kubectl get svc -n $NAMESPACE

echo ""
echo "Add this to your hosts file:"
echo "127.0.0.1 taskmanagement.local"
echo ""
echo "Access your application at http://taskmanagement.local" 