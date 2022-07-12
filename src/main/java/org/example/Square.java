package org.example;

//Create classes Square and Rectang with method (double getPerimeter()) for calculating of perimeter.
//Find solution for avoiding of duplicate code.
//Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return a sum perimeters of all figures.
//For example, for a given list [[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
//you should get 46

public class Square {
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Square(double width) {
        this.width = width;
    }

    public double getPerimeter() {
        return this.getWidth()*4;
    }
}

class Rectang extends Square{
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectang(double width, double height) {
        super(width);
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return this.getHeight()*2 + this.getWidth()*2;
    }
}