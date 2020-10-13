package org.wcci.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.todolist.models.TodoItem;
import org.wcci.todolist.storage.OwnerStorage;
import org.wcci.todolist.models.TodoOwner;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {


    private OwnerStorage ownerStorage;

    public Populator(OwnerStorage ownerStorage){

        this.ownerStorage = ownerStorage;


    }


    @Override
    public void run(String... args) throws Exception {

        Collection<TodoItem> bensTodos = new ArrayList<>();

        TodoOwner ben = new TodoOwner("Ben");
        TodoOwner bruce = new TodoOwner("Bruce");
        TodoOwner bosco = new TodoOwner("Bosco");
        TodoOwner amy = new TodoOwner("Amy");
        TodoOwner cliff = new TodoOwner("Cliff");

        bensTodos.add(new TodoItem(ben, "Clean Dishes", "Today", "Amy", "Clean the dishes in the sink."));
        ownerStorage.addOwner(ben);
        ownerStorage.addOwner(bruce);
        ownerStorage.addOwner(bosco);
        ownerStorage.addOwner(amy);
        ownerStorage.addOwner(cliff);
    }
}
