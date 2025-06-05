/* Продолжение задания 7.3 */

package numbers;

import main.Num;

/**
 * Реализация интерфейса Num для вещественных чисел.
 */
public class DoubNum implements Num {
    private final double value;

    /**
     * Создает новый экземпляр DoubNum.
     *
     * @param value вещественное значение
     */
    public DoubNum(double value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление числа.
     *
     * @return строковое представление вещественного числа
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Возвращает значение в виде double.
     *
     * @return вещественное значение
     */
    @Override
    public double doubleValue() {
        return value;
    }
}