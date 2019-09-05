package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяет по полю приоритет.
     * @param task задача
     */
    public void put(Task task) {
        int count = tasks.size();
        for (int i = 0; i < count; i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                count = i;
            }
        }
        tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}