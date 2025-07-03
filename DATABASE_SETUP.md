# PostgreSQL Setup Guide (Manual)

This guide will help you set up PostgreSQL for the Threads API project on any new machine.

## **1. Install PostgreSQL**

- [Download PostgreSQL](https://www.postgresql.org/download/) and install it.
- Remember your admin password (often `postgres`).

## **2. Create Database and User**

Open the **pgAdmin** GUI or a terminal and run:

```sql
CREATE DATABASE threads;
CREATE USER threadsuser WITH PASSWORD 'threadspass';
GRANT ALL PRIVILEGES ON DATABASE threads TO threadsuser;
```

## **3. Connect to the Database**

From terminal:
```sh
psql -U threads_user -d threads_api
```
Or connect via pgAdmin.

## **4. Create the Tables (Schema)**

Copy and paste the following SQL into your SQL tool (pgAdmin or psql):

```sql
-- USERS TABLE
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- POSTS TABLE
CREATE TABLE posts (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users(id)
);

-- COMMENTS TABLE
CREATE TABLE comments (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users(id),
    post_id BIGINT NOT NULL REFERENCES posts(id)
);

-- LIKES TABLE
CREATE TABLE likes (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    post_id BIGINT NOT NULL REFERENCES posts(id)
);

-- FOLLOWS TABLE
CREATE TABLE follows (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    follower_id BIGINT NOT NULL REFERENCES users(id),
    following_id BIGINT NOT NULL REFERENCES users(id)
);
```

## **5. Update Your `application.properties`**

In your Spring Boot project, set:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/threads_api
spring.datasource.username=threads_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
```

## **6. Start the App and Test**

- Run your Spring Boot app.
- Use the included Postman collection to test endpoints.

## **Default IDs and Passwords**

- **Database name:** `threads_api`
- **User:** `threads_user`
- **Password:** `your_password` (choose your own)
- **Port:** `5432` (default)

