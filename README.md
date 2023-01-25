# springboot-starter-project
 Spring Boot Starter Project With MySQL Database

# Tools
 - Spring Boot 2.7.8
 - MySQL Database
 - Spring JPA
 - Model Mapper 3.1.0

# Running Project
  mvn spring-boot:run

# List of Endpoints
 - Get All Employees  
    GET http://localhost:8080/api/employees  
 - Get Single Employee  
    GET http://localhost:8080/api/employees/{employeeId}  
 - Create An Employee  
    URL: POST http://localhost:8080/api/employees  
    Payload:  
      {  
        "firstName":"test",  
        "lastName":"delete",  
        "email":"test.delete@gmail.com"  
      }  
 - Delete Employee  

