package com.siit.domain;

import com.siit.domain.calculator.Calculator;
import com.siit.domain.validator.ValidationException;

/*
Junit-4.10 JAR needed
 */
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String expresie = "10 mm + 1 mm - 9 mm";
        String marimeDorita = "mm";

        try {
            double rezultat = calculator.calculate(expresie, marimeDorita);
            System.out.println(rezultat);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

    }


}
