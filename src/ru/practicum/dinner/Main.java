package ru.practicum.dinner;

import java.util.ArrayList;
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
            /* Комментарий Код Ревьюера - Ирек Валиев:
            после считывания информации через scanner.nextLine() лучше удалить из полученной строки пробельные
            символы при помощи метода trim(). Обычно человек не видит разницы между строкой "2" и  "2 " .
             Попробуй сам до изменения ввести второй вариант))*/
            command = command.trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                //  Ирек Валиев - можно добавить прощальное сообщение для пользователя
                    System.out.println("Всего Хорошего!");
                    return;
                default:
                    /* Ирек Валиев - можно добавить default блок, в котором будет выводиться пользователю сообщение,
                        если он ввел неверную команду*/
                    System.out.println("Неверная команда, попробуйте еще!");
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

        if (numberOfCombos > 0) {
            // основной структурой для хранения комбинаций будет список
            ArrayList<String> dishTypeComboSet = new ArrayList<>(); // Список для сбора заданных типов блюд

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). "
                    + "Для завершения ввода введите пустую строку");
            String nextItem = scanner.nextLine();
            nextItem = nextItem.trim();

            while (!nextItem.isEmpty()) { // Цикл ввода типов блюд, выход - двойное нажатие Enter
                if (dc.checkType(nextItem)) { // проверяем наличие типа блюда в ранее созданном меню
                    dishTypeComboSet.add(nextItem); // составляем список комбинаций типов блюд
                } else {
                    System.out.println("Такого типа блюда не существует, введите другой тип");
                }
                nextItem = scanner.nextLine();
            }

            System.out.println("-".repeat(20)); // для более удобного визуального представления информации

            for (int i = 1; i <= numberOfCombos; i++) {
                System.out.println("Комбо " + i);
                // генерируем комбинацию блюд в соответсвии с комбинацией типов и вывод на печать
                System.out.println(dc.genRandomCombo(dishTypeComboSet));
            }

            System.out.println("-".repeat(20)); // для более удобного визуального представления информации

        } else {
            System.out.println("Количество наборов должно быть положительным числом, отличным от 0!");
        }
    }
}