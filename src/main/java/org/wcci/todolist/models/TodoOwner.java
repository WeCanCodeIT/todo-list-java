package org.wcci.todolist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class  TodoOwner {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "owner")
    private Collection<TodoItem> items;

    protected TodoOwner(){}

    public TodoOwner(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "TodoOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoOwner todoOwner = (TodoOwner) o;

        if (id != todoOwner.id) return false;
        return name != null ? name.equals(todoOwner.name) : todoOwner.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
