package ru.job4j.list;

 import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 import static org.hamcrest.core.Is.is;


import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenListConvertToMap() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();

        User firstUser = new User(0, "Max", "Moscow");
        User secondUser = new User(1, "Sergey", "Astana");
        User thirdUser = new User(2, "Kairat", "Almaty");

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(0, firstUser);
        expect.put(1, secondUser);
        expect.put(2, thirdUser);

        assertThat(convert.process(users), is(expect));
    }
}