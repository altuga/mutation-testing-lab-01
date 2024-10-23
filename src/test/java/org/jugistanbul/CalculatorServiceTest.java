package org.jugistanbul;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.add(1d, 1d);
        Assert.assertEquals(result, 2d, 0d);
    }

    @Test
    public void testSub() {
        CalculatorService calculatorService= new CalculatorService();
        double result = calculatorService.sub(5d,3d);
        Assert.assertEquals(result, 2d, 0d);
    }

    @Test
    public void testMultiply() {
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.mul(5d, 2d);
        Assert.assertEquals(result, 10, 0d);
    }

    @Test
    public void testDivide() {
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.div(10d, 5d);
        Assert.assertEquals(result, 2, 0d);
    }

}
