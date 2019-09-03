package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель справочника
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class PhoneDictionary {
    private List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        this.personList.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержит key в любых полях.
     * @param key Ключ поиска
     * @return Список подощедщих пользователей
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for (int index = 0; index < personList.size(); index++) {
            if (personList.get(index).getName().contains(key)) {
                result.add(personList.get(index));
            }
        }

        return result;
    }
}