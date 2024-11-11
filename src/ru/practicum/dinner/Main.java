package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDinnerMenu(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). "
                + "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        HashMap<String, ArrayList<String>> dishComboSets = new HashMap<>();
        ArrayList<String> dishComboSet = new ArrayList<>();
        /* Хэш таблица для предвармительного сбора списка по типам блюд. Ключами будут номерные названия заданного
        кол-ва комбинаций, полями - заготовка списков, содержащих пока список выбранных пользователем
        типов комбинаций. */
        while (!nextItem.isEmpty()) { // Цикл ввода типов блюд, выход - двойное нажатие Enter
            if (dc.checkType(nextItem)) { // проверяем наличие типа блюда в ранее созданном меню
                dishComboSet.add(nextItem); // составляем комбинацию типов блюд
            } else {
                System.out.println("Такого типа блюда не существует, введите другой тип");
            }
            nextItem = scanner.nextLine();
        }

        for (int i = 1; i <= numberOfCombos;  i++) {
            // Заполняем Хэш таблицу заготовками комбинаций и номерными названиями ключей
            dishComboSets.put("Комбо "+ i, dishComboSet);
        }

        dc.createRandomCombo(dishComboSets); // генерируем комбинацию блюд

        System.out.println(dishComboSets); // вывод комбинаций на экран
    }
}
