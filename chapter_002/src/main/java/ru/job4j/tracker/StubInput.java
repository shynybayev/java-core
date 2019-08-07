package ru.job4j.tracker;

import java.util.List;

/**
 * класс заглушка
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь хочет выбрать добавление заявки
     * ему нужно ввести: 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера
     */
    private final String[] answers;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    /**
     * Инициализация списка ответов
     * @param answers список ответов в виде массива строк
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Есть объект, в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы стимулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам значение.
     * @param question вопрос
     * @return на новый вопрос возвращает строку ответа
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List<Integer> rang) {
        int key = Integer.valueOf(this.ask(question));
        boolean isExist = false;
        for (int value : rang) {
            if (value == key) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            return key;
        } else {
            throw new MenuOutOfException("Out of menu range");
        }
    }
}