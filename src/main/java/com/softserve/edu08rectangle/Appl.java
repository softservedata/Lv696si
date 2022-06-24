package com.softserve.edu08rectangle;

public class Appl {

    public double bigMethod(Rectangle object) {
        // ...
        object.setWidth(5);
        // object is not Square
        object.setHeight(4);
        if (object.perimeter() != 18 ) {
            throw new RuntimeException("Bug!");
        }
        return object.perimeter();
    }

    public static void main(String[] args) {
        Appl app = new Appl();
        //Rectangle figure = new Rectangle(2, 3);
        Rectangle figure = new Square(2);
        System.out.println("figure = " + figure + " perimeter = " + figure.perimeter());
        System.out.println("bigMethod perimeter = " + app.bigMethod(figure));
        System.out.println("figure = " + figure + " perimeter = " + figure.perimeter());
    }
}
