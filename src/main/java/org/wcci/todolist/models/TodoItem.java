package org.wcci.todolist.models;


import org.wcci.todolist.Hashtag;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private TodoOwner owner;
    private String title;
    private String urgency;
    private String requester;
    private String description;
    @ManyToMany(mappedBy = "todoItems")
    private Collection<Hashtag> hashtags;

    protected TodoItem(){}

    public TodoItem(TodoOwner owner, String title, String urgency, String requester, String description) {
        this.owner = owner;
        this.title = title;
        this.urgency = urgency;
        this.requester = requester;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public TodoOwner getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getRequester() {
        return requester;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", owner=" + owner +
                ", title='" + title + '\'' +
                ", urgency='" + urgency + '\'' +
                ", requester='" + requester + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != todoItem.id) return false;
        if (owner != null ? !owner.equals(todoItem.owner) : todoItem.owner != null) return false;
        if (title != null ? !title.equals(todoItem.title) : todoItem.title != null) return false;
        if (urgency != null ? !urgency.equals(todoItem.urgency) : todoItem.urgency != null) return false;
        if (requester != null ? !requester.equals(todoItem.requester) : todoItem.requester != null) return false;
        return description != null ? description.equals(todoItem.description) : todoItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (urgency != null ? urgency.hashCode() : 0);
        result = 31 * result + (requester != null ? requester.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
