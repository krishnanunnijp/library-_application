Sure! Here's an enhanced, polished version of your README content with improved grammar, clarity, and formatting — ready to be copied straight into your README.md:

---

# Project Overview

This project consists of two separate applications:

### 1. Library

This is the main project which provides an API for searching books. It has been tested with sample data and can be run locally using the provided JAR file.

* **Service Name:** localhost
* **Port:** 8080
* **API Endpoint:**

  ```
  GET http://localhost:8080/api/v1/books/search
  ```
* Supports pagination, filtering, and other query parameters for flexible book searching.

---

### 2. SecurityService

This secondary project handles authentication and authorization using username, password, and refresh tokens.

* **Service Name:** localhost
* **Port:** 8080

#### Example API calls:

* **User Registration:**

  ```bash
  curl --location 'http://localhost:8080/api/auth/register' \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "testuser1",
    "password": "password123"
  }'
  ```

* **User Login:**

  ```bash
  curl --location 'http://localhost:8080/api/auth/login' \
  --header 'Content-Type: application/json' \
  --data '{
    "username": "testuser1",
    "password": "password123"
  }'
  ```

* **Refresh Access Token:**

  ```bash
  curl --location 'http://localhost:8080/api/auth/refresh-token' \
  --header 'Content-Type: application/json' \
  --data '{
    "refreshToken": "3e7e8fbe-84fa-4568-aa1e-a6e029472e6a"
  }'
  ```

---

# Action Plan

1. **Deploy to Docker Hub**
   Create Docker images for both applications and publish them on Docker Hub. *(Implementation in progress)*

2. **Create Helm Chart**
   Develop a Helm chart to deploy and manage these three applications together:

   * Library
   * SecurityService
   * API Gateway *(to be implemented)*

   **API Gateway Plan:**

   * Route incoming requests to appropriate backend services.
   * Enhance security and authorization at the gateway level.
   * Provide easy configuration for adding new APIs or microservices.

3. **Deployment Enhancements**

   * Use Helm templates for configuration and deployment.
   * Integrate Horizontal Pod Autoscaler (HPA) for resource scaling based on memory utilization and traffic load.
   * Optimize for high availability and efficient resource management.


