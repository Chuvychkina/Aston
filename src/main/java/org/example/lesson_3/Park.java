package org.example.lesson_3;

import java.time.LocalTime;
import java.util.List;

public class Park {
    private String parkName;
    private Attraction[] attractions;
    private int attractionCount;

    public Park(String parkName, int attractionCount) {
        this.parkName = parkName;
        this.attractionCount = attractionCount;
    }

    // Внутренний класс для хранения информации об аттракционах
    public class Attraction {
        // Поле для хранения списка аттракционов (можно использовать массив или список)
        private List<Attraction> attractions;
        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;// Стоимость

        public List<Attraction> getAttractions() {
            return attractions;
        }

        public void setAttractions(List<Attraction> attractions) {
            this.attractions = attractions;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalTime getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(LocalTime openingTime) {
            this.openingTime = openingTime;
        }

        public LocalTime getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(LocalTime closingTime) {
            this.closingTime = closingTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        // Метод для вывода информации об аттракционе
        public void displayInfo() {
            System.out.printf("Аттракцион: %s%n", name);
            System.out.printf("Время открытия: %s%n", openingTime);
            System.out.printf("Время закрытия: %s%n", closingTime);
            System.out.printf("Стоимость: %s руб.%n", price);
            System.out.println("---");
        }
    }

    // Метод для вывода всех аттракционов парка
    public void displayAllAttractions() {
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
        }
    }
}