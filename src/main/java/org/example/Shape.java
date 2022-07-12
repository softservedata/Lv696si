package org.example;

import java.util.*;

/*Please create class Shape with abstract method to calculate area of figure and field name.
Replace code in method getArea() according to principles of polymorphism i.
Circle and Rectangle classes extends Shape class and override double getArea() method.
Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.
The original list must be unchanged.
For example, for a given list
[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00], Rectangle [height=3.00, width=2.00],
Circle [radius=0.50], Rectangle [height=1.00, width=2.00]]
you should get
[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Rectangle [height=3.00, width=2.00]]*/

abstract class Shape {

    private String name;

    public abstract double getArea();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Circle extends Shape {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}

class Rectangle extends Shape {

    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.height*this.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" + super.toString() +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.height, height) == 0 && Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, width);
    }
}