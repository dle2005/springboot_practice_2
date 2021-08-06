package com.example.junit.basic;

public class Calculator {

    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int sum(int a, int b) {
        return this.iCalculator.sum(a, b);
    }

    public int minus(int a, int b) {
        return this.iCalculator.minus(a, b);
    }
}
