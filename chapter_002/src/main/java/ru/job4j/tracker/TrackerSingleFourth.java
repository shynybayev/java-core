package ru.job4j.tracker;

import java.util.Arrays;

/**
 * private static final class, lazy loading
 */
public class TrackerSingleFourth {
    private TrackerSingleFourth() {
    }

    public static TrackerSingleFourth getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFourth INSTANCE = new TrackerSingleFourth();
    }
}
