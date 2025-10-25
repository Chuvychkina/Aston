package org.example.lesson_7;

public class NumberComparator {
    /**
     * Сравнивает два целых числа: возвращает -1 если a < b, 0 если a == b, 1 если a > b.
     * @param a первое число
     * @param b второе число
     * @return -1, 0 или 1 в зависимости от сравнения
     */
    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    /**
     * Проверяет, является ли первое число больше второго.
     * @param a первое число
     * @param b второе число
     * @return true, если a > b
     */
    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    /**
     * Проверяет, является ли первое число меньше второго.
     * @param a первое число
     * @param b второе число
     * @return true, если a < b
     */
    public static boolean isLess(int a, int b) {
        return a < b;
    }

    /**
     * Проверяет равенство двух чисел.
     * @param a первое число
     * @param b второе число
     * @return true, если a == b
     */
    public static boolean isEqual(int a, int b) {
        return a == b;
    }
}
