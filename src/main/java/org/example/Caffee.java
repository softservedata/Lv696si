package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*Create interface DrinkReceipt with methods String getName() and DrinkReceipt addComponent(String componentName, int componentCount).
Create interface DrinkPreparation with method Map<String, Integer> makeDrink() to return a drink components.
Create interface Rating with method int getRating().
Class Caffee contains fields String name, int rating, Map of ingredients and implements interfaces DrinkReceipt, DrinkPreparation and Rating.
Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}.
Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink().
Espresso caffee has 50 g. of Water. Cappuccino caffee has an additional of 50 g. of Milk.
Create a averageRating() method of the MyUtils class to return a Map with coffee name as key and coffee average rating as value.
For example, for a given list
[Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6],
Caffee [name=Caffee, rating=6]]
you should get
{Espresso=9.00, Cappuccino=8.00, Caffee=6.00}*/

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

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating {

    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caffee caffee = (Caffee) o;
        return rating == caffee.rating && Objects.equals(name, caffee.name) && Objects.equals(ingredients, caffee.ingredients);
    }

    @Override
    public String toString() {
        return "Caffee{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, ingredients);
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        this.ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100).addComponent("Arabica", 20);
//        myMap.put("Water", 100);
//        myMap.put("Arabica", 20);

        return this.getIngredients();
    }
}
class Espresso extends Caffee {

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 50).addComponent("Arabica", 20);
//        myMap.put("Water", 50);
//        myMap.put("Arabica", 20);

        return this.getIngredients();
    }
}
class Cappuccino extends Caffee {

    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100).addComponent("Arabica", 20)
                .addComponent("Milk", 50);
//        myMap.put("Water", 100);
//        myMap.put("Arabica", 20);
//        myMap.put("Water", 50);

        return this.getIngredients();
    }
}
class MyUtils2 {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> ratings = new HashMap<>();
        double sumRatingCaffe = 0;
        double sumRatingEspresso = 0;
        double sumRatingCappuccino = 0;
        int totalCaffes = 0;
        int totalEspressos = 0;
        int totalCappuccinos = 0;

        for(Caffee caffee : coffees) {
            if (caffee == null)
                break;
            if (caffee instanceof Cappuccino) {
                totalCappuccinos++;
                sumRatingCappuccino += caffee.getRating();
            }
            if (caffee instanceof Espresso) {
                totalEspressos++;
                sumRatingEspresso += caffee.getRating();
            }
            if (caffee.getClass().equals(Caffee.class)) {
                totalCaffes++;
                sumRatingCaffe += caffee.getRating();
            }
        }

        if (totalEspressos != 0)
            ratings.put("Espresso", sumRatingEspresso/totalEspressos);
        if (totalCappuccinos != 0)
            ratings.put("Cappuccino", sumRatingCappuccino/totalCappuccinos);
        if (totalCaffes != 0)
            ratings.put("Caffee", sumRatingCaffe/totalCaffes);
        return ratings;
    }
}