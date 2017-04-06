/*
 * Copyright 2017 Thitipong Jampajeen <jampajeen@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.volho.example.todo.web.controller;

import com.volho.example.todo.web.model.entity.Todo;
import com.volho.example.todo.web.model.api.ApiResponse;
import com.volho.example.todo.web.service.TodoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
@Controller
@RequestMapping("api")
public class TodoController {
    private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);
    
    @Autowired
    TodoService todoService;
    
    @RequestMapping(value = "/todos/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse add(@RequestBody Todo todo) {
        
        ApiResponse response = new ApiResponse();
        try {
            Todo newTodo = todoService.addTodo(todo);
            response.setData(newTodo);
            response.setSuccess(true);
            response.setMessage("Add item successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot add an item.");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos/{id}/edit", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse editById(@PathVariable Long id, @RequestBody Todo todo) throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            todo.setId(id);
            Todo item = todoService.editTodo(todo);
            response.setData(item);
            response.setSuccess(true);
            response.setMessage("Edit item successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot edit an item id = " + id);
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos/{id}/status", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse setStatusById(@PathVariable Long id, @RequestBody Todo todo) throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            Todo item = todoService.setStatus(id, todo.getStatus());
            response.setData(item);
            response.setSuccess(true);
            response.setMessage("Update item status successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot update status of an item id = " + id);
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos/delete", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse deleteAll() throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            todoService.deleteTodo();
            response.setSuccess(true);
            response.setMessage("Delete items successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot delete items");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos/{id}/delete", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse deleteById(@PathVariable Long id) throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            todoService.deleteTodo(id);
            response.setSuccess(true);
            response.setMessage("Delete item successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot delete an item id = " + id);
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse searchAll() throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            List<Todo> items = todoService.findTodo();
            response.setData(items);
            response.setSuccess(true);
            response.setMessage("Search items successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot find items.");
        }
        
        return response;
    }
    
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ApiResponse searchById(@PathVariable Long id) throws Exception {
        
        ApiResponse response = new ApiResponse();
        try {
            Todo item = todoService.findTodo(id);
            response.setData(item);
            response.setSuccess(true);
            response.setMessage("Search item successfully");
            
        } catch(Exception e) {
            response.setSuccess(false);
            response.setMessage("Error occur, cannot find an item id = "+ id);
        }
        
        return response;
    }
}
