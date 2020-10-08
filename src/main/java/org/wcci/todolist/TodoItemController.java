package org.wcci.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class TodoItemController {

    @RequestMapping("sample-todo-item")
    public String showOneTodoItem(Model model){
        TodoOwner sampleTodoOwner = new TodoOwner("Bosco", Collections.EMPTY_LIST, 1L);
        TodoItem sampleTodoItem = new TodoItem(sampleTodoOwner, "Go outside and bark", "Urgent", "Self", "Go outside to bark at squirrels");

        model.addAttribute("todoItem", sampleTodoItem);

        return "todo-item-template";
    }

}
