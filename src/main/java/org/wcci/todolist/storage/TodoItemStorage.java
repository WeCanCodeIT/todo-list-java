package org.wcci.todolist.storage;

import org.springframework.stereotype.Service;
import org.wcci.todolist.TodoItemRepository;
import org.wcci.todolist.models.TodoItem;
import org.wcci.todolist.models.TodoOwner;

import java.util.Optional;


@Service
public class TodoItemStorage {

    private TodoItemRepository todoItemRepo;

    public TodoItemStorage(TodoItemRepository todoItemRepo) {
        this.todoItemRepo = todoItemRepo;
    }

    public void addItem(TodoItem itemToAdd){
        todoItemRepo.save(itemToAdd);
    }

    public Iterable<TodoItem> retrieveAllItems(){
        return todoItemRepo.findAll();
    }

    public TodoItem retrieveTodoItemById(long id) {

        Optional<TodoItem> retrievedOptional = todoItemRepo.findById(id);

        if(retrievedOptional.isEmpty()){
            throw new ToDoItemNotFoundException("The todo item with id "+ id + " was not found.");
        }

        return retrievedOptional.get();
    }
}
