# Task Manager API

A RESTful API built with Spring Boot for managing tasks. This project demonstrates CRUD operations, REST principles, and Spring Data JPA integration with PostgreSQL database.

## 🛠️ Technologies Used

- Java 25
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA (Database operations)
- PostgreSQL (Relational database)
- Maven (Project management)

## ✨ Features

- Create new tasks
- Retrieve all tasks or a specific task by ID
- Update existing tasks
- Delete tasks
- Auto-generated task IDs
- JSON request/response format
- RESTful API design
- Persistent data storage with PostgreSQL
- Proper HTTP status code handling (200, 400, 404)

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven (included via Maven Wrapper)
- PostgreSQL installed locally OR access to a cloud PostgreSQL database

### Database Setup

1. Install PostgreSQL on your machine (or use a cloud service like Railway, Supabase, or Render)

2. Create a database for the application:
   - Open PostgreSQL command line or pgAdmin
   - Create a new database named 'taskmanager' (or your preferred name)

3. Configure the database connection:
   - Open src/main/resources/application.properties
   - Update the following properties with your database credentials:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/Andy916/task-manager.git
cd task-manager
```

2. Set up your database configuration (see Database Setup above)

3. Run the application:
```bash
./mvnw spring-boot:run
```

4. The API will be available at: `http://localhost:8080`

### Stopping the Application

Press `Ctrl + C` in the terminal, then confirm to terminate the batch job.

## 📡 API Endpoints

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

**Example Response (200 OK):**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk and eggs",
  "completed": false
}
```

**Example Response (400 Bad Request):**
If the request body is invalid, returns 400 status code.

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

**Example Response (400 Bad Request):**
If the request body is invalid, returns 400 status code.

### Delete Task
```
DELETE /tasks/{id}
```

**Example Response (200 OK):**
Returns 200 status code with no body if deletion was successful.

**Example Response (404 Not Found):**
If task doesn't exist, returns 404 status code.

## 🧪 Testing the API

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

## 📁 Project Structure

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

## 🔄 How It Works

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
Repository saves to PostgreSQL database
    ↓
Database generates ID and returns saved task
    ↓
Spring converts Task object to JSON
    ↓
Client receives JSON response with the created task
```

## 💾 Database

This application uses **PostgreSQL** as its relational database, which means:
- Data persists between application restarts
- Production-ready database system
- Scalable and reliable for real-world applications
- Supports advanced SQL features

The application uses Spring Data JPA with Hibernate to handle database operations, automatically creating and managing the task table schema.

## 📚 Learning Outcomes

This project demonstrates understanding of:
- RESTful API design principles
- Spring Boot framework
- CRUD operations (Create, Read, Update, Delete)
- HTTP methods (GET, POST, PUT, DELETE)
- Proper HTTP status code handling
- JSON request/response handling
- Spring Data JPA and database operations
- PostgreSQL database integration
- Dependency injection with @Autowired
- Entity mapping with JPA annotations
- Maven project structure

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.