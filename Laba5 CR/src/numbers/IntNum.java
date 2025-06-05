/* Продолжение задания 7.3 */

package numbers;

import main.Num;

/**
 * Реализация интерфейса Num для целых чисел.
 */
public class IntNum implements Num {
    private final int value;

    /**
     * Создает новый экземпляр IntNum.
     *
     * @param value целочисленное значение
     */
    public IntNum(int value) {
        this.value = value;
    }

    /**
     * Возвращает строковое представление числа.
     *
     * @return строковое представление целого числа
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Возвращает значение в виде double.
     *
     * @return целочисленное значение приведенное к double
     */
    @Override
    public double doubleValue() {
        return value;
    }
}