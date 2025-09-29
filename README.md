# Student Management REST API 🎓

This is a **Spring Boot** application that implements a RESTful API for managing student and school data, leveraging **Spring Data JPA** for robust and simplified data persistence.

The core concepts demonstrated in this project include:

* **Spring Core & Spring Boot in Action**: Setting up a modern, production-ready Spring application with minimal configuration.
* **Dependency Injection (DI) & Spring Beans**: Utilizing DI for managing components like Controllers, Services, and Repositories.
* **Spring REST**: Building RESTful endpoints (`@RestController`, `@GetMapping`, `@PostMapping`, etc.) for CRUD operations.
* **Spring Data JPA**: Simplifying data access using repositories for entities like `Student` and `School`.
* **DTO Pattern**: Using Data Transfer Objects (`StudentDto`, `StudentResponseDto`, `SchoolDto`) to separate the internal domain model from the external API representation.
* **Service Layer**: Implementing business logic within a dedicated service layer (`StudentService`, `SchoolService`).
* **Spring Data Validation**: Applying JSR-303 annotations (`@Valid`, `@NotEmpty`) for input validation and implementing a global exception handler (`@ExceptionHandler`) for validation errors.
* **Testing**: Overview of testing principles and the use of **Mockito** for unit testing and achieving test isolation.

---

## Project Structure

The main application entry point is:
I see you've added the `StudentProfileController` and updated the `StudentController` and `SchoolController`. I'll update the "API Endpoints" section of your `README.md` to include the new **Student Profile** endpoints and ensure the existing ones are correctly listed based on your code.

Here is the updated **API Endpoints** section for your `README.md`:

***

## API Endpoints

The application exposes the following REST endpoints for managing **Student**, **School**, and **Student Profile** data:

| Resource | HTTP Method | Path | Description |
| :--- | :--- | :--- | :--- |
| **Student** | **POST** | `/student` | Create a new student. (Requires a valid `StudentDto` in the request body) |
| | **GET** | `/student` | Retrieve a list of all students. |
| | **GET** | `/student/{id}` | Retrieve a student by ID. (Uses `@RequestParam` for ID, check implementation) |
| | **GET** | `/student/{name}` | Retrieve students by (partial) first name. (Uses `@RequestParam` for name, check implementation) |
| | **DELETE** | `/student/{id}` | Delete a student by ID. |
| **School** | **POST** | `/schools` | Create a new school. (Requires `School` entity in the request body) |
| | **GET** | `/schools` | Retrieve a list of all schools. |
| | **GET** | `/schools/{id}` | Retrieve a school by ID. |
| | **DELETE** | `/schools/{id}` | Delete a school by ID. |
| **Student Profile** | **POST** | `/student_profile` | Create a new student profile. (Requires `StudentProfile` entity in the request body) |
| | **GET** | `/student_profile` | Retrieve a list of all student profiles. |

***

## Project Structure

The main application entry point is:

```
src/main/java/com/example/demo/DemoApplication.java```

Key components are organized within their respective packages, notably:

    com.example.demo.student: Contains the StudentController, StudentService, DTOs, and mapping logic.

    com.example.demo.school: Contains the SchoolController, SchoolService, and the School entity.



    Java Development Kit (JDK) 17+

    Apache Maven

1. Build the Demo Application

To compile the source code and package the application into a runnable JAR file, use the following Maven command from the project root directory:

```
mvn clean install
```
2. Run the Application

Once built, you can run the Spring Boot application using the generated JAR file (assuming demo-0.0.1-SNAPSHOT.jar):
```java -jar target/demo-0.0.1-SNAPSHOT.jar```
```

java -jar target/demo-0.0.1-SNAPSHOT.jar```

Alternatively, you can use the Spring Boot Maven plugin to run it directly:
Bash
```
mvn spring-boot:run```

The application will typically start on http://localhost:8080.

It looks like you want me to reformat your README content into a proper Markdown file structure, specifically fixing the list items, code blocks, and table structure for easy copy-pasting into a GitHub repository.

Here is the corrected README.md content:
Markdown

# Student Management REST API 🎓

This is a **Spring Boot** application that implements a RESTful API for managing student and school data, leveraging **Spring Data JPA** for robust and simplified data persistence.

The core concepts demonstrated in this project include:

* **Spring Core & Spring Boot in Action**: Setting up a modern, production-ready Spring application with minimal configuration.
* **Dependency Injection (DI) & Spring Beans**: Utilizing DI for managing components like Controllers, Services, and Repositories.
* **Spring REST**: Building RESTful endpoints (`@RestController`, `@GetMapping`, `@PostMapping`, etc.) for CRUD operations.
* **Spring Data JPA**: Simplifying data access using repositories for entities like `Student` and `School`.
* **DTO Pattern**: Using Data Transfer Objects (`StudentDto`, `StudentResponseDto`, `SchoolDto`) to separate the internal domain model from the external API representation.
* **Service Layer**: Implementing business logic within a dedicated service layer (`StudentService`, `SchoolService`).
* **Spring Data Validation**: Applying JSR-303 annotations (`@Valid`, `@NotEmpty`) for input validation and implementing a global exception handler (`@ExceptionHandler`) for validation errors.
* **Testing**: Overview of testing principles and the use of **Mockito** for unit testing and achieving test isolation.


1. Execute All Tests

To run all unit and integration tests defined in the src/test/java directory:
Bash

mvn test

2. Understanding the Tests

Tests cover critical features:

    Service Testing: Testing business logic in StudentService using Mockito to mock dependencies (like StudnetRepositery) to ensure test isolation.

    Controller Testing: Testing REST endpoints to ensure proper request handling, response status codes, and JSON serialization/deserialization.

    Validation Testing: Verifying that the custom exception handling for @Valid annotations works correctly.



