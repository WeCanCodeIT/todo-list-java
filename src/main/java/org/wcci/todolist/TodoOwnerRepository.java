package org.wcci.todolist;

import org.springframework.data.repository.CrudRepository;
import org.wcci.todolist.models.TodoOwner;

public interface TodoOwnerRepository extends CrudRepository<TodoOwner, Long> {
}
