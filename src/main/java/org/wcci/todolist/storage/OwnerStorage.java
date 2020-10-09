package org.wcci.todolist.storage;

import org.springframework.stereotype.Service;
import org.wcci.todolist.models.TodoOwner;

import java.util.*;

@Service
public class OwnerStorage {
    Map<Long, TodoOwner> ownerList = new HashMap<>();

    public OwnerStorage(){

    }

    public void addOwner(TodoOwner ownerToAdd){
        ownerList.put(ownerToAdd.getId(), ownerToAdd);
    }

    public Collection<TodoOwner> retrieveAllOwners() {
        return ownerList.values();
    }

    public TodoOwner retrieveOwnerById(Long id) {
        return ownerList.get(id);
    }
}
