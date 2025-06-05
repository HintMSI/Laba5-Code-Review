/* Продолжение задания 1.10 */

package cities;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для представления города и маршрутов в другие города.
 * Содержит список городов назначения и соответствующие стоимости маршрутов.
 */
public class City {
    private String name;
    private List<City> destinationCities;
    private List<Integer> routeCosts;

    /**
     * Конструктор города с указанием имени.
     *
     * @param name название города
     */
    public City(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название города не может быть пустым");
            return;
        }

        this.name = name;
        this.destinationCities = new ArrayList<>();
        this.routeCosts = new ArrayList<>();
    }

    /**
     * Конструктор города с предопределенными маршрутами.
     *
     * @param name название города
     * @param destinationCities список городов назначения
     * @param routeCosts список стоимостей маршрутов
     */
    public City(String name, List<City> destinationCities, List<Integer> routeCosts) {
        this(name);

        if (destinationCities == null || routeCosts == null) {
            System.out.println("Ошибка: списки городов и стоимостей не могут быть null");
            return;
        }

        if (destinationCities.size() != routeCosts.size()) {
            System.out.println("Ошибка: количество городов и стоимостей должно совпадать");
            return;
        }

        this.destinationCities.addAll(destinationCities);
        this.routeCosts.addAll(routeCosts);
    }

    /**
     * Устанавливает название города.
     *
     * @param name новое название города
     * @return установленное название города
     */
    public String setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название города не может быть пустым");
            return this.name;
        }

        this.name = name;
        return this.name;
    }

    /**
     * Получает название города.
     *
     * @return название города
     */
    public String getName() {
        return this.name;
    }

    /**
     * Устанавливает список городов назначения.
     *
     * @param destinationCities список городов назначения
     * @return установленный список городов назначения
     */
    public List<City> setDestinationCities(List<City> destinationCities) {
        if (destinationCities == null) {
            System.out.println("Ошибка: список городов не может быть null");
            return this.destinationCities;
        }

        this.destinationCities = destinationCities;
        return this.destinationCities;
    }

    /**
     * Получает список городов назначения.
     *
     * @return список городов назначения
     */
    public List<City> getDestinationCities() {
        return this.destinationCities;
    }

    /**
     * Устанавливает список стоимостей маршрутов.
     *
     * @param routeCosts список стоимостей маршрутов
     * @return установленный список стоимостей
     */
    public List<Integer> setRouteCosts(List<Integer> routeCosts) {
        if (routeCosts == null) {
            System.out.println("Ошибка: список стоимостей маршрутов не может быть null");
            return this.routeCosts;
        }

        this.routeCosts = routeCosts;
        return this.routeCosts;
    }

    /**
     * Получает список стоимостей маршрутов.
     *
     * @return список стоимостей маршрутов
     */
    public List<Integer> getRouteCosts() {
        return this.routeCosts;
    }

    /**
     * Добавляет маршрут к указанному городу с заданной стоимостью.
     * Если маршрут уже существует, обновляет его стоимость.
     *
     * @param destination город назначения
     * @param cost стоимость маршрута
     */
    public void addRoute(City destination, int cost) {
        if (destination == null) {
            System.out.println("Ошибка: город назначения не может быть null");
            return;
        }

        if (cost <= 0) {
            System.out.println("Ошибка: стоимость маршрута должна быть положительным числом");
            return;
        }

        if (destination == this) {
            System.out.println("Ошибка: нельзя добавить маршрут к самому себе");
            return;
        }

        int index = destinationCities.indexOf(destination);
        if (index != -1) {
            routeCosts.set(index, cost);
        } else {
            destinationCities.add(destination);
            routeCosts.add(cost);
        }
    }

    /**
     * Удаляет маршрут к указанному городу.
     *
     * @param destination город назначения для удаления маршрута
     * @return true если маршрут был удален, false если маршрут не найден
     */
    public boolean removeRoute(City destination) {
        if (destination == null) {
            System.out.println("Ошибка: город назначения не может быть null");
            return false;
        }

        int index = destinationCities.indexOf(destination);
        if (index != -1) {
            destinationCities.remove(index);
            routeCosts.remove(index);
            return true;
        } else {
            System.out.println("Маршрут к городу " + destination.getName() + " не существует.");
            return false;
        }
    }

    /**
     * Возвращает строковое представление города и его маршрутов.
     *
     * @return строковое представление города
     */
    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Из города ").append(name);

        if (destinationCities.isEmpty()) {
            resultBuilder.append(" нет доступных маршрутов\n");
        } else {
            resultBuilder.append(" есть маршруты в города:\n");
            for (int i = 0; i < destinationCities.size(); i++) {
                resultBuilder.append("  - ")
                        .append(destinationCities.get(i).getName())
                        .append(" (стоимость: ")
                        .append(routeCosts.get(i))
                        .append(")\n");
            }
        }
        return resultBuilder.toString();
    }
}