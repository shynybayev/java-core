package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortByNamesLength(List<User> userList) {
         Collections.sort(userList, new Comparator<User>() {
             @Override
             public int compare(User o1, User o2) {
                 return o1.getName().length() - o2.getName().length();
             }
         });
         return userList;
    }

    public List<User> sortByAllFields(List<User> userList) {

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return userList;
    }
}
