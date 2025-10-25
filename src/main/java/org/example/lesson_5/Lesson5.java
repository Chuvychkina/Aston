package org.example.lesson_5;


import static org.example.lesson_5.SumArray.demonstrateArrayIndexOutOfBounds;
import static org.example.lesson_5.SumArray.sum4x4Array;

public class Lesson5 {
    public static void main(String[] args) {
        // Тест 1: Корректный массив
        testArray(new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        }, "Тест 1: Корректный массив 4x4");

        // Тест 2: Массив неправильного размера
        testArray(new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        }, "Тест 2: Массив неправильного размера");

        // Тест 3: Массив с некорректными данными
        testArray(new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"}, // Некорректные данные
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        }, "Тест 3: Массив с некорректными данными");

        // Тест 4: Массив с null значениями
        testArray(new String[][]{
                {"1", "2", "3", "4"},
                {"5", null, "7", "8"}, // null значение
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        }, "Тест 4: Массив с null значениями");

        // Тест 5: Неправильная структура массива
        testArray(new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6"}, // Неправильное количество столбцов
                {"7", "8", "9", "10"},
                {"11", "12", "13", "14"}
        }, "Тест 5: Неправильная структура массива");

        // Демонстрация ArrayIndexOutOfBoundsException
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");
        demonstrateArrayIndexOutOfBounds();

        // Дополнительные тесты
        System.out.println("\n=== Дополнительные тесты ===");

        // Тест с пустыми строками
        testArray(new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "", "8"}, // Пустая строка
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        }, "Тест с пустыми строками");

        // Тест с большими числами
        testArray(new String[][]{
                {"100", "200", "300", "400"},
                {"500", "600", "700", "800"},
                {"900", "1000", "1100", "1200"},
                {"1300", "1400", "1500", "1600"}
        }, "Тест с большими числами");
    }

    /**
     * Вспомогательный метод для выполнения теста массива.
     *
     * @param array       двумерный массив строк для тестирования
     * @param description описание теста
     */
    private static void testArray(String[][] array, String description) {
        System.out.println("\n=== " + description + " ===");
        try {
            int result = sum4x4Array(array);
            System.out.printf("Сумма элементов: %d%n", result);
        } catch (ArrayExceptionHandler.MyArraySizeException e) {
            System.out.printf("MyArraySizeException: %s%n", e.getMessage());
        } catch (ArrayExceptionHandler.MyArrayDataException e) {
            System.out.printf("MyArrayDataException: %s%n", e.getMessage());
        }
    }
}