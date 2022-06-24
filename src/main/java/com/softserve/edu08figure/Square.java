package com.softserve.edu08figure;

public class Square implements Figure, IRight {
    private Figure rectangle;

    public Square(double width) {
        rectangle = new Rectangle(width, width);
    }

    public void setSize(double size) {
        ((Rectangle) rectangle).setWidth(size);
        ((Rectangle) rectangle).setHeight(size);
    }

    public void setWidth(double width) {
        setSize(width);
    }

    public void setSide(double... sides) {
        if (sides.length != 1) {
            throw new RuntimeException("Bug! This is Square");
        }
        setSize(sides[0]);

    }

    public double perimeter() {
        return rectangle.perimeter();
    }

    public double area() {
        return rectangle.area();
    }

    @Override
    public String toString() {
        return "Square{" +
                "rectangle=" + rectangle.toString() +
                '}';
    }
}
