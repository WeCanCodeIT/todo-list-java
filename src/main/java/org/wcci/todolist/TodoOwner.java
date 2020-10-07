package org.wcci.todolist;

import java.util.Collection;

public class TodoOwner {
    private String name;
    private Collection<TodoItem> items;

    public TodoOwner(String name, Collection<TodoItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Collection<TodoItem> getItems() {
        return items;
    }
}
