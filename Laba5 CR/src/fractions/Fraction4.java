/* Продолжение задания 1.4, 3.1, 4.2 */

package fractions;

/**
 * Расширенная реализация дроби с поддержкой всех числовых преобразований.
 * Наследует функциональность класса {@link Number}.
 */
public class Fraction4 extends Number {
    private int numerator = 0;
    private int denominator = 0;

    /**
     * Создает новую несократимую дробь.
     *
     * @param numerator числитель дроби
     * @param denominator знаменатель дроби (должен быть не равен нулю)
     */
    public Fraction4(int numerator, int denominator) {
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
     * Возвращает числитель дроби.
     *
     * @return значение числителя
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Возвращает знаменатель дроби.
     *
     * @return значение знаменателя
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Вычитает другую дробь из текущей дроби.
     *
     * @param other дробь для вычитания (не должна быть null)
     * @return новая дробь - результат вычитания или null при ошибке
     */
    public Fraction4 minus(Fraction4 other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction4(newNumerator, newDenominator);
    }

    /**
     * Умножает текущую дробь на другую дробь.
     *
     * @param other дробь для умножения (не должна быть null)
     * @return новая дробь - результат умножения или null при ошибке
     */
    public Fraction4 multiply(Fraction4 other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        return new Fraction4(newNumerator, newDenominator);
    }

    /**
     * Делит текущую дробь на другую дробь.
     *
     * @param other дробь-делитель (не должна быть null)
     * @return новая дробь - результат деления или null при ошибке
     */
    public Fraction4 div(Fraction4 other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }
        if (other.numerator == 0) {
            System.out.println("Error: Division by zero");
            return null;
        }

        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new Fraction4(newNumerator, newDenominator);
    }

    /**
     * Складывает текущую дробь с другой дробью.
     *
     * @param other дробь для сложения (не должна быть null)
     * @return новая дробь - результат сложения или null при ошибке
     */
    public Fraction4 sum(Fraction4 other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction4(newNumerator, newDenominator);
    }

    /**
     * {@inheritDoc}
     *
     * @return целочисленное значение дроби (с отбрасыванием дробной части)
     */
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    /**
     * {@inheritDoc}
     *
     * @return значение дроби в формате long (с отбрасыванием дробной части)
     */
    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    /**
     * {@inheritDoc}
     *
     * @return приближенное значение дроби с плавающей точкой
     */
    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    /**
     * {@inheritDoc}
     *
     * @return точное значение дроби с двойной точностью
     */
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    /**
     * Возвращает строковое представление дроби в формате "числитель/знаменатель".
     *
     * @return строковое представление дроби
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}