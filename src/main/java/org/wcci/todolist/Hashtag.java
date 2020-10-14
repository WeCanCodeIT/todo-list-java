package org.wcci.todolist;

import org.wcci.todolist.models.TodoItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    private Collection<TodoItem> todoItems;

    protected Hashtag(){}

    public Hashtag(String name, TodoItem... todoItems) {

        this.name = name;
        this.todoItems = List.of(todoItems);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<TodoItem> getTodoItems() {
        return todoItems;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != null ? !id.equals(hashtag.id) : hashtag.id != null) return false;
        return name != null ? name.equals(hashtag.name) : hashtag.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
