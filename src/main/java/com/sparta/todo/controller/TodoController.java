package com.sparta.todo.controller;

import com.sparta.todo.dto.TodoRequest;
import com.sparta.todo.dto.TodoResponse;
import com.sparta.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/api/todos")
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest request) {
        TodoResponse response = todoService.createTodo(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/todos/{Id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable long Id) {
        TodoResponse response = todoService.getTodo(Id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/todos")
    public ResponseEntity<List<TodoResponse>> getTodos(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String managerName
    ) {
        List<TodoResponse> response = todoService.getTodos(date, managerName);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/todos/{Id}")
    public ResponseEntity<TodoResponse> updateTodo(
            @PathVariable long Id,
            @RequestBody TodoRequest request
    ) {
        TodoResponse response = todoService.updateTodo(Id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/todos/{Id}")
    public void deleteTodo(
            @PathVariable long Id,
            @RequestBody TodoRequest request
    ) {
        todoService.deleteTodo(Id, request);
    }
}