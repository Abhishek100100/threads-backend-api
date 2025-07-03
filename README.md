# Threads Backend API

Threads API — a modern, full-featured backend for a social microblogging platform, inspired by apps like Threads and Twitter.  
This project is built with **Spring Boot**, **PostgreSQL**, and **JPA/Hibernate**.  
It supports users, posts, comments, likes, follows, and all the relationships you’d expect in a real-world social network.

##  Features

- **User Management**: Register, update, and delete users.
- **Posts**: Create, read, update, and delete posts linked to users.
- **Comments**: Comment on posts, with full user and post linkage.
- **Likes**: Like posts (with user and post relationships).
- **Follows**: Follow/unfollow other users.
- **Robust Data Integrity**: All relationships are enforced by foreign keys and NOT NULL constraints.
- **Seeder**: Automatic database seeding with demo data.
- **Ready-to-import Postman Collection**: For instant API testing.

##  Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Postman** (for API testing)

##  Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/threads-backend-api.git
cd threads-backend-api
```

### 2. Configure the Database

- Ensure PostgreSQL is running.
- Create a database (e.g., `threads_api`).
- Update your `src/main/resources/application.properties`:

  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/threads_api
  spring.datasource.username=your_db_user
  spring.datasource.password=your_db_password
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3. Build and Run

```bash
mvn clean package
java -jar target/threads-api-0.0.1-SNAPSHOT.jar
```

The API will start at [http://localhost:8080](http://localhost:8080).

##  API Testing

- Import the provided Postman collection (`threads-api-final.postman_collection.json`) into Postman.
- All endpoints are ready to test, with sample bodies for each entity.
- Make sure to use valid IDs for relationships (e.g., `user: { "id": 2 }`).

##  Database Schema

- All tables (`users`, `posts`, `comments`, `likes`, `follows`) are fully normalized.
- Foreign key constraints and NOT NULL rules prevent orphaned or invalid data.
- Timestamps (`created_at`) are set automatically in the backend.

##  Data Seeding

- On first run, the app seeds the database with demo users, posts, comments, likes, and follows.
- Seeder logic is idempotent: no duplicate data on restart.

##  Security & Production Notes

- **Authentication**: Not yet implemented (JWT login is a great next step!).
- **Production config**: Disable `ddl-auto=update` and use migrations for real deployments.
- **Never commit real passwords or secrets.**

##  Roadmap & Next Steps

- Add JWT-based authentication and authorization
- Pagination and filtering for large datasets
- User profile endpoints and avatars
- Notification system for likes/comments/follows
- API documentation with Swagger/OpenAPI
- Frontend integration (React, Vue, etc.)

## 🤝 Contributing

Pull requests and issues are welcome!  
If you find a bug or want to add a feature, open an issue or submit a PR.

*Made with ☕, Spring Boot, and a lot of debugging!*
