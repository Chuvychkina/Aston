package org.example.lesson_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    // Поля класса
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // Конструктор
    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = LocalDate.parse(productionDate, DATE_FORMATTER);
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации об объекте
    public void printInfo() {
        System.out.println("=== Информация о товаре ===");
        System.out.printf("Название: %s%n", name);
        System.out.printf("Дата производства: %s%n", productionDate.format(DATE_FORMATTER));
        System.out.printf("Производитель: %s%n", manufacturer);
        System.out.printf("Страна происхождения: %s%n", countryOfOrigin);
        System.out.printf("Цена: %s руб.%n", price);
        System.out.printf("Состояние бронирования: %s%n", isReserved ? "Забронирован" : "Свободен");
        System.out.println("============================");
    }
}