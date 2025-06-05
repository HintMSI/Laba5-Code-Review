/* Продолжение задания 1.4, 1.10, 3.1, 4.2, 5.1, 7.3, 8.4 */

package main;

import fractions.Fraction;
import fractions.Fraction3;
import fractions.Fraction4;
import cities.City;
import geometry.Point;
import numbers.FracNum;
import numbers.DoubNum;
import numbers.IntNum;
import numbers.Addition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Главный класс приложения для работы с дробями, городами, точками и числами.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Основной метод приложения.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("Программа для выполнения заданий по работе с разными типами данных");

        while (true) {
            printMainMenu();
            int choice = readIntInRange(0, 7);

            switch (choice) {
                case 1:
                    runFractionTask();
                    break;
                case 2:
                    runCityTask();
                    break;
                case 3:
                    runFraction3Task();
                    break;
                case 4:
                    runFraction4Task();
                    break;
                case 5:
                    runNumberTask();
                    break;
                case 6:
                    runExponentiationTask();
                    break;
                case 7:
                    runPointTask();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
            }
            System.out.println("\nНажмите Enter чтобы продолжить...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    /**
     * Выводит главное меню приложения.
     */
    private static void printMainMenu() {
        System.out.println("\nВыберите задание:");
        System.out.println("1. Дроби (1.4)");
        System.out.println("2. Города и дороги (1.10)");
        System.out.println("3. Дроби (3.1)");
        System.out.println("4. Дроби (4.2)");
        System.out.println("5. Числа разных типов (5.1)");
        System.out.println("6. Возведение в степень (7.3)");
        System.out.println("7. Точки (8.4)");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Запускает задание по работе с дробями (1.4).
     */
    private static void runFractionTask() {
        System.out.println("\n Задание 1.4 ");

        List<Fraction> fractions = createFractions();
        if (fractions.isEmpty()) {
            System.out.println("Не создано ни одной дроби для работы.");
            return;
        }

        performFractionOperations(fractions);
    }

    /**
     * Создает список дробей на основе пользовательского ввода.
     *
     * @return список созданных дробей
     */
    private static List<Fraction> createFractions() {
        System.out.print("Введите количество дробей для создания: ");
        int count = readPositiveInt();
        List<Fraction> fractions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСоздание дроби " + (i + 1) + " из " + count);

            int numerator = readInt("числитель: ");
            int denominator;
            do {
                denominator = readInt("знаменатель (не ноль): ");
                if (denominator == 0) {
                    System.out.println("Ошибка: знаменатель не может быть нулем!");
                }
            } while (denominator == 0);

            Fraction fraction = new Fraction(numerator, denominator);
            fractions.add(fraction);
            System.out.println("Создана дробь: " + fraction);
        }

        return fractions;
    }

    /**
     * Выполняет операции с дробями на основе пользовательского выбора.
     *
     * @param fractions список дробей для операций
     */
    private static void performFractionOperations(List<Fraction> fractions) {
        while (true) {
            printFractionOperationsMenu();
            int operation = readIntInRange(0, 4);

            if (operation == 0) {
                return;
            }

            if (fractions.size() < 2) {
                System.out.println("Для выполнения операций нужно минимум 2 дроби!");
                return;
            }

            Fraction first = selectFraction(fractions, "Выберите первую дробь: ");
            Fraction second = selectFraction(fractions, "Выберите вторую дробь: ");

            switch (operation) {
                case 1:
                    System.out.printf("%s + %s = %s%n", first, second, first.sum(second));
                    break;
                case 2:
                    System.out.printf("%s - %s = %s%n", first, second, first.minus(second));
                    break;
                case 3:
                    System.out.printf("%s * %s = %s%n", first, second, first.multiply(second));
                    break;
                case 4:
                    Fraction result = first.divide(second);
                    if (result != null) {
                        System.out.printf("%s / %s = %s%n", first, second, result);
                    } else {
                        System.out.println("Ошибка при делении дробей!");
                    }
                    break;
            }
        }
    }

    /**
     * Выводит меню операций с дробями.
     */
    private static void printFractionOperationsMenu() {
        System.out.println("\nВыберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("0. Назад");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Запускает задание по работе с городами (1.10).
     */
    private static void runCityTask() {
        System.out.println("\n Задание 1.10 ");
        List<City> cities = new ArrayList<>();

        while (true) {
            printCityMenu();
            int action = readIntInRange(0, 4);

            switch (action) {
                case 1:
                    addCity(cities);
                    break;
                case 2:
                    addRoute(cities);
                    break;
                case 3:
                    removeRoute(cities);
                    break;
                case 4:
                    printCities(cities);
                    break;
                case 0:
                    return;
            }
        }
    }

    /**
     * Выводит меню операций с городами.
     */
    private static void printCityMenu() {
        System.out.println("\nМеню городов:");
        System.out.println("1. Добавить город");
        System.out.println("2. Добавить дорогу");
        System.out.println("3. Удалить дорогу");
        System.out.println("4. Показать все города");
        System.out.println("0. Назад");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Добавляет новый город в список.
     *
     * @param cities список городов
     */
    private static void addCity(List<City> cities) {
        System.out.print("\nВведите название города: ");
        scanner.nextLine();
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Ошибка: название города не может быть пустым!");
            return;
        }

        cities.add(new City(name));
        System.out.println("Город '" + name + "' добавлен.");
    }

    /**
     * Добавляет дорогу между двумя городами.
     *
     * @param cities список городов
     */
    private static void addRoute(List<City> cities) {
        if (cities.size() < 2) {
            System.out.println("Нужно минимум 2 города для создания дороги!");
            return;
        }

        City from = selectCity(cities, "Выберите город отправления:");
        City to = selectCity(cities, "Выберите город назначения:");

        System.out.print("Введите стоимость дороги: ");
        int cost = readPositiveInt();

        from.addRoute(to, cost);
        System.out.printf("Дорога добавлена: %s -> %s (стоимость: %d)%n",
                from.getName(), to.getName(), cost);
    }

    /**
     * Удаляет дорогу между двумя городами.
     *
     * @param cities список городов
     */
    private static void removeRoute(List<City> cities) {
        if (cities.isEmpty()) {
            System.out.println("Нет городов для удаления дорог!");
            return;
        }

        City from = selectCity(cities, "Выберите город отправления:");
        City to = selectCity(cities, "Выберите город назначения:");

        if (from.removeRoute(to)) {
            System.out.printf("Дорога удалена: %s -> %s%n", from.getName(), to.getName());
        } else {
            System.out.printf("Дорога между %s и %s не найдена!%n", from.getName(), to.getName());
        }
    }

    /**
     * Выводит информацию о всех городах и дорогах.
     *
     * @param cities список городов
     */
    private static void printCities(List<City> cities) {
        if (cities.isEmpty()) {
            System.out.println("Список городов пуст.");
            return;
        }

        System.out.println("\nСписок городов и дорог:");
        for (City city : cities) {
            System.out.println(city);
        }
    }

    /**
     * Выбирает город из списка по пользовательскому выбору.
     *
     * @param cities список городов
     * @param prompt приглашение для пользователя
     * @return выбранный город
     */
    private static City selectCity(List<City> cities, String prompt) {
        System.out.println("\nДоступные города:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, cities.get(i).getName());
        }

        System.out.print(prompt + " ");
        return cities.get(readIntInRange(1, cities.size()) - 1);
    }

    /**
     * Запускает задание по работе с дробями (3.1).
     */
    private static void runFraction3Task() {
        System.out.println("\n Задание 3.1 ");

        List<Fraction3> fractions = createFraction3s();
        if (fractions.isEmpty()) {
            System.out.println("Не создано ни одной дроби для работы.");
            return;
        }

        performFraction3Operations(fractions);
    }

    /**
     * Создает список дробей (Fraction3) на основе пользовательского ввода.
     *
     * @return список созданных дробей
     */
    private static List<Fraction3> createFraction3s() {
        System.out.print("Введите количество дробей для создания: ");
        int count = readPositiveInt();
        List<Fraction3> fractions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСоздание дроби " + (i + 1) + " из " + count);

            int numerator = readInt("числитель: ");
            int denominator;
            do {
                denominator = readInt("знаменатель (не ноль): ");
                if (denominator == 0) {
                    System.out.println("Ошибка: знаменатель не может быть нулем!");
                }
            } while (denominator == 0);

            Fraction3 fraction = new Fraction3(numerator, denominator);
            fractions.add(fraction);
            System.out.println("Создана дробь: " + fraction);
        }

        return fractions;
    }

    /**
     * Выполняет операции с дробями (Fraction3) на основе пользовательского выбора.
     *
     * @param fractions список дробей для операций
     */
    private static void performFraction3Operations(List<Fraction3> fractions) {
        while (true) {
            printFractionOperationsMenu();
            int operation = readIntInRange(0, 4);

            if (operation == 0) {
                return;
            }

            if (fractions.size() < 2) {
                System.out.println("Для выполнения операций нужно минимум 2 дроби!");
                return;
            }

            Fraction3 first = selectFraction3(fractions, "Выберите первую дробь: ");
            Fraction3 second = selectFraction3(fractions, "Выберите вторую дробь: ");

            switch (operation) {
                case 1:
                    System.out.printf("%s + %s = %s%n", first, second, first.sum(second));
                    break;
                case 2:
                    System.out.printf("%s - %s = %s%n", first, second, first.minus(second));
                    break;
                case 3:
                    System.out.printf("%s * %s = %s%n", first, second, first.multiply(second));
                    break;
                case 4:
                    Fraction3 result = first.divide(second);
                    if (result != null) {
                        System.out.printf("%s / %s = %s%n", first, second, result);
                    } else {
                        System.out.println("Ошибка при делении дробей!");
                    }
                    break;
            }
        }
    }

    /**
     * Выбирает дробь (Fraction3) из списка по пользовательскому выбору.
     *
     * @param fractions список дробей
     * @param prompt приглашение для пользователя
     * @return выбранная дробь
     */
    private static Fraction3 selectFraction3(List<Fraction3> fractions, String prompt) {
        System.out.println("\nДоступные дроби:");
        for (int i = 0; i < fractions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, fractions.get(i));
        }

        System.out.print(prompt + " ");
        return fractions.get(readIntInRange(1, fractions.size()) - 1);
    }

    /**
     * Запускает задание по работе с дробями (4.2).
     */
    private static void runFraction4Task() {
        System.out.println("\n Задание 4.2 ");

        List<Fraction4> fractions = createFraction4s();
        if (fractions.isEmpty()) {
            System.out.println("Не создано ни одной дроби для работы.");
            return;
        }

        performFraction4Operations(fractions);
    }

    /**
     * Создает список дробей (Fraction4) на основе пользовательского ввода.
     *
     * @return список созданных дробей
     */
    private static List<Fraction4> createFraction4s() {
        System.out.print("Введите количество дробей для создания: ");
        int count = readPositiveInt();
        List<Fraction4> fractions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСоздание дроби " + (i + 1) + " из " + count);

            int numerator = readInt("числитель: ");
            int denominator;
            do {
                denominator = readInt("знаменатель (не ноль): ");
                if (denominator == 0) {
                    System.out.println("Ошибка: знаменатель не может быть нулем!");
                }
            } while (denominator == 0);

            Fraction4 fraction = new Fraction4(numerator, denominator);
            fractions.add(fraction);
            System.out.println("Создана дробь: " + fraction);
        }

        return fractions;
    }

    /**
     * Выполняет операции с дробями (Fraction4) на основе пользовательского выбора.
     *
     * @param fractions список дробей для операций
     */
    private static void performFraction4Operations(List<Fraction4> fractions) {
        while (true) {
            printFractionOperationsMenu();
            int operation = readIntInRange(0, 4);

            if (operation == 0) {
                return;
            }

            if (fractions.size() < 2) {
                System.out.println("Для выполнения операций нужно минимум 2 дроби!");
                return;
            }

            Fraction4 first = selectFraction4(fractions, "Выберите первую дробь: ");
            Fraction4 second = selectFraction4(fractions, "Выберите вторую дробь: ");

            switch (operation) {
                case 1:
                    System.out.printf("%s + %s = %s%n", first, second, first.sum(second));
                    break;
                case 2:
                    System.out.printf("%s - %s = %s%n", first, second, first.minus(second));
                    break;
                case 3:
                    System.out.printf("%s * %s = %s%n", first, second, first.multiply(second));
                    break;
                case 4:
                    Fraction4 result = first.div(second);
                    if (result != null) {
                        System.out.printf("%s / %s = %s%n", first, second, result);
                    } else {
                        System.out.println("Ошибка при делении дробей!");
                    }
                    break;
            }
        }
    }

    /**
     * Выбирает дробь (Fraction4) из списка по пользовательскому выбору.
     *
     * @param fractions список дробей
     * @param prompt приглашение для пользователя
     * @return выбранная дробь
     */
    private static Fraction4 selectFraction4(List<Fraction4> fractions, String prompt) {
        System.out.println("\nДоступные дроби:");
        for (int i = 0; i < fractions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, fractions.get(i));
        }

        System.out.print(prompt + " ");
        return fractions.get(readIntInRange(1, fractions.size()) - 1);
    }

    /**
     * Запускает задание по работе с числами разных типов (5.1).
     */
    private static void runNumberTask() {
        System.out.println("\n Задание 5.1 ");

        List<Num> numbers = createNumbers();
        if (numbers.isEmpty()) {
            System.out.println("Не создано ни одного числа для работы.");
            return;
        }

        calculateSum(numbers);
    }

    /**
     * Создает список чисел разных типов на основе пользовательского ввода.
     *
     * @return список созданных чисел
     */
    private static List<Num> createNumbers() {
        System.out.print("Введите количество чисел для создания: ");
        int count = readPositiveInt();
        List<Num> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСоздание числа " + (i + 1) + " из " + count);
            System.out.println("Форматы ввода:");
            System.out.println("- Целое число (например, 5)");
            System.out.println("- Десятичная дробь (например, 3.14)");
            System.out.println("- Обыкновенная дробь (например, 2/3)");

            while (true) {
                System.out.print("Введите число: ");
                String input = scanner.next().trim();

                try {
                    Num number = parseNumber(input);
                    if (number != null) {
                        numbers.add(number);
                        System.out.println("Создано число: " + number);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: некорректный формат числа!");
                }
            }
        }

        return numbers;
    }

    /**
     * Парсит строку в число соответствующего типа.
     *
     * @param input строка для парсинга
     * @return объект числа или null, если парсинг не удался
     */
    private static Num parseNumber(String input) {
        if (input.contains("/")) {
            String[] parts = input.split("/");
            if (parts.length != 2) {
                System.out.println("Ошибка: дробь должна быть в формате a/b!");
                return null;
            }

            try {
                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);

                if (denominator == 0) {
                    System.out.println("Ошибка: знаменатель не может быть нулем!");
                    return null;
                }

                return new FracNum(numerator, denominator);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: числитель и знаменатель должны быть целыми числами!");
                return null;
            }
        } else if (input.contains(".")) {
            try {
                double value = Double.parseDouble(input);
                return new DoubNum(value);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный формат десятичной дроби!");
                return null;
            }
        } else {
            try {
                int value = Integer.parseInt(input);
                return new IntNum(value);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный формат целого числа!");
                return null;
            }
        }
    }

    /**
     * Вычисляет и выводит сумму всех чисел в списке.
     *
     * @param numbers список чисел для суммирования
     */
    private static void calculateSum(List<Num> numbers) {
        Addition addition = new Addition(numbers);
        System.out.println("\nСумма всех чисел: " + addition.summa());
    }

    /**
     * Запускает задание по возведению в степень (7.3).
     */
    private static void runExponentiationTask() {
        System.out.println("\nЗадание 7.3");

        System.out.print("Введите основание степени (целое число): ");
        String x = scanner.next();

        System.out.print("Введите показатель степени (целое число): ");
        String y = scanner.next();

        double result = exp(x, y);
        if (!Double.isNaN(result)) {
            System.out.printf("%s ^ %s = %.2f%n", x, y, result);
        }
    }

    /**
     * Вычисляет результат возведения числа в степень.
     *
     * @param x основание степени (строка)
     * @param y показатель степени (строка)
     * @return результат возведения в степень или NaN при ошибке
     */
    private static double exp(String x, String y) {
        try {
            int base = Integer.parseInt(x);
            int exponent = Integer.parseInt(y);
            return Math.pow(base, exponent);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: оба параметра должны быть целыми числами!");
            return Double.NaN;
        }
    }

    /**
     * Запускает задание по работе с точками (8.4).
     */
    private static void runPointTask() {
        System.out.println("\n Задание 8.4 ");

        List<Point> points = createPoints();
        if (points.isEmpty()) {
            System.out.println("Не создано ни одной точки для работы.");
            return;
        }

        performPointOperations(points);
    }

    /**
     * Создает список точек на основе пользовательского ввода.
     *
     * @return список созданных точек
     */
    private static List<Point> createPoints() {
        System.out.print("Введите количество точек для создания: ");
        int count = readPositiveInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nСоздание точки " + (i + 1) + " из " + count);

            double x = readDouble("координата X: ");
            double y = readDouble("координата Y: ");

            points.add(new Point(x, y));
            System.out.println("Создана точка: " + points.get(i));
        }

        return points;
    }

    /**
     * Выполняет операции с точками на основе пользовательского выбора.
     *
     * @param points список точек для операций
     */
    private static void performPointOperations(List<Point> points) {
        while (true) {
            printPointMenu();
            int operation = readIntInRange(0, 2);

            if (operation == 0) {
                return;
            }

            switch (operation) {
                case 1:
                    comparePoints(points);
                    break;
                case 2:
                    clonePoint(points);
                    break;
            }
        }
    }

    /**
     * Выводит меню операций с точками.
     */
    private static void printPointMenu() {
        System.out.println("\nМеню операций с точками:");
        System.out.println("1. Сравнить две точки");
        System.out.println("2. Клонировать точку");
        System.out.println("0. Назад");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Сравнивает две выбранные точки.
     *
     * @param points список точек
     */
    private static void comparePoints(List<Point> points) {
        if (points.size() < 2) {
            System.out.println("Нужно минимум 2 точки для сравнения!");
            return;
        }

        Point p1 = selectPoint(points, "Выберите первую точку:");
        Point p2 = selectPoint(points, "Выберите вторую точку:");

        if (p1.equals(p2)) {
            System.out.println("Точки одинаковые: " + p1 + " и " + p2);
        } else {
            System.out.println("Точки разные: " + p1 + " и " + p2);
        }
    }

    /**
     * Клонирует выбранную точку.
     *
     * @param points список точек
     */
    private static void clonePoint(List<Point> points) {
        Point original = selectPoint(points, "Выберите точку для клонирования:");
        Point clone = original.clone();

        System.out.println("Оригинальная точка: " + original);
        System.out.println("Клонированная точка: " + clone);
    }

    /**
     * Выбирает точку из списка по пользовательскому выбору.
     *
     * @param points список точек
     * @param prompt приглашение для пользователя
     * @return выбранная точка
     */
    private static Point selectPoint(List<Point> points, String prompt) {
        System.out.println("\nДоступные точки:");
        for (int i = 0; i < points.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, points.get(i));
        }

        System.out.print(prompt + " ");
        return points.get(readIntInRange(1, points.size()) - 1);
    }

    /**
     * Выбирает дробь из списка по пользовательскому выбору.
     *
     * @param fractions список дробей
     * @param prompt приглашение для пользователя
     * @return выбранная дробь
     */
    private static Fraction selectFraction(List<Fraction> fractions, String prompt) {
        System.out.println("\nДоступные дроби:");
        for (int i = 0; i < fractions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, fractions.get(i));
        }

        System.out.print(prompt + " ");
        return fractions.get(readIntInRange(1, fractions.size()) - 1);
    }

    /**
     * Считывает число с плавающей точкой с консоли.
     *
     * @param prompt приглашение для пользователя
     * @return введенное число
     */
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Ошибка: введите число!");
                scanner.next();
            }
        }
    }

    /**
     * Считывает целое число с консоли.
     *
     * @param prompt приглашение для пользователя
     * @return введенное число
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
        }
    }

    /**
     * Считывает положительное целое число с консоли.
     *
     * @return введенное положительное число
     */
    private static int readPositiveInt() {
        while (true) {
            int value = readInt("");
            if (value > 0) {
                return value;
            }
            System.out.println("Ошибка: число должно быть положительным!");
        }
    }

    /**
     * Считывает целое число в заданном диапазоне.
     *
     * @param min минимальное допустимое значение
     * @param max максимальное допустимое значение
     * @return введенное число из заданного диапазона
     */
    private static int readIntInRange(int min, int max) {
        while (true) {
            int value = readInt("");
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("Ошибка: число должно быть от %d до %d!%n", min, max);
        }
    }
}