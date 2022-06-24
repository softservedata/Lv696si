package com.softserve.edu08figure;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setSide(double... sides) {
        if (sides.length != 2) {
            throw new RuntimeException("Bug!");
        }
        setWidth(sides[0]);
        setHeight(sides[1]);
    }

    public double perimeter() {
        return 2 * (getWidth() + getHeight());
    }

    public double area() {
        return getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
