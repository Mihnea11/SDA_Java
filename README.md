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
- **Originality and Creativity (20%)**: Unique and creative projects beyond the lab examples will score higher.
- **Core Functionality (30%)**: Proper implementation of required features (OOP, data structures, I/O, exception handling).
- **User Interface (15%)**: Intuitive and functional user interfaces will be graded higher.
- **File or Database Integration (15%)**: Projects using databases will be rated higher than those using file systems.
- **Threading and Concurrency (10%)**: Proper use of threading/concurrency enhances performance.
- **Documentation (10%)**: Well-documented code and clear user instructions are crucial.

### Final Project Note:
The passing grade for the final project is **5.00**. Any grade below 5.00 (e.g., 4.99 or lower) will not be considered passing.

---

## Important Notes
- All laboratories will be taught using **IntelliJ IDEA**, but you are free to use any other IDE of your choice.
- The project completed during lab sessions will **not** be sufficient for a passing grade. You must continue developing the project outside of lab hours to meet the final project requirements.
