package ru.job4j.tracker;

import java.util.List;

/**
 * Валидация - проверка данных
 */
public class ValidateInput extends ConsoleInput {
    //перекрыли реализацию метода, более приемлимо с помощью интерфейса, композицию - Low Scalping
    public int ask(String question, List<Integer> range) {
        boolean isValid = true;
        int value = -1;

        do {
            try {
                value = super.ask(question, range); //вызов родительского класса
                isValid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong input, please enter validate data again! ");
            } catch (MenuOutOfException moe) {
                System.out.println("Please, select key from menu! ");
            }
        } while (isValid);

        return value;
    }
}
