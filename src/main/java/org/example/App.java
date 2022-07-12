package org.example;
import java.math.BigDecimal;
import java.util.*;


public class App
{
    public static void main(String[ ] args) {

        /*Caffee{name='Espresso', rating=8, ingredients={}}
        Caffee{name='Cappuccino', rating=10, ingredients={}}
        Caffee{name='Caffee', rating=6, ingredients={}}*/

        Caffee caffee = new Caffee("Caffee", 6);
        Caffee cappuccino = new Cappuccino("Cappuccino", 10);
        Caffee espresso = new Espresso("Espresso", 8);
        MyUtils2 my = new MyUtils2();
        List<Caffee> list = new ArrayList<>();
        list.add(caffee);
        list.add(cappuccino);
        list.add(espresso);
        Map<String, Double> ratings = my.averageRating(list);
        for(Map.Entry<String, Double> entry : ratings.entrySet()){
            System.out.println(entry.toString());
        }
    }
}
