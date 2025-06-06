/* Продолжение задания 8.4 */

package geometry;

/**
 * Представляет точку на двумерной плоскости с координатами x и y.
 * Поддерживает операции сравнения точек и клонирования.
 */
public class Point implements Cloneable {
    private double x = 0;
    private double y = 0;

    /**
     * Создает новую точку с указанными координатами.
     *
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     *
     * @return координата X
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату Y точки.
     *
     * @return координата Y
     */
    public double getY() {
        return y;
    }

    /**
     * Сравнивает текущую точку с другим объектом.
     *
     * @param obj объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return Double.compare(this.x, other.x) == 0
                && Double.compare(this.y, other.y) == 0;
    }

    /**
     * Создает и возвращает копию текущей точки.
     *
     * @return копия текущей точки
     */
    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error: Cloning not supported");
            return null;
        }
    }

    /**
     * Возвращает строковое представление точки в формате "{x; y}".
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}