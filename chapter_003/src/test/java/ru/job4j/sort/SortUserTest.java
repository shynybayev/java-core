package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenSortUsers() {
        SortUser sortOperation = new SortUser();

        User user = new User("Assan", 12);
        User user2 = new User("Max", 21);
        User user3 = new User("Serega", 4);

        List<User> usersList = new ArrayList<>();
        usersList.add(user);
        usersList.add(user2);
        usersList.add(user3);

        Set<User> treeSetOfUsers = new TreeSet<>();
        treeSetOfUsers.add(user3);
        treeSetOfUsers.add(user);
        treeSetOfUsers.add(user2);

        assertThat(sortOperation.sort(usersList), is(treeSetOfUsers));
    }
}