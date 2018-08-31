package ru.job4j.condition;

/**
* Класс DummyBot
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class DummyBot{
	/**
	* Отвечает на вопросы.
	* @param question Вопрос от клиента
	* @return Ответ
	*/

	public String answer(String question){
		String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
		if ("Привет, Бот.".equals(question)) {
			rsl =  "Привет, умник.";
		} else if ("Пока".equals(question)) {
			rsl = "До скорой встречи";
		}
		return rsl;
	}
}