package com.example.mockitoexample.service;


import com.example.mockitoexample.model.Calculator;

public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int performAddition(int a, int b) {
        return calculator.add(a, b);
    }
}
