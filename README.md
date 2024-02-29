

# Spring Boot CRUD application using JPA and H2 Database

>RestControllers

> Dao Layer as JPA

> H2 As Database


## Run the Application

- Run mvn clean to clean and load all the dependencies needed.
- mvn spring-boot:run




---

## Features
  CRUD operations for Tasks


---

## Steps to test and Run the application

> To get started...


### Step 1: 
    Resigter the user by calling Register API (localhost:9091/register)
### Step 2: 
    Authenticate the user by calling Authenticate API(localhost:9091/authenticate)
    you will recieve jwt token as response
### Step 3: 
    pass the jwt token into authorization section as a bearer token
    Create the task by calling Create Task API(localhost:9091/api/tasks)
### Step 4: 
    pass the jwt token into authorization section as a bearer token
    List all the tasks created the user by calling API(localhost:9091/api/tasks)
### Step 5: 
    pass the jwt token into authorization section as a bearer token
    Update the task by providing a vaild ID to the update API(localhost:9091/api/tasks/1)
### Step 6:
    pass the jwt token into authorization section as a bearer token
    Delete the task by providing a vaild ID to the delete API(localhost:9091/api/tasks/1)

