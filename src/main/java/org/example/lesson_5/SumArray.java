package org.example.lesson_5;

public class SumArray {
    /*
             Метод для суммирования элементов двумерного массива 4x4
    */
    public static int sum4x4Array(String[][] array) throws ArrayExceptionHandler.MyArraySizeException, ArrayExceptionHandler.MyArrayDataException {
        // Проверка размера массива
        if (array == null) {
            throw new ArrayExceptionHandler.MyArraySizeException("Массив не может быть null");
        }

        if (array.length != 4) {
            throw new ArrayExceptionHandler.MyArraySizeException("Массив должен иметь 4 строки, но имеет: %d".formatted(array.length));
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new ArrayExceptionHandler.MyArraySizeException(
                        String.format("Строка %d должна иметь 4 столбца, но имеет: %d",
                                i, array[i] == null ? 0 : array[i].length)
                );
            }
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    // Бросаем кастомное исключение с информацией о ячейке
                    throw new ArrayExceptionHandler.MyArrayDataException(
                            String.format("Неверные данные в ячейке [%d][%d]: '%s'", i, j, array[i][j])
                    );
                }
            }
        }

        return sum;
    }

    /*
             Метод для генерации и поимки ArrayIndexOutOfBoundsException
     */
    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");

        int[] array = {1, 2, 3, 4, 5};

        try {
            // Попытка доступа к несуществующему индексу
            System.out.println("Попытка доступа к array[10]:");
            int value = array[10]; // Это вызовет ArrayIndexOutOfBoundsException
            System.out.printf("Значение: %d%n", value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.printf("Сообщение: %s%n", e.getMessage());
            System.out.printf("Длина массива: %d%n", array.length);
            System.out.println("Запрошенный индекс: 10");
        }

        try {
            // Попытка доступа к отрицательному индексу
            System.out.println("\nПопытка доступа к array[-1]:");
            int value = array[-1]; // Это также вызовет ArrayIndexOutOfBoundsException
            System.out.printf("Значение: %d%n", value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.printf("Сообщение: %s%n", e.getMessage());
            System.out.println("Запрошенный индекс: -1");
        }
    }
}