package org.wcci.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.todolist.storage.TodoItemStorage;

@Controller
public class TodoItemController {

    private TodoItemStorage todoItemStorage;

    public TodoItemController(TodoItemStorage todoItemStorage){

        this.todoItemStorage = todoItemStorage;
    }

    @RequestMapping("todo-item/{id}")
    public String showTodoItem(Model model, @PathVariable long id){

        model.addAttribute("todoItem", todoItemStorage.retrieveTodoItemById(id));

        return "todo-item-template";
    }

}
