package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс контейнер, который используется для хранения всех заявок и операции над ними.
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class Tracker {
    //Массив для хранение заявок.
    private Item[] items = new Item[100];

    //Указатель ячейки для новой заявки.
    private int position = 0;

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(Math.random());
    }

    /**
     * Метод возвращает заявку по заданному ID .
     * @param id заданный ID
     * @return заявка.
     */
    public Item findById(String id){
        Item item = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)){
                item = items[i];
            } else {
              item = null;
            }
        }
        return item;
    }

    /**
     * Метод получение списка по имени.
     * @param key заданное имя
     * @return список заявок.
     */
    public Item[] findByName(String key){
        Item[] temp = new Item[position];
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)){
               temp = Arrays.copyOf(items, position);
            }
        }
        return temp;
    }

    /**
     * Добавление заявок
     * @param item заявка, которую нужно добавить
     * @return новая заявка
     */
    public Item add(Item item){
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Удаление заявок по id
     * @param id передаваемый id
     */
    public void delete(String id){
        Item[] temp = new Item[position];
         for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)){
                System.arraycopy(items, i, temp, 0 , position - 1);
            }
        }
    }


    public void replace(String id, Item item){

        for (int i = 0; i < position ; i++) {
            if (id.equals(item.getId())){
                  items[i] = item;
            }
        }
    }

    /**
     * Получение списка всех заявок
     * @return список всех заявок
     */
    public Item[] getAll(){
        Item[] temp = null;
        for (int i = 0; i < position ; i++) {
            if (items[i] != null){
                temp = Arrays.copyOf(items, position);
            }
        }
        return temp;
    }

}
