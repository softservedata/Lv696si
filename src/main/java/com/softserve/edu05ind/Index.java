package com.softserve.edu05ind;

public interface Index {

    long getCheckSum(String current);
    int getIndex(long checkSum);
    int getIndex(String text);
}
