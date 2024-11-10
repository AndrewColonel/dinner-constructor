package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypeToMenu;

    public DinnerConstructor() {
        dishTypeToMenu = new HashMap<>();
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


}
