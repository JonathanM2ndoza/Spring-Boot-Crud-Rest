# Spring-Boot-Crud-Rest

Example of RESTful API with Spring Boot. Basic logging, JPA and MySQL.  

## REST and RESTful

- Representational state transfer (REST) is a style of software architecture. As described in a dissertation by Roy Fielding, REST is an "architectural style" that basically exploits the existing technology and protocols of the Web.

- RESTful is typically used to refer to web services implementing such an architecture.

### Start a mysql server instance with Docker Hub

jmendoza@jmendoza-ThinkPad-T420:~$ docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=root.jmtizure.k201 mysql

![Screenshot](/prtsc/RESTful-API-11.png)

### Check the ip of your container and update the application.properties file

jmendoza@jmendoza-ThinkPad-T420:~$ docker inspect mysql

![Screenshot](/prtsc/RESTful-API-11.1.png)

![Screenshot](/prtsc/RESTful-API-11.2.png)

![Screenshot](/prtsc/RESTful-API-11.3.png)


### Running Spring Boot with IntelliJ

![Screenshot](/prtsc/RESTful-API-1.png)

### Request (POST) /api/v1/users for Create User with Postman

![Screenshot](/prtsc/RESTful-API-2.png)

### DB MySQL

![Screenshot](/prtsc/RESTful-API-2.1.png)

### Request (GET) /api/v1/users/id for find with Postman

![Screenshot](/prtsc/RESTful-API-3.png)

### Request (PUT) /api/v1/users/id for update with Postman

![Screenshot](/prtsc/RESTful-API-4.png)

### DB MySQL

![Screenshot](/prtsc/RESTful-API-4.1.png)

### Request (GET) /api/v1/users/ for find all users with Postman

![Screenshot](/prtsc/RESTful-API-5.png)

### DB MySQL

![Screenshot](/prtsc/RESTful-API-5.1.png)

### Request (DELETE) /api/v1/users/id for delete with Postman

![Screenshot](/prtsc/RESTful-API-6.png)

![Screenshot](/prtsc/RESTful-API-6.1.png)

### DB MySQL

![Screenshot](/prtsc/RESTful-API-6.2.png)

### Create a new user and create vehicle

![Screenshot](/prtsc/RESTful-API-7.png)

![Screenshot](/prtsc/RESTful-API-7.1.png)

![Screenshot](/prtsc/RESTful-API-7.2.png)

![Screenshot](/prtsc/RESTful-API-7.3.png)

DB MySQL

![Screenshot](/prtsc/RESTful-API-7.4.png)

### Get vehicles

![Screenshot](/prtsc/RESTful-API-8.png)

### Get a person's vehicles

![Screenshot](/prtsc/RESTful-API-9.png)

### Get a person's vehicles by User Id and Vehicle Id

![Screenshot](/prtsc/RESTful-API-10.png)

DB MySQL

![Screenshot](/prtsc/RESTful-API-7.4.png)

![Screenshot](/prtsc/RESTful-API-7.1.png)







