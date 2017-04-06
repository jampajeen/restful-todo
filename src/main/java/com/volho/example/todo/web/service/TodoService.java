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
package com.volho.example.todo.web.service;

import com.volho.example.todo.web.model.api.StatusEnum;
import com.volho.example.todo.web.model.entity.Todo;
import com.volho.example.todo.web.repository.TodoRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thitipong Jampajeen <jampajeen@gmail.com>
 */
@Service
public class TodoService {
    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);
    
    @Autowired
    private TodoRepository todoRepository;
    
    public Todo addTodo(Todo todo) throws Exception {
        return todoRepository.save(todo);
    }
    
    public void deleteTodo(Long id) throws Exception {
        todoRepository.delete(id);
    }
    
    public void deleteTodo() throws Exception {
        todoRepository.deleteAll();
    }
    
    public Todo editTodo(Todo todo) throws Exception {
        if(todoRepository.findOne(todo.getId()) == null ) {
            throw new Exception();
        }
        return todoRepository.save(todo);
    }
    
    public Todo setStatus(Long id, String status) throws Exception {
        Todo found = null;
        if( (!StatusEnum.PENDING.value().equals(status) && !StatusEnum.DONE.value().equals(status)) || (found = todoRepository.findOne(id) ) == null ) {
            throw new Exception();
        }
        
        found.setStatus(status);
        return todoRepository.save(found);
    }
    
    public List<Todo> findTodo() throws Exception {
        return todoRepository.findAll();
    }
    
    public Todo findTodo(Long id) throws Exception {
        Todo found = null;
        if( (found = todoRepository.findOne(id) ) == null ) {
            throw new Exception();
        }
        return found;
    }
    
}
