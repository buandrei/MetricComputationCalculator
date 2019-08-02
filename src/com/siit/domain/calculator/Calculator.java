package com.siit.domain.calculator;

import com.siit.domain.validator.ValidationException;

import java.util.Arrays;
import java.util.regex.Pattern;


public class Calculator {

    public double calculate(String expresie, String marimeDorita) throws ValidationException {

        double[] valMarimi = {1000000.0, 100000.0, 10000.0, 1000.0, 1.0};

        int indexMarimeDorita = getIndex(marimeDorita);

        String[] expresiiPlus;
        String[] expresiiMinus;

        double numarFinal = 0;

        if (expresie.contains("+")) {

            expresiiPlus = expresie.split(Pattern.quote(" + "));

            for (int i = 0; i < expresiiPlus.length; i++) {

                if (expresiiPlus[i].contains("-")) {

                    expresiiMinus = expresiiPlus[i].split(" - ");

                    for (int j = 1; j < expresiiMinus.length; j++) {

                        int numar = Integer.parseInt(expresiiMinus[j].split(" ")[0]);
                        String marime = expresiiMinus[j].split(" ")[1];
                        int indexMarime = getIndex(marime);

                        double diferentaScara = valMarimi[indexMarimeDorita] / valMarimi[indexMarime];

                        double numarDeScazut = diferentaScara * numar;
                        numarFinal = numarFinal - numarDeScazut;
                    }

                }

                int numar = Integer.parseInt(expresiiPlus[i].split(" ")[0]);
                String marime = expresiiPlus[i].split(" ")[1];
                int indexMarime = getIndex(marime);

                double diferentaScara = valMarimi[indexMarimeDorita] / valMarimi[indexMarime];

                double numarDeAdunat = diferentaScara * numar;
                numarFinal = numarFinal + numarDeAdunat;

            }
        } else if (expresie.contains("*") || expresie.contains("/")) {

            throw new ValidationException("Only + or - allowed!");

        }

        return numarFinal;
    }


    private static int getIndex(String marime) throws ValidationException {

        String[] marimi = {"mm", "cm", "dm", "m", "km"};

        if (!Arrays.asList(marimi).contains(marime)) {
            throw new ValidationException("Metric system `" + marime + "` not found!");
        }

        int index = -1;
        for (int i = 0; i < marimi.length; i++) {
            if (marimi[i].equals(marime)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
