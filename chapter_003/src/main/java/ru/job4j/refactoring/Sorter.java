package ru.job4j.refactoring;
import java.util.*;

/**
 * Sorter class
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class Sorter {

    public Sorter() {
    }

    /**
     * Sort with TreeSet
     * @param userList
     * @return
     */
    public Set<User> sort(List<User> userList) {
        return new TreeSet<>(userList);
    }

    /**
     * Sort list of users by name lenghth
     * @param userList current list of users
     * @return sorted  list of users
     */
    public List<User> sortByNameLength(List<User> userList) {
        Comparator<User> comparingWithNameLength = Comparator.comparingInt(o -> o.getName().length());
        userList.sort(comparingWithNameLength);
        return userList;
    }

    /**
     * Sort list of users by all field
     * @param userList current user list
     * @return sorted list of users
     */
    public List<User> sortByAllField(List<User> userList) {
        Comparator<User> comparingWithNameLength = Comparator.comparing(User::getName);
        Comparator<User> comparingWithAge = Comparator.comparingInt(User::getAge);
        userList.sort(comparingWithNameLength.thenComparing(comparingWithAge));
        return userList;
    }
}