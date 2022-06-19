package com.softserve.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public static void main(String[] args) throws Exception {
        int i = 2, j = 11;
        do {
            if (i++ > --j) continue;
        } while (i < 5);
        System.out.println("i=" + i + " j=" + j);
    }
}

public class MyTestClass{
    public static void main(String args[ ]) {
        if (true)
            if (false)
                System.out.println("True False");
            else
                System.out.println("True True");
    }
}
