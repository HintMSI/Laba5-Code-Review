/* Продолжение задания 1.4, 3.1, 4.2 */

package fractions;

/**
 * Представляет математическую дробь с целыми числителем и знаменателем.
 * Поддерживает основные арифметические операции: сложение, вычитание, умножение и деление.
 */
public class Fraction {
    private int numerator = 0;
    private int denominator = 0;

    /**
     * Создает новую несократимую дробь.
     *
     * @param numerator числитель дроби
     * @param denominator знаменатель дроби (должен быть не равен нулю)
     */
    public Fraction(int numerator, int denominator) {
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
     * Складывает текущую дробь с другой дробью.
     *
     * @param other дробь для сложения (не должна быть null)
     * @return новая дробь - результат сложения или null при ошибке
     */
    public Fraction sum(Fraction other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Вычитает другую дробь из текущей.
     *
     * @param other дробь для вычитания (не должна быть null)
     * @return новая дробь - результат вычитания или null при ошибке
     */
    public Fraction minus(Fraction other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Умножает текущую дробь на другую дробь.
     *
     * @param other дробь для умножения (не должна быть null)
     * @return новая дробь - результат умножения или null при ошибке
     */
    public Fraction multiply(Fraction other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }

        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Делит текущую дробь на другую дробь.
     *
     * @param other дробь-делитель (не должна быть null или нулем)
     * @return новая дробь - результат деления или null при ошибке
     */
    public Fraction divide(Fraction other) {
        if (other == null) {
            System.out.println("Error: Other fraction cannot be null");
            return null;
        }
        if (other.numerator == 0) {
            System.out.println("Error: Cannot divide by zero");
            return null;
        }

        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
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