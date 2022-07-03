# Spring-8-User-RestAPI

<br>

#### The following is a Users Rest API 
#### Language: Java
#### Version: 8
#### Framework: Spring Boot
#### Dependency Management: Maven
#### Database used: MySQL

<br>
<br>

### API 

|  Endpoints 	|  Usage 	|   Request  |	Url  |	
|---	|---	|---	| ---	|
|   1	|  Create New User 	|   POST	| 	http://localhost:8080/api/users |
|   2	|   Get all Users	|   GET	| 	http://localhost:8080/api/users  |
|   3	|   Update User 	|  PUT 	| 	http://localhost:8080/api/users/{id}  |
|   4	|   Delete User	|   DELETE	| 	http://localhost:8080/api/users/{id}  |
|   5	|   Get Users by company	|  GET 	| 	http://localhost:8080/api/users?company={company_name}  |

<br>
<br>

#### Important Directories

Model - src/main/java/com/example/demo/model
<br>
Controller - src/main/java/com/example/demo/Controller
<br>
UserRepository - src/main/java/com/example/demo/Repo
<br>
Configuration - pom.xml

<br>
<br>

#### How to Install and Run (It is assumed that you already have Java, MAven and Mysql installed)
`
git clone https://github.com/Panoskontos/Spring-8-User-RestAPI.git
`

`
cd Spring-8-User-RestAPI/
`
`
mvn spring-boot:run
`
