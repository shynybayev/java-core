package ru.job4j.tracker;

import java.util.Arrays;

/**
 * С использованием  static field Lazy loading.
 */
public class TrackerSingleSecond {
    private static TrackerSingleSecond instance;

    private TrackerSingleSecond() {
    }

    public static TrackerSingleSecond getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSecond();
        }
        return instance;
    }
}
