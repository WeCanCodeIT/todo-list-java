package org.wcci.todolist;

import org.springframework.data.repository.CrudRepository;
import org.wcci.todolist.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
}
