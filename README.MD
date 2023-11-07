# Description

This is a simple `todo-list` application designed for managing a list of tasks (to-do list).
You can add, edit, delete, mark tasks as completed, or put them on hold.

## Prerequisites

Before running the application, make sure you have the following components installed:

1. **Docker**: Ensure that you have Docker installed on your system. You can download Docker here: [Docker Downloads](https://www.docker.com/get-started).

2. **Docker Compose**: Docker Compose allows you to manage multiple Docker containers. Make sure Docker Compose is also installed. In most cases, Docker Compose comes bundled with Docker.

3. **Maven**: Maven is used for building Java projects. Ensure that Maven is installed on your system. You can download Maven here: [Apache Maven](https://maven.apache.org/).

## Step 1: Building the Project Using Maven

1. Open your terminal or command prompt.

2. Navigate to the root directory of your project where the `pom.xml` file is located.

3. Execute the following command to build the project using Maven:

   ```bash
   mvn clean install


## Step 2: Running with Docker Compose

1. Open your terminal or command prompt.

2. Navigate to the directory where the `Dockerfile` and `docker-compose.yml` files are located.

3. Start the application using the following command:

   ```bash
   docker-compose up


This command will start containers for your application and the MySQL database. The application will be accessible at http://localhost:8080.

