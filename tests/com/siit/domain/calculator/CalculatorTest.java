package com.siit.domain.calculator;

import com.siit.domain.validator.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test(expected = ValidationException.class)
    public void testWhenInputIsWrong() throws ValidationException {
        String expresie = "10 mmA + 1 mm";
        String marimeDorita = "cm";
        calculator.calculate(expresie, marimeDorita);
        fail("should have thrown validation exception");
    }

    @Test
    public void testCorrectComputation() throws ValidationException {
        String expresie = "10 cm + 1 m - 10 mm";
        String marimeDorita = "mm";
        assertEquals(1090, calculator.calculate(expresie, marimeDorita), 0.0001);
    }


}