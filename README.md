### Todo RESTful web service ###

##### Available operations #####
- Add Todo (`POST /restful-todo/api/todos/add`)
- Search all todo (`GET /restful-todo/api/todos`)
- Search todo by Id (`GET /restful-todo/api/todos/:id`)
- Edit todo by Id (`PUT /restful-todo/api/todos/:id/edit`)
- Update todo status by Id (`PUT /restful-todo/api/todos/:id/status`)
- Delete todo by Id (`DELETE /restful-todo/api/todos/:id/delete`)
- Delete all todos (`DELETE /restful-todo/api/todos/delete`)



Tested on Tomcat 8.0.17. It's a simple maven project, just clone the project, build and deploy it.

You can use this command to build war package

```
mvn clean install
```
Then use this output war file to deploy

```
target/restful-todo-0.1.war 
```

 After you deploy the application, you can do a quick test by using followings curl commands

```

#Add
curl -X "POST" -v http://localhost:8080/restful-todo/api/todos/add -H "Content-Type: application/json" -d '{"subject":"my todo", "detail":"my desc", "targetdatetime":"2016-10-11 01:01:01", "status": "pending"}'

#Search all
curl -X "GET" -v http://localhost:8080/restful-todo/api/todos -H "Content-Type: application/json"

#Search by id
curl -X "GET" -v http://localhost:8080/restful-todo/api/todos/1 -H "Content-Type: application/json"

#Edit by id
curl -X "PUT" -v http://localhost:8080/restful-todo/api/todos/1/edit -H "Content-Type: application/json" -d '{"subject":"my edited todo", "detail":"my edited desc", "targetdatetime":"2016-10-11 02:00:00", "status": "pending"}'

#Update status by id
curl -X "PUT" -v http://localhost:8080/restful-todo/api/todos/1/status -H "Content-Type: application/json" -d '{"status":"done"}'

#Delete by id
curl -X "DELETE" -v http://localhost:8080/restful-todo/api/todos/1/delete -H "Content-Type: application/json"

#Delete all
curl -X "DELETE" -v http://localhost:8080/restful-todo/api/todos/delete -H "Content-Type: application/json"
```

Here is full API reference page
https://github.com/jampajeen/restful-todo/blob/master/restapi.rst


You can also view H2 console with URL - http://localhost:8080/restful-todo/console/ by this authentication
```
jdbc url - jdbc:h2:mem:dataSource;SCHEMA=public
username - root
password - password
```