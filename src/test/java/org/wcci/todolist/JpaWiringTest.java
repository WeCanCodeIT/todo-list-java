package org.wcci.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.todolist.models.TodoItem;
import org.wcci.todolist.models.TodoOwner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TodoOwnerRepository todoOwnerRepo;
    @Autowired
    private TodoItemRepository todoItemRepo;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private HashtagRepository hashtagRepo;


    @Test
    public void todoOwnerHasManyItemsAndTodoItemHasOneOwner() {
        TodoOwner testOwner = new TodoOwner("Testy McTesterson");

        todoOwnerRepo.save(testOwner);

        TodoItem testItem1 = new TodoItem(testOwner, "Test Item 1", "now", "Tester", "Description");
        TodoItem testItem2 = new TodoItem(testOwner, "Test Item 2", "now", "Testerosa", "Another Description");

        todoItemRepo.save(testItem1);
        todoItemRepo.save(testItem2);

        testEntityManager.flush();
        testEntityManager.clear();

        TodoOwner retrievedOwner = todoOwnerRepo.findById(testOwner.getId()).get();

        assertThat(retrievedOwner.getItems()).contains(testItem1, testItem2);
        assertThat(retrievedOwner).isEqualTo(testOwner);
    }

    @Test
    public void todoItemHasManyHashtagsAndHashtagsHaveManyTodoItems() {
        TodoOwner testOwner = new TodoOwner("Testy McTesterson");

        todoOwnerRepo.save(testOwner);

        TodoItem testItem1 = new TodoItem(testOwner, "Test Item 1", "now", "Tester", "Description");
        TodoItem testItem2 = new TodoItem(testOwner, "Test Item 2", "now", "Testerosa", "Another Description");
        TodoItem testItem3 = new TodoItem(testOwner, "Test Item 3", "now", "Testy", "Yet Another Description");
        todoItemRepo.save(testItem1);
        todoItemRepo.save(testItem2);
        todoItemRepo.save(testItem3);

        Hashtag testHashtag1 = new Hashtag("Tedious", testItem1, testItem2, testItem3);
        Hashtag testHashtag2 = new Hashtag("Boring", testItem1);
        Hashtag testHashtag3 = new Hashtag("Dumb", testItem2);
        Hashtag testHashtag4 = new Hashtag("Awesome");
        hashtagRepo.save(testHashtag1);
        hashtagRepo.save(testHashtag2);
        hashtagRepo.save(testHashtag3);
        hashtagRepo.save(testHashtag4);

        testEntityManager.flush();
        testEntityManager.clear();

        TodoItem retrievedItem1 = todoItemRepo.findById(testItem1.getId()).get();
        TodoItem retrievedItem2 = todoItemRepo.findById(testItem2.getId()).get();

        assertThat(retrievedItem1.getHashtags()).contains(testHashtag1, testHashtag2);
        assertThat(retrievedItem2.getHashtags()).contains(testHashtag1, testHashtag3);


    }

}
