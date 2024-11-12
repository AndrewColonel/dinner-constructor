package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypeToMenu;
    Random random = new Random();

    public DinnerConstructor() {
        dishTypeToMenu = new HashMap<>();
    }

    boolean checkType(String type) { // Метод для проверки неаличия запрашиваемого типа в общем меню обедов
        return dishTypeToMenu.containsKey(type);
    }

    public void addDinnerMenu(String dishType, String dishName) {
        // Метод для сбора общего меню обеда в Хэш таблицу - типы блюд и соответсвующие типу названия
        if (dishTypeToMenu.containsKey(dishType)) {
            ArrayList<String> dishNames = dishTypeToMenu.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypeToMenu.put(dishType, dishNames);
        }
    }

    public ArrayList<String> genRandomCombo(ArrayList<String> dishTypeComboSet) {
        /* метод генерации случайных комбинаций названий в соотвествии с типами блюд
         в качестве аргумента принимает собранны списко комбинаций типов
         и создает соответсвующий  список комбинаций названий.*/
        ArrayList<String> dishNameComboSet = new ArrayList<>(); // Список для хранения полученных комбинаций навазний
        if (!dishTypeComboSet.isEmpty()) {
            for (String dishType : dishTypeComboSet) {
                if (dishTypeToMenu.containsKey(dishType)) {
                    ArrayList<String> dishNames = dishTypeToMenu.get(dishType);
                    int randomNumber = random.nextInt(dishNames.size());
                    String dishName = dishNames.get(randomNumber);
                    dishNameComboSet.add(dishName);
                }
            }
        }
        return dishNameComboSet;
    }
}