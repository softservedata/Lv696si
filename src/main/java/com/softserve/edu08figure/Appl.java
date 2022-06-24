package com.softserve.edu08figure;

public class Appl {

    public double bigMethod(Figure object) {
        // ...
        object.setSide(5, 4);
        if (object.perimeter() != 18) {
            throw new RuntimeException("Bug!");
        }
        return object.perimeter();
    }

    public double bigMethod2(Figure object) {
        // ...
        object.setSide(5);
        if (object.perimeter() != 20) {
            throw new RuntimeException("Bug!");
        }
        return object.perimeter();
    }

    public static void main(String[] args) {
        Appl app = new Appl();
        Figure figure = new Square(2);
        //Figure figure = new Rectangle(2, 3);
        System.out.println("figure = " + figure + " perimeter = " + figure.perimeter());
        System.out.println("bigMethod perimeter = " + app.bigMethod2(figure));
        System.out.println("figure = " + figure + " perimeter = " + figure.perimeter());
    }
}
