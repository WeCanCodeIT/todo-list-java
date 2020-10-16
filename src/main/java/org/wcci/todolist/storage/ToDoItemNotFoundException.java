package org.wcci.todolist.storage;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
public class ToDoItemNotFoundException extends RuntimeException {
    public ToDoItemNotFoundException(String message) {
        super(message);
    }
}
