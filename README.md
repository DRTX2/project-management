## Project Management

**Description**  
"Project Management" is a tool designed for project management, allowing the creation of boards, tasks, user assignments, and comments. Throughout the development process, the initial requirements were modified and expanded to enhance functionality and user experience. The project follows a **hexagonal architecture**, which ensures a clear separation between different layers of the application, facilitating scalability and maintainability of the code.

This project is built using **Spring Framework**, which provides a robust and flexible platform for developing enterprise-level applications. Spring's dependency injection and comprehensive ecosystem (Spring Data, Spring Web, etc.) allow for easy integration with various components, making the system extensible and maintainable.

The main goal of this system is to improve organization and collaboration within teams by efficiently managing tasks and tracking activities, using a modular structure that allows for easy extension and adaptation.
## Architecture

This project follows a **Hexagonal Architecture** (also known as Ports and Adapters), which aims to separate the core business logic from external concerns like databases, web frameworks, and messaging systems. The system is organized into several layers, ensuring that the core application remains independent of infrastructure concerns.

### Project Structure

The project is divided into the following modules:

- **adapters**: Contains all external adapters, such as persistence (database), REST (HTTP), and services.
  - **persistence**: Handles database interactions. The `UserRepositoryAdapter` implements the `UserRepository` from the core, using JPA entities and repositories.
  - **rest**: Provides the RESTful API for interacting with the system. Includes controllers, DTOs for request/response, and mappers for data transformation.
  - **services**: Contains the service layer, which implements business logic and interacts with repositories.

- **app**: Contains the main application entry point, responsible for launching the application.

- **core**: Contains the core business logic and interfaces. The core is independent of any external frameworks or tools.
  - **models**: Contains domain models (e.g., `User.java`).
  - **ports**: Defines the interfaces (e.g., `UserRepository.java`) that are implemented by the adapters.
  - **usecases**: Contains use case implementations (e.g., `UserService.java`), which represent the application’s business logic.

### How it works

- The core (`core/`) defines the domain models, business rules, and interfaces that represent the core use cases.
- The adapters (`adapters/`) provide the external implementations for interacting with the core. For example:
  - The **persistence** adapter implements the `UserRepository` interface using JPA.
  - The **rest** adapter exposes the core functionality through REST endpoints, using controllers and DTOs to communicate between the client and the core.
- The adapters interact with the core through well-defined **ports** and **use cases**, ensuring a clear separation of concerns and enabling easier testing and extensibility.


## Entities

- **User**
    ```java
    public class User {
        private Long id;
        private String name;
        private String email;
        private String password;
        private String role;
        private LocalDate registrationDate;
        private List<Project> associatedProjects;
    }
    ```

- **Project**
    ```java
    public class Project {
        private Long id;
        private String name;
        private String description;
        private User owner;
        private LocalDate creationDate;
        private LocalDate endDate;
        private List<Board> associatedBoards;
    }
    ```

- **Board**
    ```java
    public class Board {
        private Long id;
        private String name;
        private String description;
        private Project associatedProject;
        private List<Task> tasks;
    }
    ```

- **TaskList**
    ```java
    public class TaskList {
        private Long id;
        private String name;
        private int boardPosition;
        private List<Task> tasks;
    }
    ```

- **Task**
    ```java
    public class Task {
        private Long id;
        private String name;
        private String description;
        private TaskState state; // Pending, In Progress, Complete
        private int priority;
        private LocalDate endDate;
        private User assignedTo;
        private List<Comment> comments;
    }

    public enum TaskState {
        PENDING, IN_PROGRESS, COMPLETE;
    }
    ```

- **Comment**
    ```java
    public class Comment {
        private Long id;
        private String text;
        private User author;
        private LocalDate creationDate;
        private Task associatedTask;
    }
    ```

- **Notification**
    ```java
    public class Notification {
        private Long id;
        private String message;
        private String type;
        private User targetUser;
        private LocalDate sendDate;
    }
    ```

- **Label**
    ```java
    public class Label {
        private Long id;
        private String name;
        private String color;
        private List<Task> associatedTasks;
    }
    ```

