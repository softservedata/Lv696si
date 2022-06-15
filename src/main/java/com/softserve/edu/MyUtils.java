package com.softserve.edu;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Hello world!
 */
interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    String name;
    int rating;
    Map<String, Integer> ingredients;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        return null;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return null;
    }

    @Override
    public int getRating() {
        return 0;
    }
}

class Espresso extends Caffee {
    // Code
}

class Cappuccino extends Caffee {
    // Code
}

public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> result = new HashMap<>();
        return result;
    }
}