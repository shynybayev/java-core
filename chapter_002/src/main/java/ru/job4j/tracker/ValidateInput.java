package ru.job4j.tracker;

import java.util.List;

/**
 * Валидация - проверка данных, шаблон Декоратор(композиция)
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean isValid = true;
        int value = -1;

        do {
            try {
                value = this.input.ask(question, range); //вызов родительского класса
                isValid = false;
            } catch (MenuOutOfException moe) {
                System.out.println("Please, select key from menu! ");
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong input, please enter validate data again! ");
            }
        } while (isValid);

        return value;
    }
}
