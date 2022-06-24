package com.softserve.edu08square;

public class Rectangle extends Square {
    private double height;

    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 2*(getWidth() + getHeight());
    }

    @Override
    public String toString() {
        return "Rectangle{" + super.toString() +
                ", height=" + height +
                '}';
    }
}
