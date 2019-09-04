package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();
    private int count = 0;
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяет по полю приоритет.
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(count++, task);
        while (tasks.get(0).getPriority() > task.getPriority()) {
             tasks.removeFirst();
             tasks.addFirst(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}