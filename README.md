### Todo RESTful web service ###

Tested on Tomcat 8.0.17. It's a simple maven project, just build and deploy it. You can test by using followings curl commands
```
Add
curl -X "POST" -v http://localhost:8080/restful-todo/api/todos/add -H "Content-Type: application/json" -d '{"title":"my todo", "description":"my desc", "targetdatetime":"2016-10-11 01:01:01", "done": false}'

Search all
curl -X "GET" -v http://localhost:8080/restful-todo/api/todos -H "Content-Type: application/json"

Search by id
curl -X "GET" -v http://localhost:8080/restful-todo/api/todos/1 -H "Content-Type: application/json"

Edit by id
curl -X "PUT" -v http://localhost:8080/restful-todo/api/todos/1/edit -H "Content-Type: application/json" -d '{"title":"my edited todo", "description":"my edited desc", "targetdatetime":"2016-10-11 02:00:00", "done": false}'

Delete by id
curl -X "DELETE" -v http://localhost:8080/restful-todo/api/todos/1/delete -H "Content-Type: application/json"

Delete all
curl -X "DELETE" -v http://localhost:8080/restful-todo/api/todos/delete -H "Content-Type: application/json"
```

You can also view H2 console with URL - http://localhost:8080/restful-todo/console/ by this authentication
```
jdbc url - jdbc:h2:mem:dataSource;SCHEMA=public
username - root
password - password
```