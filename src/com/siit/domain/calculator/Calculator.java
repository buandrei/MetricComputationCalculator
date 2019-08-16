package com.siit.domain.calculator;

import com.siit.domain.validator.ValidationException;

import java.io.StringReader;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Calculator {

    public int calculate(String expresie, String marimeDorita) throws ValidationException {

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

                        // int numar = Integer.parseInt(expresiiMinus[j].split(" ")[0]);
                        int numar = checkNumber(expresiiMinus[j], 0);
                        // String marime = expresiiMinus[j].split(" ")[1];
                        String marime = checkMarime(expresiiMinus[j], 1);
                        int indexMarime = getIndex(marime);

                        double diferentaScara = valMarimi[indexMarimeDorita] / valMarimi[indexMarime];

                        double numarDeScazut = diferentaScara * numar;
                        numarFinal = numarFinal - numarDeScazut;
                    }

                }

                //int numar = Integer.parseInt(expresiiPlus[i].split(" ")[0]);
                int numar = checkNumber(expresiiPlus[i], 0);

                //String marime = expresiiPlus[i].split(" ")[1];
                String marime = checkMarime(expresiiPlus[i], 1);

                int indexMarime = getIndex(marime);

                double diferentaScara = valMarimi[indexMarimeDorita] / valMarimi[indexMarime];

                double numarDeAdunat = diferentaScara * numar;
                numarFinal = numarFinal + numarDeAdunat;

            }
        } else if (expresie.contains("*") || expresie.contains("/")) {

            throw new ValidationException("Only + or - allowed!");

        }

        return (int) numarFinal;
    }

    private static int checkNumber(String expresie, int index) {
        int result;

        String expresie_reala = expresie;
        if (expresie.split(" ")[0] == expresie_reala) {
            expresie_reala = expresie.split("(?<=[0-9])(?=[a-zA-Z])")[0] + " " + expresie.split("(?<=[0-9])(?=[a-zA-Z])")[1];
        }

        result = Integer.parseInt(expresie_reala.split(" ")[0]);
        return result;

    }

    private static String checkMarime(String expresie, int index) {
        String result;

        String expresie_reala = expresie;

        if (expresie.split(" ")[0] == expresie_reala) {
            expresie_reala = expresie.split("(?<=[0-9])(?=[a-zA-Z])")[0] + " " + expresie.split("(?<=[0-9])(?=[a-zA-Z])")[1];

        }

        result = expresie_reala.split(" ")[1];
        return result;

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
