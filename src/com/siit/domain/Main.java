package com.siit.domain;

import com.siit.domain.calculator.Calculator;
import com.siit.domain.validator.ValidationException;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.StringReader;
import java.time.Duration;
import java.time.Instant;

/*
Junit-4.10 JAR needed
 */
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String expresie = "10mm + 1 mm - 9mm";
        String marimeDorita = "mm";

        BufferedReader bufferedReader = new BufferedReader(new StringReader(expresie));

        try {
            System.out.println("Simple string expression");
            Instant start = Instant.now();
            int rezultat = calculator.calculate(expresie, marimeDorita);
            Instant stop = Instant.now();
            System.out.println("The result is " + rezultat);

            Duration duration = Duration.between(start, stop);
            System.out.println("Duration for simple String input is : " + duration);

            System.out.println("\n Let's try with the Buffered reader");

            Instant start1 = Instant.now();
            String expression = bufferedReader.readLine();
            int rezultat2 = calculator.calculate(expression, marimeDorita);
            System.out.println("The second result is " + rezultat2);
            Instant stop2 = Instant.now();
            System.out.println("The result is " + rezultat2);
            Duration duration1 = Duration.between(start1, stop2);
            System.out.println("Duration for simple String input is : " + duration1);


        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