- **Attachment**
    ```java
    public class Attachment {
        private Long id;
        private String name;
        private String fileUrl;
        private String fileType;
        private User updatedBy;
        private Task relatedTask;
    }
    ```
## Requirements

To run the "Project Management" application, ensure the following software is installed:

- **Java 21**: The project uses Java 21 as the primary development and runtime environment.
- **Maven**: Maven is used for dependency management and building the application. Ensure you have Maven installed to build and run the project.

### Dependencies

The following dependencies are used in the project:

- **Spring Boot 3.4.4**: The project is built on Spring Boot 3.4.4 for easy configuration, dependency injection, and web development.
- **Spring Data JPA**: To interact with relational databases using JPA (Java Persistence API).
- **Spring Boot Validation**: For input validation in REST endpoints.
- **Spring Boot Web**: Provides the necessary libraries for building web applications, including RESTful APIs.
- **PostgreSQL**: The project uses PostgreSQL as the database management system for storing user, project, task, and other entities.
- **MapStruct**: For object mapping between domain models and DTOs, reducing boilerplate code.
- **Spring Boot Actuator**: For monitoring and managing the application in production environments.

### Build Configuration

This project uses **Maven** for dependency management and builds. The `maven-compiler-plugin` is configured to use Java 21 for both the source and target versions:

```xml
<properties>
    <java.version>21</java.version>
    <mapstruct.version>1.5.5.Final</mapstruct.version>
</properties>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>${java.version}</source>
                <target>${java.version}</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Ensure that your Java environment is properly configured to use Java 21 to build and run the project. The PostgreSQL database should also be configured correctly to interact with the application.

## Installation

To set up and run the "Project Management" application locally, follow these steps:

### Prerequisites

Before starting, ensure you have the following installed:

- **Java 21**: You need Java 21 installed on your machine. You can check your Java version by running:
  ```bash
  java -version
  ```
- **Maven**: Make sure Maven is installed for managing dependencies and building the project. Check if Maven is installed by running:
 ```bash
  mvn -v
  ```
- **PostgreSQL**: Install and set up PostgreSQL as the database for the application. Ensure the database is running and accessible.
#### Steps
- Clone the repository: Clone the project repository to your local machine using Git:

 ```bash
  git clone https://github.com/your-username/project-management.git
  cd project-management
  ```

- Configure PostgreSQL:
  - Create a new database in PostgreSQL for the application.
  - Update the application.properties file (or application.yml if used) with your PostgreSQL connection details:
 ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/project_management_db
  spring.datasource.username=your-username
  spring.datasource.password=your-password
  spring.jpa.hibernate.ddl-auto=update
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.datasource.platform=postgres
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
  ```
- Build the project: In the root directory of the project, run the following Maven command to build the application:
 ```bash
  mvn clean install
  ```
- Run the application: After building the project, you can start the application using the following Maven command:
 ```bash
  mvn spring-boot:run
  ```
- Access the application: The application should now be running locally. You can access it through the following URL:
 ```bash
  http://localhost:8080
  ```
