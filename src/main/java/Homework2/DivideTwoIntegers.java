package Homework2;

public class DivideTwoIntegers {
        public int divide(int dividend, int divisor)
        {
            if(dividend==-2147483648 && divisor==-2147483648)
            {
                return 1;
            }
            else if(dividend==-2147483648 && divisor < 0)
            {
                return (dividend+1)/divisor;
            }
            else if(dividend==-2147483647 && divisor > 0)
            {
                return (dividend+1)/divisor;
            }

            else
            {
                return dividend/divisor;
            }
        }
    }



