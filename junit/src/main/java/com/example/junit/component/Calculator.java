package com.example.junit.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int a, int b) {
        this.iCalculator.init();
        return this.iCalculator.sum(a, b);
    }

    public int minus(int a, int b) {
        this.iCalculator.init();
        return this.iCalculator.minus(a, b);
    }
}
