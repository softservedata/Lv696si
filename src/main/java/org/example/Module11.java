package org.example;

import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

/* Create a method for calculating an area of a rectangle int squareRectangle(int a, int b),
which should throw an IllegalArgumentException if at least one of its arguments is negative.

Create trySquareRectangle method which takes two parameters and calls squareRectangle to evaluate an area of a rectangle.
Catch exceptions that can be generated.

trySquareRectangle shouldn't generate any exceptions. In case when one or two parameters are negative
the method should return 0; */

class M11Task1 {

    public static int squareRectangle(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException();
        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        int result = 0;
        try {
            result = squareRectangle(a, b);
        } catch (Exception e) {
            return 0;
        }
        return result;
    }
}

/* Create a class Plant, which includes private fields String name, Color color and Type type, and constructor
with three String parameters   (String type, String color, String name) where these fields are initialized.
Create getters for all fields.
Color and Type are Enum.
Color contains White, Red, Blue entries.
Type contains Rare and Ordinary entries.
Override the method toString( ) for Plant class which returns result formatted like following:
{type: Rare, color: Red, name: MyPlant}
Create classes ColorException and TypeException as derived from Exception. Both classes should have
a constructor with one String parameter and pass this parameter to the base class.
The constructor of Plant should throw a corresponding exception whenever an inappropriate parameter is passed. */

class M11Task2 {
    String name;
    Color color;
    Type type;

    public M11Task2(String type, String color, String name) throws TypeException, ColorException{
        String checkColor = color.toUpperCase();
        String checkType = type.toUpperCase();
        Color myColor;
        Type myType;

        if (checkColor.equals("WHITE") || checkColor.equals("RED") || checkColor.equals("BLUE"))
            myColor = Color.valueOf(checkColor);
        else
            throw new ColorException("Invalid value " + color + " for field color");
        if (checkType.equals("RARE") || checkType.equals("ORDINARY"))
            myType = Type.valueOf(checkType);
        else
            throw new TypeException("Invalid value " + type + " for field type");

        this.name = name;
        this.color = myColor;
        this.type = myType;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type +
                ", color: " + color +
                ", name: " + name +
                '}';
    }
}

class ColorException extends Exception {
    ColorException(String str) {
        super(str);
    }
}

class TypeException extends Exception {
    TypeException(String str) {
        super(str);
    }
}

enum Color {
    WHITE, RED, BLUE;
}

enum Type {
    RARE, ORDINARY;
}

/* Suppose, we class Plant from the previous task, which includes private fields String name,
Color color and Type type, and constructor with three String parameters where these fields are initialized.
Color and Type are Enum.
Color contains White, Red, Blue entries.
Type contains Rare and Ordinary entries.

And we have classes ColorException and TypeException as derived from Exception.

The constructor of Plant throws a corresponding exception whenever an inappropriate parameter is passed:
String type, String color, String name.
Write a static tryCreatePlant method that takes 3 string parameters - type, color and name and returns an instance of
Plant, created based on passed params. (Don't create any classes, write as if you are already inside a class.)
The tryCreatePlant method should catch exceptions that can be thrown by Plant constructor. If inappropriate type
passed as a parameter, a Plant object should be returned anyway, with Ordinary type. If an inappropriate color
is passed, set Red color for created instance. */

class M11Task3 {

    public static M11Task2 tryCreatePlant(String type, String color, String name) {
        M11Task2 newPlant;
        try {
            newPlant = new M11Task2(type, color, name);
        } catch (TypeException e) {
            newPlant = tryCreatePlant("ORDINARY", color, name);
        } catch (ColorException e) {
            newPlant = tryCreatePlant(type, "RED", name);
        }
        return newPlant;
    }
}

/* We have the class PrintStackTraceDemo with four methods: a, m, t, x.
One of the methods of PrintStackTraceDemo throws IOException,
the other one catches the exception and prints a stack trace.

We have this part of stack trace that was generated in PrintStackTraceDemo class:

java.io.IOException
     PrintStackTraceDemo.t(__tester__.java:19)
     PrintStackTraceDemo.m(__tester__.java:27)
     PrintStackTraceDemo.a(__tester__.java:23)
     PrintStackTraceDemo.x(__tester__.java:8)

Please, fill in the gaps in the code of the PrintStackTraceDemo class so that the stack trace will remain the same. */

class M11Task4 {
    public static void x(){
        try{
            a();
        }
        catch (IOException ioe){ //this way of stack trace output is workaround for moodle
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            ioe.printStackTrace(ps);
            System.out.println(byteArrayOutputStream);
        }
    }

    public static void t() throws IOException{
        throw new IOException();
    }

    static void a() throws IOException   {
        m();
    }

    static void m() throws IOException   {
        t();
    }
}

/* Please, create a class for the exception (automatically enforced by the Handle or Declare Rule) that is used in
the code below so that it will compile without errors:

class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
       this.number = number;
    }

    public void deposit(double amount) {
       balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
       if(amount <= balance) {
          balance -= amount;
       }else {
          double needs = amount - balance;
          throw new InsufficientAmountException(needs);
       }
    }
    // some other code
 }
 class BankDemo {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}


The output of the doOperations invocation looks like this:
Sorry, but you are short $200.0
Please, deposit at least $200.0
     **standard stack trace output** */

class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
        if(amount <= balance) {
            balance -= amount;
        }else {
            double needs = amount - balance;
            throw new InsufficientAmountException(needs);
        }
    }
    // some other code
}
class M11Task5 {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}

class InsufficientAmountException extends Exception {

    private double amount;
    InsufficientAmountException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return "Sorry, but you are short $" + amount;
    }
}