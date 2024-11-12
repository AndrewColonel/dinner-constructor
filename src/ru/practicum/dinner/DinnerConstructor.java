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

    public ArrayList<String> genRandomCombo(ArrayList<String> dishTypeComboSet) {
        ArrayList<String> dishNameComboSet = new ArrayList<>();
        if (!dishTypeComboSet.isEmpty()) {

            for (String dishType : dishTypeComboSet) {
                if (dishTypeToMenu.containsKey(dishType)) {
                    ArrayList<String> dishNames = dishTypeToMenu.get(dishType);
//                    int randomNumber = random.nextInt(dishNames.size());
//                    System.out.println(randomNumber);
                    String dishName = dishNames.get(random.nextInt(dishNames.size()));
                    dishNameComboSet.add(dishName);
                }
            }

        }
        return dishNameComboSet;

    }
}



