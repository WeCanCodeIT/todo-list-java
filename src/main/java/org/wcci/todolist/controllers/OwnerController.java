package org.wcci.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.todolist.storage.OwnerStorage;

@Controller
public class OwnerController {


    private OwnerStorage ownerStorage;

    public OwnerController(OwnerStorage ownerStorage) {
        this.ownerStorage = ownerStorage;
    }

    @RequestMapping({"", "/"})
    public String displayHomePage(Model model) {
        model.addAttribute("owners", ownerStorage.retrieveAllOwners());
        return "home";
    }

    @RequestMapping("owner/{id}")
    public String displaySingleOwner(Model model, @PathVariable Long id) {
        model.addAttribute("owner", ownerStorage.retrieveOwnerById(id));
        return "user";
    }

}
