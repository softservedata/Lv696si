package com.softserve.edu08rectangle;

public class Square extends Rectangle {

    public Square(double width) {
        super(width, width);
    }

    public void setSize(double size) {
        super.setWidth(size);
        super.setHeight(size);
    }

    @Override
    public void setWidth(double width) {
        setSize(width);
    }

    @Override
    public void setHeight(double height) {
        setSize(height);
    }

    @Override
    public String toString() {
        return "Square{" + super.toString() + "}";
    }
}
