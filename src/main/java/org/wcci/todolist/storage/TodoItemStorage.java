package org.wcci.todolist.storage;

import org.springframework.stereotype.Service;
import org.wcci.todolist.models.TodoItem;
import org.wcci.todolist.models.TodoOwner;


@Service
public class TodoItemStorage {
    public TodoItem retrieveTodoItemById(long id) {
        return new TodoItem( new TodoOwner("TEsty"),"","Tester","","");
    }
}
