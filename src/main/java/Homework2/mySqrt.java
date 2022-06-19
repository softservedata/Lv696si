package Homework2;

public class mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrtt(16));
    }

    public static int mySqrtt(int x) {
        int count = 0;
        for (int i = 1; ; i += 2) {
            x -= i;
            if (x < 0)
                return count;
            count++;
        }
    };
}



