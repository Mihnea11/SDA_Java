# Data Structures - Laboratory

In this laboratory series, we will develop a **Movie Platform** application, which allows users to view and rate movies. The project will evolve as we go through each lab, implementing the data structures and algorithms taught during the sessions. By the end of the course, you will have built a fully functioning application while learning core Java concepts.

Note: While the project completed during laboratory hours will not guarantee a passing grade, it serves as a foundation for the final project, which requires further development beyond lab sessions.

---

## Laboratory Structure

### Lab 1: Introduction
- **Topics**: Java setup, basic syntax.
- **Project Integration**: 
    - Set up the Java environment and create basic classes for the movie platform.
    - Implement an array to store a list of movies, including details like title, genre, and release year.

### Lab 2: Object-Oriented Programming (OOP) Fundamentals
- **Topics**: Classes, inheritance, encapsulation, polymorphism.
- **Project Integration**: 
    - Enhance the project by introducing `Movie` and `User` classes.
    - Implement OOP principles such as inheritance for `AdminUser` and `RegularUser`, and encapsulate movie details.

### Lab 3: Advanced Inheritance
- **Topics**: Constructor overloading, method overriding, abstract classes.
- **Project Integration**:
    - Introduce abstract classes or interfaces for `Media`, allowing future expansion for `Series` or other media types.
    - Override methods for different user types, allowing only admins to add or remove movies.

### Lab 4: Collections in Java
- **Topics**: Lists, Sets, Maps.
- **Project Integration**: 
    - Use Java Collections to manage the movie catalog (`List` of movies) and store user ratings (`Map` for storing user and rating data).

### Lab 5: Exceptions and Generics
- **Topics**: Exception handling, generic types.
- **Project Integration**: 
    - Add exception handling for invalid inputs, such as ratings outside the allowed range.
    - Use generics for managing a variety of rating systems (e.g., star ratings or thumbs up/down).

### Lab 6: Input/Output (I/O) Operations
- **Topics**: File handling, reading/writing CSV files.
- **Project Integration**:
    - Implement file I/O for saving and loading the movie catalog and user ratings to/from CSV files.

### Lab 7: Multithreading
- **Topics**: Java Threads, synchronization.
- **Project Integration**: 
    - Introduce multithreading to allow background tasks, such as downloading movie data from an external API while the user interacts with the app.

### Lab 8: File I/O with JavaFX
- **Topics**: GUI with file I/O.
- **Project Integration**: 
    - Create a JavaFX-based GUI that allows users to browse the movie catalog, view details, and rate movies.

### Lab 9: H2 Database and Spring Framework
- **Topics**: Database integration, Spring Boot.
- **Project Integration**: 
    - Replace the file-based storage system with an H2 database to store movie data and ratings.
    - Use Spring Boot to manage the backend logic and database connections.

### Lab 10: Networking, Messaging, and Apache Frameworks
- **Topics**: Sockets, RabbitMQ, Apache Kafka.
- **Project Integration**:
    - Add networking capabilities to the movie platform, such as allowing users to share movie recommendations or comment on movies using messaging systems like RabbitMQ or Apache Kafka.

---

## Best Coding Practices
- Write clean, modular code with meaningful variable names.
- Avoid circular dependencies in the database design.
- Ensure proper documentation, both within the code (comments) and externally (user manuals, README files).

---

## Final Project Guidelines

### Project Requirements:
1. **Project Proposal**: Define the idea, objectives, and data structures/algorithms to be used.
2. **Core Functionality**: Implement key programming concepts (OOP, data structures, I/O, exception handling).
3. **User Interface**: A functional user interface (e.g., JavaFX) must be present.
4. **File or Database Integration**: Projects using databases will score higher than those using file-based storage.
5. **Threading and Concurrency**: Use threading/concurrency if relevant.
6. **Documentation**: Both code documentation and an external user manual/README are essential.

### Grading Criteria:

