package ru.job4j.tracker;

public class MenuOutOfException extends RuntimeException {
    //сообщение об ошибке передается в родительский конструктор
    public MenuOutOfException(String msg) {
        super(msg);
    }
}
