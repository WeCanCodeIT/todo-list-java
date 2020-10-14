package org.wcci.todolist.storage;

import org.springframework.stereotype.Service;
import org.wcci.todolist.TodoOwnerRepository;
import org.wcci.todolist.models.TodoOwner;

import java.util.Optional;

@Service
public class OwnerStorage {

    private TodoOwnerRepository todoOwnerRepo;

    public OwnerStorage(TodoOwnerRepository todoOwnerRepo) {
        this.todoOwnerRepo = todoOwnerRepo;
    }

    public void addOwner(TodoOwner ownerToAdd) {
        todoOwnerRepo.save(ownerToAdd);
    }


    public Iterable<TodoOwner> retrieveAllOwners() {
        return todoOwnerRepo.findAll();
    }

    public TodoOwner retrieveOwnerById(Long id) {
        Optional<TodoOwner> retrievedTodoOwnerOptional = todoOwnerRepo.findById(id);
        if (retrievedTodoOwnerOptional.isPresent()) {
            TodoOwner retrievedTodoOwner = retrievedTodoOwnerOptional.get();
            return retrievedTodoOwner;
        } else {
            return null;
        }
    }
}
