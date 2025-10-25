package org.example.lesson_4.abstract_class;

public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        if (initialFood >= 0) {
            this.foodAmount = initialFood;
        } else {
            this.foodAmount = 0;
            System.out.println("Количество еды не может быть отрицательным. Установлено 0.");
        }
    }

    // Метод для уменьшения количества еды
    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть положительным");
            return false;
        }

        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.printf("Из миски взято %d еды. Осталось: %d%n", amount, foodAmount);
            return true;
        } else {
            System.out.printf("В миске недостаточно еды! Требуется: %d, доступно: %d%n", amount, foodAmount);
            return false;
        }
    }

    // Метод для добавления еды в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.printf("В миску добавлено %d еды. Теперь в миске: %d%n", amount, foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }

    // Геттер для текущего количества еды
    public int getFoodAmount() {
        return foodAmount;
    }

    // Метод для отображения информации о миске
    public void displayInfo() {
        System.out.printf("В миске %d еды%n", foodAmount);
    }
}
