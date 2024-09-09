package com.example.mockitoexample;


import com.example.mockitoexample.model.Calculator;
import com.example.mockitoexample.service.CalculatorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorServiceTest {

    private Calculator calculator;
    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        calculator = Mockito.mock(Calculator.class);
        calculatorService = new CalculatorService(calculator);
    }

    @Test
    public void testPerformAddition() {
        when(calculator.add(5, 5)).thenReturn(10);

        int result = calculatorService.performAddition(5, 5);

        assertEquals(10, result);

        verify(calculator).add(5, 5);
    }

    @Test
    public void testPerformAdditionWithDifferentValues() {
        when(calculator.add(7, 8)).thenReturn(15);

        int result = calculatorService.performAddition(7, 8);

        assertEquals(15, result);

        verify(calculator).add(7, 8);
    }

    @Test
    public void testPerformAdditionWithNegativeValues() {
        when(calculator.add(-5, 4)).thenReturn(-1);

        int result = calculatorService.performAddition(-5, 4);

        assertEquals(-1, result);

        verify(calculator).add(-5, 4);
    }

    @Test
    public void testPerformAdditionWithZeroValues() {
        when(calculator.add(0, 0)).thenReturn(0);

        int result = calculatorService.performAddition(0, 0);

        assertEquals(0, result);

        verify(calculator).add(0, 0);
    }
}
