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


}
