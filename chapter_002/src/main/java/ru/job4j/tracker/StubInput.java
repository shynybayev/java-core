package ru.job4j.tracker;

/**
 * класс заглушка
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    /**
     * Инициализация списка ответов
     * @param answers список ответов в виде массива строк
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Для тестирования кода
     * @param question вопрос
     * @return на новый вопрос возвращает строку ответа
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public void print(String data) {

    }
}