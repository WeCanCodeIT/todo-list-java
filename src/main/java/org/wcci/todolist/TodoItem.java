package org.wcci.todolist;

public class TodoItem {

    private TodoOwner owner;
    private String title;
    private String urgency;
    private String requester;
    private String description;


    public TodoItem(TodoOwner owner, String title, String urgency, String requester, String description) {
        this.owner = owner;
        this.title = title;
        this.urgency = urgency;
        this.requester = requester;
        this.description = description;
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
}
