package ru.job4j.tracker;

/**
 * singleton - получение одного и того же экземпляра класса
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

import java.util.Arrays;

/**
 * с использованием enum, Eager loading
 */
public enum TrackerEnum {
    INSTANCE;

    private Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    private String generateId() {
        return String.valueOf(Math.random() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}

/**
 * С использованием  static field Lazy loading.
 */
class TrackerSingleSecond {
    private static TrackerSingleSecond instance;
    private Item[] items = new Item[100];
    private int position = 0;

    private TrackerSingleSecond() {
    }

    public static TrackerSingleSecond getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSecond();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(Math.random() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}

/**
 * static final field, eager loading
 */
class TrackerSingleThird {
    private static final TrackerSingleThird INSTANCE = new TrackerSingleThird();
    private Item[] items = new Item[100];
    private int position = 0;

    private TrackerSingleThird() {
    }

    public static TrackerSingleThird getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(Math.random() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}

/**
 * private static final class, lazy loading
 */
class TrackerSingleFourth {
    private TrackerSingleFourth() {
    }

    public static TrackerSingleFourth getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFourth INSTANCE = new TrackerSingleFourth();
    }

    private Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(Math.random() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }
}
