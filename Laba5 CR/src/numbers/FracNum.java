/* Продолжение задания 7.3 */

package numbers;

import main.Num;

/**
 * Реализация интерфейса Num для дробей.
 */
public class FracNum implements Num {
    private int numerator = 0;
    private int denominator = 0;

    /**
     * Создает новую дробь.
     *
     * @param numerator числитель
     * @param denominator знаменатель (не может быть 0)
     */
    public FracNum(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Error: Denominator cannot be zero");
            return;
        }

        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    /**
     * Возвращает строковое представление дроби.
     *
     * @return строка в формате "числитель/знаменатель"
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Возвращает десятичное представление дроби.
     *
     * @return результат деления числителя на знаменатель
     */
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}