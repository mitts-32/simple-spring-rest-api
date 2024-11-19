package com.spring.boot.rest.api.simple_spring_boot_api.services;

import java.util.List;

import com.spring.boot.rest.api.simple_spring_boot_api.models.TodoItem;

public interface TodoService {
  public TodoItem saveTodoItem(TodoItem todoItem);

  public List<TodoItem> getTodoItems();

  public TodoItem getTodoItemById(int id);

  public TodoItem updateTodoItem(int id, TodoItem todoItem);

  public void deleteTodoItem(int id);
}