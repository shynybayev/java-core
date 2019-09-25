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

    @Test
    public void whenSortWithComparator() {
        SortUser sortObj = new SortUser();

        User user = new User("Assan", 12);
        User user2 = new User("Max", 21);
        User user3 = new User("Serega", 4);

        List<User> usersList2 = new ArrayList<>();
        usersList2.add(user);
        usersList2.add(user2);
        usersList2.add(user3);

        List<User> sortedUsers = new ArrayList<>();
        sortedUsers.add(user2);
        sortedUsers.add(user);
        sortedUsers.add(user3);

        assertThat(sortObj.sortByNamesLength(usersList2), is(sortedUsers));
    }

    @Test
    public void whenSortAllFields() {
        SortUser sortObj = new SortUser();

        User user2 = new User("Zack", 21);
        User user3 = new User("Serega", 4);
        User user4 = new User("Serega", 444);
        User user = new User("Assan", 12);
        User user5 = new User("Assan", 25);


        List<User> usersList2 = new ArrayList<>();
        usersList2.add(user2);
        usersList2.add(user3);
        usersList2.add(user);
        usersList2.add(user4);
        usersList2.add(user5);

        List<User> sortedUsers = new ArrayList<>();
        sortedUsers.add(user);
        sortedUsers.add(user5);
        sortedUsers.add(user3);
        sortedUsers.add(user4);
        sortedUsers.add(user2);

        assertThat(sortObj.sortByAllFields(usersList2), is(sortedUsers));
    }
}