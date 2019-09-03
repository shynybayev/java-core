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
        tasks.add(task);
        while (tasks.get(0).getPriority() > task.getPriority()) {
             tasks.addFirst(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}