package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapUser =  new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
           mapUser.put(list.get(i).getId(), list.get(i));
        }

        return mapUser;
    }
}
