# Project Completed

---

## Project Overview

This project consists of two separate modules:

### 1. Library  
This is the main project that provides an API for searching books. It includes sample test data and can be run locally using the provided JAR file.

- **Service name:** localhost  
- **Port:** 8080  
- **API endpoint:**  
GET http://localhost:8080/api/v1/books/search

pgsql
Copy
Edit
- Supports pagination, filtering, and other query parameters for flexible search.

---

### 2. SecurityService  
This secondary project handles authentication and authorization using username, password, and refresh tokens.

- **Service name:** localhost  
- **Port:** 8080  

- **Register user:**  
```bash
curl --location 'http://localhost:8080/api/auth/register' \
--header 'Content-Type: application/json' \
--data '{
  "username": "testuser1",
  "password": "password123"
}'
Login user:

bash
Copy
Edit
curl --location 'http://localhost:8080/api/auth/login' \
--header 'Content-Type: application/json' \
--data '{
  "username": "testuser1",
  "password": "password123"
}'
Refresh access token:

bash
Copy
Edit
curl --location 'http://localhost:8080/api/auth/refresh-token' \
--header 'Content-Type: application/json' \
--data '{
  "refreshToken": "3e7e8fbe-84fa-4568-aa1e-a6e029472e6a"
}'
Action Plan
Deploy applications to Docker Hub and create Docker images

This requires some implementation time.

Create a Helm chart to deploy three applications together:

library

securityservice

apigateway (to be implemented)

Plan for API Gateway:

Route requests to appropriate backend services via URLs.

Implement robust authorization at the gateway level for enhanced security.

Enable easy configuration and management.

Facilitate simple integration of new APIs or microservices.

Deploy using the Helm chart with templates

Add Horizontal Pod Autoscaler (HPA) to manage memory utilization and scaling dynamically.

Optimize resource usage for maximum efficiency.
