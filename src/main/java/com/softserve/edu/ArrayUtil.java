package com.softserve.edu;


public class ArrayUtil {

    static double averageValue (Array<? extends Number> array){
        double sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum += array.getIndex(i).doubleValue();
        }
        return sum/array.length();
    }

}
class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T getIndex(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}