package com.spring.boot.rest.api.simple_spring_boot_api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.rest.api.simple_spring_boot_api.models.TodoItem;
import com.spring.boot.rest.api.simple_spring_boot_api.services.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = TodoController.BASE_URL)
public class TodoController {
  public static final String BASE_URL = "/api/v1/todos";

  @Autowired
  private TodoService _TodoService;

  @GetMapping(path = "")
  public ResponseEntity<List<TodoItem>> getTodoItems() {
    List<TodoItem> todoItems = _TodoService.getTodoItems();
    return ResponseEntity.ok(todoItems);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<TodoItem> getTodoItem(@PathVariable int id) {
    TodoItem found = _TodoService.getTodoItemById(id);
    return ResponseEntity.ok(found);
  }

  @PostMapping(path = "")
  public ResponseEntity<TodoItem> createTodoItem(@Valid @RequestBody TodoItem newTodoItem) {
    TodoItem savedTodoItem = _TodoService.saveTodoItem(newTodoItem);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedTodoItem.getId()).toUri();
    return ResponseEntity.created(location).body(newTodoItem);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updateTodoItem(@PathVariable int id, @RequestBody TodoItem newTodoItem) {
    _TodoService.updateTodoItem(id, newTodoItem);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteTodoItem(@PathVariable int id) {
    _TodoService.deleteTodoItem(id);
    return ResponseEntity.noContent().build();
  }
}
