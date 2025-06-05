/* Продолжение задания 7.3 */

package numbers;

import main.Num;
import java.util.List;

/**
 * Класс для вычисления суммы чисел различных типов.
 * Поддерживает сложение объектов, реализующих интерфейс Num.
 */
public class Addition {
    private List<Num> numbers ;

    /**
     * Создает экземпляр Addition с указанным списком чисел.
     *
     * @param numbers список чисел для сложения (не должен быть null)
     */
    public Addition(List<Num> numbers) {
        if (numbers == null) {
            System.out.println("Error: Numbers list cannot be null");
            return;
        }
        this.numbers = numbers;
    }

    /**
     * Возвращает список чисел.
     *
     * @return текущий список чисел
     */
    public List<Num> getNumbers() {
        return numbers;
    }

    /**
     * Устанавливает новый список чисел.
     *
     * @param numbers новый список чисел (не должен быть null)
     * @return установленный список чисел
     */
    public List<Num> setNumbers(List<Num> numbers) {
        if (numbers == null) {
            System.out.println("Error: Numbers list cannot be null");
            return this.numbers;
        }
        this.numbers = numbers;
        return this.numbers;
    }

    /**
     * Вычисляет сумму всех чисел в списке.
     *
     * @return результат сложения всех чисел
     */
    public double summa() {
        double sum = 0;
        for (Num number : numbers) {
            if (number != null) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }
}