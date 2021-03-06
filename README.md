# Simple Time Clock App

A Java16 SpringBoot RESTful API for tracking time. It uses mongodb for storage.

## How to build & run

If on unix-based system (with docker installed), you can run the app with the following command to build & start the containerized application:

```
# On root dir
sh ./scripts/build.sh && docker-compose up -d

```

This will expose the application on port 8080. It is likely that starting the application might throw an exception at startup. This is because the mongodb takes a little longer to start up, shouldn't cause any issues.

### Windows users

Alternatively, you can run the app from your IDE but this requires you to have a mongodb server running on your local machine by default (port 27017). If you'd like to specify a different mongodb uri, you can do so in the `application.properties` file or by setting an env variable `spring.data.mongodb.uri`.

If you do have docker installed, you could also run mongo locally with the following command:

```
docker run -d -p 27017:27017 --name mongodb mongo
```

Starting the application should now connect to the containerized mongodb server & everything should work.

## API Endpoints

The application has two main endpoints: `/api/shift` & `/api/employee`.

### Shift Endpoint

    - GET `/api/shift/`: returns all shifts in the database.
    - GET `/api/shift/employee/{id}`: returns all shifts belonging to the employee with the given id.
    - GET `/api/shift/{id}`: returns the shift with the given id.
    - POST `/api/shift/in/{id}`: creates a new shift for the provided employee id.
    - POST `/api/shift/out/{id}`: ends the shift for the provided employee id.

### Employee Endpoint

    - GET `/api/employee/`: returns all employees in the database.
    - GET `/api/employee/{id}`: returns the employee with the given id.
    - POST `/api/employee/`: creates a new employee, requires json body with `firstName` and `lastName` fields.
