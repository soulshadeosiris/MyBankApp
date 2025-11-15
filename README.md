# Bank Terminal

## Project Description
Bank Terminal is a learning project built with Spring Boot that simulates the functionality of a banking terminal.  
The project allows managing users and their bank cards, generating unique card numbers, and storing information about PIN codes, CCV, and card expiration dates.

## Technologies
- Java 21  
- Spring Boot 3.5.7  
- Spring Data JPA  
- MySQL  
- Maven  
- Jakarta Persistence (JPA)

## Features
- User registration with a unique email  
- Managing user cards:  
  - Generating unique card numbers  
  - Storing PIN code, CCV, and expiration date  
- Relationship between users and cards (OneToMany / ManyToOne)  
- Automatic creation timestamp using `@PrePersist`

## Project Structure
- `Models/` — data models (`User`, `Card`)  
- `Repository/` — database repository interfaces  
- `Service/` — business logic (planned)  
- `Controller/` — handling HTTP requests (planned)

## Entity Examples

### User
| Field      | Type       | Description                       |
|------------|-----------|-----------------------------------|
| id         | long      | Unique identifier                 |
| firstName  | String    | User's first name                 |
| lastName   | String    | User's last name                  |
| email      | String    | Unique email address              |
| password   | String    | User password                     |
| age        | int       | User's age                        |
| cards      | List<Card>| List of user's bank cards         |

### Card
| Field        | Type            | Description                                |
|--------------|----------------|--------------------------------------------|
| id           | long           | Unique identifier                           |
| cardNumber   | long           | Unique card number                           |
| cardType     | String         | Card type (e.g., VISA, MasterCard)         |
| user         | User           | The user who owns the card                  |
| pinCode      | int            | Card PIN code                               |
| expiryDate   | LocalDate      | Card expiration date                         |
| ccv          | int            | Card CCV code                               |
| createdAt    | LocalDateTime  | Timestamp when the card was created (auto) |

## How to Run
1. Clone the repository:  
   ```bash
   git clone <repository URL>
2. Configure the MySQL database connection in src/main/resources/application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/bank_terminal
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true\
3. Build and run the project:
   mvn clean install
   mvn spring-boot:run
4. The application will be available at: http://localhost:8080

### Planned Features
- User authentication and authorization
- Account management and transfers
- Unit and integration tests for models and services
- Frontend integration (optional)

### Note
This project is under development and intended for learning purposes.
