package com.example.junit.basic;

public class KrwCalculator implements ICalculator{

    private int price = 1;

    @Override
    public int sum(int a, int b) {
        a *= price;
        b *= price;

        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        a *= price;
        b *= price;

        return a - b;
    }
}
