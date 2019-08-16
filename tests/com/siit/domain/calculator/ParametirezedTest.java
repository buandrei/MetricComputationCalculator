package com.siit.domain.calculator;

import com.siit.domain.validator.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametirezedTest {
    private Calculator calculator = new Calculator();

    private String input, marimeDorita;
    private int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"10 cm + 10cm", "cm", 20}
        });
    }

    public ParametirezedTest(String input, String marimeDorita, int expected) {
        this.input = input;
        this.marimeDorita = marimeDorita;
        this.expected = expected;
    }

    @Test
    public void calculate() throws ValidationException {

        assertEquals(calculator.calculate(input, marimeDorita), expected);

    }

}