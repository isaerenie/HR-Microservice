## Spring Boot Hr App
I have developed this REST API for an Hr application. This API performs fundamental CRUD operations for Hr department.
## Diagram for the application
## Configuration table
|  Components |  Technology |
| ------------ | ------------ |
| Backend |  Openapi |
|  Database | JPA-Hibernate,MySQL |
| API Documentation  |  Postman |
|  Server Build | Gradle  |
| API testing  |  POSTMAN  |
|  Tool | Intellj Idea/VSC
## Installation & Run
Before running the API server, you should update the database config inside the application.properties file.
Update the port number, username and password as per your local database config.

```yaml
server.port=8090

#datasource configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/enoca_db
spring.datasource.username=root
spring.datasource.password=

# jpa configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


# /api-docs endpoint custom path
springdoc.api-docs.path=/api-docs

```
## API Root Endpoint
    http://localhost:8090/
	http://localhost:8009/swagger-ui/index.html#/
## API Module Endpoints
### Personel Module

```yaml
GET /api/employee :Gets all employees
PUT /api/employee :Update employee
POST /api/employee:Save new employee
GET /api/employee/{id}: Find employee
DELETE /api/employee/{id}: Delete employee
```
### Company Module

```yaml
GET /api/company :Gets all companies
PUT /api/company :Update company
POST /api/company:Save new company
GET /api/company/{id}: Find company
DELETE /api/company/{companyId}: Delete company
```
## Sample API Response for Customer Login

POST   http://localhost:8090/api/employee

**- Request Body**
```json
{
    "name": "John",
    "surname": "Doe",
    "email": "john.doe@example.com",
    "company": {
        "companyId": 2,
        "name": "Eren A.Ş",
        "address": "Atatürk Bulvarı"
    }
}
```
**- Response**

```json
{
    "message": "Employee saved successfully",
    "status": "SUCCESS",
    "code": "200",
    "details": {
        "employee": {
            "id": 2,
            "name": "John",
            "surname": "Doe",
            "email": "john.doe@example.com",
            "company": {
                "companyId": 2,
                "name": "Eren A.Ş",
                "address": "Atatürk Bulvarı"
            }
        }
    }
}
```
