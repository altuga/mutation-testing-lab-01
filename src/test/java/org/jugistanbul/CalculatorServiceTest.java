package org.jugistanbul;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class CalculatorServiceTest {

    @Test
    public void testAdd(){
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.add(1d, 1d);
        Assert.assertEquals(2, result, 0d);
    }

    @Test
    public void testDiv(){
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.div(1d, 1d);
        Assert.assertEquals(1, result, 0d);
    }

    @Test
    public void testMul(){
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.mul(10d, 1d);
        Assert.assertEquals(10, result, 0d);
    }




}
