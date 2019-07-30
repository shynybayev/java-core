package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс контейнер, который используется для хранения всех заявок и операции над ними.
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    /**
     * Добавление заявок
     * @param item заявка, которую нужно добавить
     * @return новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод возвращает заявку по заданному ID
     * @param id заданный ID
     * @return заявка.
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
                break;
            }
        }
        return item;
    }

    /**
     * Метод получение списка по имени.
     * @param key заданное имя
     * @return список заявок.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[position];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                temp[count++] = items[i];
            }
        }
        return Arrays.copyOf(temp, count);
    }

    /**
     * Удаление заявок по id
     * @param id передаваемый id
     */
    public boolean delete(String id) {
        boolean isDeleted = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                position--;
                System.arraycopy(items, i + 1, items, 0, position);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    /**
     * Обновление заявок по id
     * @param id передаваемый id
     */
    public boolean replace(String id, Item item) {
        boolean isReplaced = false;
        item.setId(id);
        try {
            for (int i = 0; i < position; i++) {
                if (id.equals(item.getId())) {
                    this.items[i] = item;
                    isReplaced = true;
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Заявка по " + id + "не найдено");
        }
        return isReplaced;
    }

    /**
     * Получение списка всех заявок
     * @return список всех заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(Math.random() + System.currentTimeMillis());
    }

}
