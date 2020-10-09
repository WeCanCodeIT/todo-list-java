package org.wcci.todolist.models;

import org.wcci.todolist.models.TodoItem;

import java.util.Collection;

public class TodoOwner {
    private long id;
    private String name;
    private Collection<TodoItem> items;

    public TodoOwner(String name, Collection<TodoItem> items, long id) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public Collection<TodoItem> getItems() {
        return items;
    }
}
