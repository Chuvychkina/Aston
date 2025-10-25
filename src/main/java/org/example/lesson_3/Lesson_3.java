package org.example.lesson_3;

import java.time.LocalTime;

public class Lesson_3 {

    public static void main(String[] args) {
        // Создаем массив объектов
        Product[] productsArray = new Product[5];
        Park park = new Park("Disney Park", 10);  // Создаем парк
        Park.Attraction theBigEye = park.new Attraction("DisneyLand", LocalTime.parse("10:00") , LocalTime.parse("22:00"), 3000.0);  // Создаем аттракцион
        Park.Attraction rollerCoaster = park.new Attraction("Ostrov Park", LocalTime.parse("10:00") , LocalTime.parse("22:00"), 3000.0);  // Создаем аттракцион




        // Заполняем массив товарами
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro", "15.01.2024",
                "Apple Inc.", "USA", 6499, false);

        productsArray[2] = new Product("Xiaomi Mi 14", "10.03.2024",
                "Xiaomi Corporation", "China", 3499, true);

        productsArray[3] = new Product("MacBook Air M3", "20.11.2023",
                "Apple Inc.", "USA", 4599, false);

        productsArray[4] = new Product("Sony WH-1000XM5", "05.05.2023",
                "Sony Corporation", "Japan", 1299, true);

        // Выводим информацию о всех товарах
        System.out.println("=== ИНФОРМАЦИЯ О ВСЕХ ТОВАРАХ ===\n");

        for (int i = 0; i < productsArray.length; i++) {
            System.out.printf("Товар #%d:%n", i + 1);
            productsArray[i].printInfo();
            System.out.println();
        }
    }

}