1. **Core Functionality and Lab Integration (50%)**:
   - **Mandatory Client-Server Architecture**: The project must implement a client-server architecture. The client and server should communicate over sockets or another networking protocol (e.g., HTTP, WebSockets).
   - **Database Integration**: The server must interact with a database (e.g., H2, MySQL). All data (e.g., user info, app data) must be stored and retrieved from the database. CRUD operations (Create, Read, Update, Delete) must be implemented.
   - **Object-Oriented Programming (OOP)**: Proper use of OOP principles is mandatory:
     - Use of classes and inheritance (e.g., for different user roles or objects).
     - Encapsulation of data and business logic.
     - Polymorphism and method overriding.
   - **Advanced Inheritance and Abstraction**: The project must use abstract classes or interfaces to generalize common functionality (e.g., `Media`, `User`, `Product`, etc.), depending on the project type.
   - **Java Collections**: Proper use of Java collections (e.g., `List`, `Map`, `Set`) to manage data (e.g., catalogs, users, records).
   - **Exception Handling**: Projects must include robust exception handling for client-server communication, invalid inputs, and database interaction.
   - **Generics**: The use of generics where applicable, especially in managing collections or data types, is required.
   - **Multithreading**: The server must support multithreading to handle multiple client requests simultaneously. The client may also use threads for background processes (e.g., fetching data without freezing the UI).
   - **Networking**: The project must implement networking, using sockets or another networking framework (e.g., REST, WebSockets) to allow communication between client and server.

2. **Originality and Creativity (20%)**:
   - While the type of application is flexible, the project must demonstrate creativity in its concept and implementation.
   - Unique features or additional functionalities beyond the core requirements (e.g., real-time updates, data visualizations, custom algorithms) will be rewarded.

3. **User Interface (10%)**:
   - The project must have a functional and intuitive user interface (JavaFX or another framework) that allows users to interact with the application.
   - The UI should provide a clear experience for viewing, modifying, or interacting with the app’s data.
   - Projects with well-designed and responsive GUIs will score higher.

4. **File or Database Integration (10%)**:
   - The project must use a database to store persistent data (e.g., users, products, orders). It is not enough to use file-based storage.
   - The database must be integrated with the server, and the client should communicate with the server to perform data operations.
   - Bonus points will be awarded for using advanced features like relational tables or transactions.

5. **Threading and Concurrency (5%)**:
   - The server must handle multiple clients using multithreading to support concurrent requests.
   - Any background tasks in the client (e.g., fetching data from the server) should not block the user interface.

6. **Documentation (5%)**:
   - Clear and comprehensive documentation, both in the code and external (e.g., README or user manual).
   - The documentation must explain the architecture (client-server), how to set up and run the project, and provide instructions for using the application.
   - Detailed API documentation (if applicable) for client-server communication is recommended.

### Final Project Note:
- **Mandatory Elements**: Every project must include all concepts covered in the lab sessions (client-server architecture, database integration, OOP principles, exception handling, multithreading, networking, and collection usage).
- **Passing Requirement**: The final project must meet all the above criteria to be considered for a passing grade.
- The passing grade for the final project is **5.00**. Any grade below 5.00 (e.g., 4.99 or lower) will not be considered passing.

---

## Important Notes
- All laboratories will be taught using **IntelliJ IDEA**, but you are free to use any other IDE of your choice.
- The project completed during lab sessions will **not** be sufficient for a passing grade. You must continue developing the project outside of lab hours to meet the final project requirements.

## How to Write Effective Documentation

### Documentation Structure
1. **Title Page**:
   - Project name.
   - Your name, date, and course details.

2. **Table of Contents**:
   - A well-structured list of chapters with page numbers or sections.

3. **Introduction**:
   - Brief overview of the project, its purpose, and objectives.
   - Mention technologies and tools used.

4. **Setup Instructions**:
   - Step-by-step instructions for setting up the project.
   - Include prerequisites (e.g., Java version, database requirements, IDE setup).
   - How to run the project (e.g., commands for building and starting the server and client).

5. **Project Architecture**:
   - Description of the architecture (e.g., client-server structure).
   - Diagram or flowchart explaining components and their interactions.

6. **Core Functionality**:
   - Overview of the main features implemented.
   - Explanation of key functionalities (e.g., CRUD operations, threading, networking).

7. **Code Overview**:
   - Explanation of important classes and methods.
   - Highlight key algorithms and their purpose.

8. **Usage Guide**:
   - Instructions on how users can interact with the application.
   - Provide screenshots of the UI (if applicable).

9. **Database Schema**:
   - Diagram of the database schema and relationships.
   - Explanation of tables and their purpose.

10. **Error Handling**:
    - List common errors or exceptions and how they are handled in the code.
    - Provide troubleshooting tips for setup or runtime issues.

11. **API Documentation** (if applicable):
    - List endpoints, HTTP methods, parameters, and example responses.

12. **Testing**:
    - Explanation of how the application was tested (manual or automated).
    - Describe any unit tests or integration tests performed.
    - Include test case examples if applicable.

13. **Conclusion**:
    - Summary of the project, its challenges, and future improvement possibilities.

14. **References**:
    - List of any external libraries, frameworks, or resources used.
    - Links to official documentation or tutorials.
