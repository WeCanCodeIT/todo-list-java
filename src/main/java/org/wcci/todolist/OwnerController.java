package org.wcci.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class OwnerController {
    Map<Long, TodoOwner> ownerList = new HashMap<>();

    public OwnerController() {


        Collection<TodoItem> bensTodos = new ArrayList<>();

        TodoOwner ben = new TodoOwner("Ben", bensTodos, 1);
        TodoOwner bruce = new TodoOwner("Bruce", Collections.EMPTY_LIST, 2);
        TodoOwner bosco = new TodoOwner("Bosco", Collections.EMPTY_LIST, 3);
        TodoOwner amy = new TodoOwner("Amy", Collections.EMPTY_LIST, 4);

        bensTodos.add(new TodoItem(ben, "Clean Dishes", "Today", "Amy", "Clean the dishes in the sink."));

        ownerList.put(ben.getId(), ben);
        ownerList.put(bruce.getId(), bruce);
        ownerList.put(bosco.getId(), bosco);
        ownerList.put(amy.getId(), amy);
    }


    @RequestMapping({"", "/"})
    public String displayHomePage(Model model) {
        model.addAttribute("owners", ownerList.values());
        return "home";
    }

    @RequestMapping("owner/{id}")
    public String displaySingleOwner(Model model, @PathVariable Long id) {
        model.addAttribute("owner", ownerList.get(id));
        return "user";
    }


}
