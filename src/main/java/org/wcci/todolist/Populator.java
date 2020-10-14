package org.wcci.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.todolist.models.TodoItem;
import org.wcci.todolist.storage.OwnerStorage;
import org.wcci.todolist.models.TodoOwner;
import org.wcci.todolist.storage.TodoItemStorage;

@Component
public class Populator implements CommandLineRunner {


    private OwnerStorage ownerStorage;
    private TodoItemStorage itemStorage;
    private HashtagRepository hashtagRepo;

    public Populator(OwnerStorage ownerStorage, TodoItemStorage itemStorage, HashtagRepository hashtagRepo){

        this.ownerStorage = ownerStorage;
        this.itemStorage = itemStorage;
        this.hashtagRepo = hashtagRepo;
    }


    @Override
    public void run(String... args) throws Exception {



        TodoOwner ben = new TodoOwner("Ben");
        TodoOwner bruce = new TodoOwner("Bruce");
        TodoOwner bosco = new TodoOwner("Bosco");
        TodoOwner amy = new TodoOwner("Amy");
        TodoOwner cliff = new TodoOwner("Cliff");

        ownerStorage.addOwner(ben);
        ownerStorage.addOwner(bruce);
        ownerStorage.addOwner(bosco);
        ownerStorage.addOwner(amy);
        ownerStorage.addOwner(cliff);

        TodoItem itemToAdd1 = new TodoItem(ben, "Clean Dishes", "Today", "Amy", "Clean the dishes in the sink.");
        itemStorage.addItem(itemToAdd1);
        TodoItem itemToAdd2 = new TodoItem(cliff, "Host QandA", "Today", "Cohort", "Answer questions about life, love, and programming.");
        itemStorage.addItem(itemToAdd2);

        hashtagRepo.save(new Hashtag("#Awesome",itemToAdd1, itemToAdd2 ));
        hashtagRepo.save(new Hashtag("#SooooAwesome", itemToAdd1));
        hashtagRepo.save(new Hashtag("#informitive", itemToAdd2));
    }
}
