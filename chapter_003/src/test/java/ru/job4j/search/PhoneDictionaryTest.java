package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class PhoneDictionaryTest {

    @Test
    public void whenFindByKey() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Stepan", "Ivanov",
                        "87772251177", "Almaty")
        );
        List<Person> person = phones.find("Stepan");
        assertThat(person.iterator().next().getSurname(), is("Ivanov"));
    }
}