```markdown
## Usage

Once the application is running, you can use it to manage your projects, tasks, and teams. Below are the main functionalities available in the application.

### 1. Create a User:
To create a new user, make a POST request to the `/api/users` endpoint with the following JSON body:

```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "password": "password123",
  "role": "ADMIN"
}
```

### 2. Create a Project:
To create a new project, make a POST request to the `/api/projects` endpoint with the following JSON body:

```json
{
  "name": "New Project",
  "description": "This is a new project.",
  "ownerId": 1
}
```

Replace `"ownerId"` with the ID of the user who will own the project.

### 3. Create a Board:
To create a new board under a project, make a POST request to the `/api/boards` endpoint with the following JSON body:

```json
{
  "name": "To Do",
  "description": "Tasks to be done",
  "projectId": 1
}
```

### 4. Create a Task:
To create a new task within a board, make a POST request to the `/api/tasks` endpoint with the following JSON body:

```json
{
  "name": "Task 1",
  "description": "This is a task description.",
  "state": "PENDING",
  "priority": 1,
  "endDate": "2025-04-01",
  "assignedToId": 1,
  "boardId": 1
}
```

### 5. Add a Comment to a Task:
To add a comment to a task, make a POST request to the `/api/comments` endpoint with the following JSON body:

```json
{
  "text": "This is a comment",
  "authorId": 1,
  "taskId": 1
}
```

### 6. Get All Projects:
To retrieve a list of all projects, make a GET request to the `/api/projects` endpoint:

```bash
GET http://localhost:8080/api/projects
```

### 7. Get Tasks by Board:
To get all tasks within a specific board, make a GET request to the `/api/boards/{boardId}/tasks` endpoint:

```bash
GET http://localhost:8080/api/boards/1/tasks
```

### 8. Get User Notifications:
To get all notifications for a specific user, make a GET request to the `/api/users/{userId}/notifications` endpoint:

```bash
GET http://localhost:8080/api/users/1/notifications
```

### 9. Update Task Status:
To update the status of a task, make a PUT request to the `/api/tasks/{taskId}` endpoint with the following JSON body:

```json
{
  "state": "IN_PROGRESS"
}
```

### 10. Delete a Task:
To delete a task, make a DELETE request to the `/api/tasks/{taskId}` endpoint:

```bash
DELETE http://localhost:8080/api/tasks/1
```

The application provides a fully functional interface for managing users, projects, boards, tasks, and comments. You can extend its functionality as needed by interacting with the provided RESTful API endpoints.

## Structure

```
/src/main/java/com/projectManagement/heavySpring
├── /adapters                  (Adaptadores para interactuar con servicios, repositorios y REST)
│   ├── /persistence           (Capa de persistencia para interactuar con la base de datos)
│   │   └── /user              (Repositorio y entidad de usuario)
│   │       ├── UserEntity.java
│   │       ├── UserPersistenceMapper.java
│   │       ├── UserPersistenceRepository.java
│   │       └── UserRepositoryAdapter.java
│   ├── /rest                  (Adaptadores REST, controladores y manejo de excepciones)
│   │   ├── /exceptions        (Excepciones globales)
│   │   │   └── GlobalExceptionHandler.java
│   │   └── /user              (Controlador y mapeadores de usuario)
│   │       ├── UserController.java
│   │       ├── /dto           (DTOs de usuario)
│   │       │   ├── UserRequest.java
│   │       │   └── UserResponse.java
│   │       └── /mappers       (Mapeadores REST)
│   │           └── UserRestMapper.java
│   └── /services              (Servicios que implementan la lógica de negocio)
│       └── UserServiceImpl.java
├── /app                       (Clase principal de la aplicación)
│   └── HeavySpringApplication.java
├── /core                      (Lógica de negocio y modelos)
│   ├── /models                (Modelos de dominio)
│   │   └── User.java
│   ├── /ports                 (Interfaces o puertos para interactuar con la base de datos)
│   │   └── UserRepository.java
│   └── /usecases              (Casos de uso y servicios)
│       └── UserService.java
```

---
## TO DO

- entities for boards, tasks, users, and comments.
- the frontend using something like angular or react.
- Order to chatgpt more ideas



## GPT

Historial de Actividad (ActivityLog)

ID

Usuario que realizó la acción

Acción realizada (creó, editó, movió, etc.)

Entidad afectada (Tarea, Proyecto, etc.)

Timestamp

🔥 Relaciones clave:
Un Usuario puede tener múltiples Proyectos.

Un Proyecto puede tener múltiples Tableros.

Un Tablero tiene múltiples Listas de Tareas.

Una Lista de Tareas agrupa múltiples Tareas.

Una Tarea puede tener múltiples Comentarios, Etiquetas y Adjuntos.

Un Usuario puede ser asignado a múltiples Tareas.

Un Usuario recibe Notificaciones según la actividad en sus proyectos/tareas.

Con estas entidades, la plataforma cubriría lo esencial de un gestor de proyectos con tareas organizadas en tableros tipo Trello. ¿Quieres que profundicemos en alguna parte, como autenticación, control de acceso o lógica de negocio? 🚀






