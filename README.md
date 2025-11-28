# Task Manager API

A RESTful API built with Spring Boot for managing tasks. This project demonstrates CRUD operations, REST principles, and Spring Data JPA integration with an H2 in-memory database.

## Technologies Used

- Java 25
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA (Database operations)
- H2 Database (In-memory database)
- Maven (Project management)

## Features

- Create new tasks
- Retrieve all tasks or a specific task by ID
- Update existing tasks
- Delete tasks
- Auto-generated task IDs
- JSON request/response format
- RESTful API design

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven (included via Maven Wrapper)

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/Andy916/task-manager.git
cd task-manager
```

2. Run the application:
```bash
./mvnw spring-boot:run
```

3. The API will be available at: `http://localhost:8080`

### Stopping the Application

Press `Ctrl + C` in the terminal, then confirm to terminate the batch job.

## API Endpoints

### Get All Tasks
```
GET /tasks
```
Returns a list of all tasks.

**Example Response:**
```json
[
  {
    "id": 1,
    "title": "Buy groceries",
    "description": "Milk and eggs",
    "completed": false
  },
  {
    "id": 2,
    "title": "Learn Spring Boot",
    "description": "Build a REST API",
    "completed": true
  }
]
```

### Get Task by ID
```
GET /tasks/{id}
```
Returns a specific task by ID.

**Example Response (200 OK):**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk and eggs",
  "completed": false
}
```

**Example Response (404 Not Found):**
If task doesn't exist, returns 404 status code.

### Create Task
```
POST /tasks
Content-Type: application/json
```

**Request Body:**
```json
{
  "title": "Buy groceries",
  "description": "Milk and eggs",
  "completed": false
}
```

**Note:** The `completed` field is optional and defaults to `false` if not provided.

**Example Response:**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk and eggs",
  "completed": false
}
```

### Update Task
```
PUT /tasks/{id}
Content-Type: application/json
```

**Request Body:**
```json
{
  "title": "Buy groceries",
  "description": "Milk, eggs, and bread",
  "completed": true
}
```

**Example Response (200 OK):**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, eggs, and bread",
  "completed": true
}
```

**Example Response (404 Not Found):**
If task doesn't exist, returns 404 status code.

### Delete Task
```
DELETE /tasks/{id}
```

**Example Response (200 OK):**
Returns 200 status code with no body if deletion was successful.

**Example Response (404 Not Found):**
If task doesn't exist, returns 404 status code.

## Testing the API

You can test the API using:
- **Thunder Client** (VS Code extension) - Recommended
- **Postman** (Standalone application)
- **cURL** (Command line)
- **Web Browser** (For GET requests only)

### Example Thunder Client/Postman Tests

1. **Create a task**: POST to `http://localhost:8080/tasks` with JSON body
2. **Get all tasks**: GET to `http://localhost:8080/tasks`
3. **Get specific task**: GET to `http://localhost:8080/tasks/1`
4. **Update a task**: PUT to `http://localhost:8080/tasks/1` with JSON body
5. **Delete a task**: DELETE to `http://localhost:8080/tasks/1`

## Project Structure

```
taskmanager/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── andrewdev/
│                   └── taskmanager/
│                       ├── Task.java              # Entity class (database table structure)
│                       ├── TaskRepository.java    # Repository interface (database operations)
│                       └── TaskController.java    # REST controller (API endpoints)
└── pom.xml                                       # Maven configuration
```

## How It Works

1. **Entity (Task.java)**: Defines the structure of a task and maps to a database table
2. **Repository (TaskRepository.java)**: Provides methods to interact with the database (save, find, delete)
3. **Controller (TaskController.java)**: Handles HTTP requests and returns JSON responses

### Request Flow Example

```
Client sends POST /tasks with JSON
    ↓
Spring routes to TaskController.createTask()
    ↓
Spring converts JSON to Task object
    ↓
Controller calls taskRepository.save(task)
    ↓
Repository saves to H2 database
    ↓
Database generates ID and returns saved task
    ↓
Spring converts Task object to JSON
    ↓
Client receives JSON response with the created task
```

## Database

This application uses an **H2 in-memory database**, which means:
- Data is stored in memory (RAM) while the application is running
- All data is lost when the application stops
- Perfect for development and testing
- No installation or configuration required

To use a persistent database (MySQL, PostgreSQL, etc.) in production, you would update the dependencies and configuration in `application.properties`.

## Learning Outcomes

This project demonstrates understanding of:
- RESTful API design principles
- Spring Boot framework
- CRUD operations (Create, Read, Update, Delete)
- HTTP methods (GET, POST, PUT, DELETE)
- JSON request/response handling
- Spring Data JPA and database operations
- Dependency injection with @Autowired
- Entity mapping with JPA annotations
- Maven project structure

## License

This project is open source and available for educational purposes.
