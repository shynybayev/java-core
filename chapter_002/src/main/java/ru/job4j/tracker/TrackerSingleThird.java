package ru.job4j.tracker;

import java.util.Arrays;

/**
 * static final field, eager loading
 */
public class TrackerSingleThird {
    private static final TrackerSingleThird INSTANCE = new TrackerSingleThird();

    private TrackerSingleThird() {
    }

    public static TrackerSingleThird getInstance() {
        return INSTANCE;
    }

}