package com.softserve.edu08square;

public class Appl {

    public double bigMethod(Square object) {
        // ...
        object.setWidth(5);
        if (object.perimeter() != 20) {
            throw new RuntimeException("Bug!");
        }
        return object.perimeter();
    }

    public static void main(String[] args) {
        Appl app = new Appl();
        //Square figure = new Square(2);
        Square figure = new Rectangle(2, 3);
        System.out.println("figure = " + figure);
        System.out.println("perimeter = " + app.bigMethod(figure));
    }
}
