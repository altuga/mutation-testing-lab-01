package org.jugistanbul;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        double value = calculatorService.add(1d,1d);
        assertEquals(2d, value);
    }

    @Test
    public void testSub() {
        CalculatorService calculatorService = new CalculatorService();
        double value = calculatorService.sub(10d, 1d);
        assertEquals(9d, value);

    }

    @Test
    public void testDiv() {
        CalculatorService calculatorService = new CalculatorService();
        double value = calculatorService.div(10d, 2d);
        assertEquals(5d,value);

    }

    @Test
    public void testMul() {
        CalculatorService calculatorService = new CalculatorService();
        double value = calculatorService.mul(5d, 2d);
        assertEquals(10d, value);

    }




}
