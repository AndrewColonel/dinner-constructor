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

    boolean checkType(String type) {
        return dishTypeToMenu.containsKey(type);
    }

   /* public void addDinnerMenu(String dishType, String dishName) {
        if (!dishTypeToMenu.containsKey(dishType)) {
            dishTypeToMenu.put(dishType, new ArrayList<>());
        }
        ArrayList<String> dishNames = new ArrayList<>();
        dishNames.add(dishName);
        dishTypeToMenu.put(dishType, dishNames);
    }*/

    public void addDinnerMenu(String dishType, String dishName) {
        if (dishTypeToMenu.containsKey(dishType)) {
            ArrayList<String> dishNames = dishTypeToMenu.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypeToMenu.put(dishType, dishNames);
        }
    }

    public void createRandomCombo(HashMap<String, ArrayList<String>> dishComboSets) {
        for (String comboNumber : dishComboSets.keySet()) { // перебираем все ключи Хэш таблицы с комбинациями
            // Хэш таблица точно содержит непустые ключи - КомбоХ
            ArrayList<String> dishComboSet = dishComboSets.get(comboNumber);
            if (!dishComboSet.isEmpty()) {
                // проверка заполнения списка комбинации, пока содержащих типы - могут быть пустыми
                for (int i = 0; i < dishComboSet.size(); i++) {
                    // for (String dishType : dishTypeSet) {
                    String dishType = dishComboSet.get(i);
                    // для каждого пользовательского набора типов формирую случайную выборку соответсвующих блюд
                    if (dishTypeToMenu.containsKey(dishType)) {
                        // дополнительно проверил наличи такого ключа, но он точно долджен быть там)
                        ArrayList<String> dishNames = dishTypeToMenu.get(dishType);
                        String randomDishName = dishNames.get(random.nextInt(dishNames.size()));
                        // делаем случайную выборку Названий блюд соответсвующего типа
                        dishComboSet.remove(i); // удаляю элемент списка с типов блюда
                        // и на это же место вношу элемент со "случайным" названием блюда
                        dishComboSet.add(i, randomDishName);
                        // получаем списко комбинаций уже со случайными названиями блюд в соответсвии с заданными типами
                    }
                }
            }
        }
    }
}

