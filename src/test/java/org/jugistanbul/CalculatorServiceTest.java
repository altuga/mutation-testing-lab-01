package org.jugistanbul;

import org.junit.Test;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.add(1d,1d );
    }

    @Test
    public void testSub() {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.sub(1d, 1d);
    }

    @Test
    public void testDiv() {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.div(1d, 1d);
    }

    @Test
    public void testMul() {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.mul(1d, 1d);
    }
}
