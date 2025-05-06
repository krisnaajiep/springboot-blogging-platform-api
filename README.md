# Spring Boot Blogging Platform API

> Simple Blogging Platform RESTful API built with Spring Boot for a personal blogging platform.

## Table of Contents

- [General Info](#general-information)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [HTTP Response Code](#http-response-code)
- [Project Status](#project-status)
- [Acknowledgements](#acknowledgements)

## General Information

Spring Boot Blogging Platform API is a simple RESTful API
that provides basic CRUD operations for a personal blogging platform.
CRUD stands for Create, Read, Update, and Delete.
This project is designed to explore and practice working with the CRUD Operation,
RESTful API, and database in Spring Boot.

## Technologies Used

- Java 21.0.6 LTS
- Maven 3.9.9
- Microsoft SQL Server 2022
- Spring Boot 3.4.5
- Lombok 1.18.38

## Features

List the ready features here:

- **Create Blog Post**: Create a new blog post using the `POST` method.
- **Get Blog Post**: Get a single blog post using the `GET` method.
- **Get All Blog Posts**: Get all blog posts using the `GET` method.
- **Filter Blog Post**: Filter blog posts by a search term.
- **Update Blog Post**: Update an existing blog post using the `PUT` method.
- **Delete Blog Post**: Delete an existing blog post using the `DELETE` method.

## Setup

To run this API, you’ll need:

* **Java**: Version 21 or higher
* **Maven**: Version 3.x
* **Microsoft SQL Server** 2022 or higher

How to install:

1. Clone the repository

   ```bash
   git clone https://github.com/krisnaajiep/springboot-blogging-platform-api.git
   ```

2. Change the current working directory

   ```bash
   cd springboot-blogging-platform-api
   ```

3. Import the database

   ```bash
   sqlcmd -S <host> -U <username> -P <password> -No -i "db/BloggingPlatformAPI.sql"
   ```

4. Build the project

   ```bash
   mvn clean package
   ```

5. Copy the JAR file from the target/ directory

   ```bash
   cp target/blogging-platform-api-0.0.1-SNAPSHOT.jar blogging-platform-api.jar 
   ```

6. Set environment variables for database configuration

   ```bash
   export DB_HOST=<host>
   export DB_PORT=<port>
   export DB_NAME=BloggingPlatformAPI
   export DB_USERNAME=<username>
   export DB_PASSWORD=<password>
   ```

7. Run the JAR file

   ```bash
   java -jar blogging-platform-api.jar
   ```

## Usage

Example API Endpoints:

1. **Create a Blog Post**

    - Method: `POST`
    - Endpoint: `/posts`
    - Request Body:

        - `title` (string)—The title of the post.
        - `content` (string)—The content of the post.
        - `category` (string)—The category of the post.
        - `tags` (array)—An array of tags associated with the post.

    - Example Request:

      ```http
      POST /posts
      {
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"]
      }
      ```

    - Response:

        - Status: `201 Created`
        - Content-Type: `application/json`

    - Example Response:

      ```json
      {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:00:00Z",
        "updatedAt": "2021-09-01T12:00:00Z"
      }
      ```

2. **Get a Single Post**

    - Method: `GET`
    - Endpoint: `/posts/{id}`
    - Response:

        - Status: `200 OK`
        - Content-Type: `application/json`

    - Example Response:

      ```json
      {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:00:00Z",
        "updatedAt": "2021-09-01T12:00:00Z"
      }
      ```

3. **Get All Blog Posts**

    - Method: `GET`
    - Endpoint: `/posts`
    - Response:

        - Status: `200 OK`
        - Content-Type: `application/json`

    - Example Response:

      ```json
      [
        {
          "id": "1",
          "title": "My Updated Blog Post",
          "content": "This is the updated content of my first blog post.",
          "category": "Technology",
          "tags": ["Tech", "Programming"],
          "created_at": "2025-01-12T17:42:27Z",
          "updated_at": "2025-01-12T17:44:52Z"
        },
        {
          "id": "2",
          "title": "My Second Blog Post",
          "content": "This is the content of my second blog post.",
          "category": "Nature",
          "tags": ["Nature", "Wildlife"],
          "created_at": "2025-01-12T17:42:58Z",
          "updated_at": "2025-01-12T17:42:58Z"
        },
        {
          "id": "3",
          "title": "My Third Blog Post",
          "content": "This is the content of my third blog post.",
          "category": "Urban",
          "tags": ["Urban", "City", "Architecture"],
          "created_at": "2025-01-12T17:43:44Z",
          "updated_at": "2025-01-12T17:43:44Z"
        },
        {
          "id": "4",
          "title": "My Fourth Blog Post",
          "content": "This is the content of my fourth blog post.",
          "category": "Nature",
          "tags": ["Nature", "Mountain", "Hiking"],
          "created_at": "2025-01-12T17:44:28Z",
          "updated_at": "2025-01-12T17:44:28Z"
        }
      ]
      ```

    - Params:
        - `term` - Search keyword for post by title, content, category, or tags.

4. **Update an Existing Blog Post**

    - Method: `PUT`
    - Endpoint: `/posts/{id}`
    - Request Body:

        - `title` (string)—The title of the post.
        - `content` (string)—The content of the post.
        - `category` (string)—The category of the post.
        - `tags` (array)—An array of tags associated with the post.

    - Example Request:

      ```http
      PUT /posts/1
      {
         "title": "My Updated Blog Post",
         "content": "This is the updated content of my first blog post.",
         "category": "Technology",
         "tags": ["Tech", "Programming"]
      }
      ```

    - Response:

        - Status: `200 OK`
        - Content-Type: `application/json`

    - Example Response:

      ```json
      {
        "id": 1,
        "title": "My Updated Blog Post",
        "content": "This is the updated content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2021-09-01T12:00:00Z",
        "updatedAt": "2021-09-01T12:30:00Z"
      }
      ```

5. **Delete an Existing Blog Post**

    - Method: `DELETE`
    - Endpoint: `/posts/{id}`
    - Response:

        - Status: `204 No Content`
        - Content-Type: `text/xml`

## HTTP Response Code

The API returns the following status codes depending on the success or failure of the request.

| Status Code               | Description                                               |
|---------------------------|-----------------------------------------------------------|
| 200 OK                    | The request was processed successfully.                   |
| 201 Created               | The new resource was created successfully.                |
| 400 Bad Request           | The server cannot process a request due to a client error |
| 404 Not Found             | The requested resource was not found.                     |
| 500 Internal Server Error | An unexpected server error occurred.                      |

## Project Status

Project is: _complete_.

## Acknowledgements

This project was inspired by [roadmap.sh](https://roadmap.sh/projects/blogging-platform-api).
