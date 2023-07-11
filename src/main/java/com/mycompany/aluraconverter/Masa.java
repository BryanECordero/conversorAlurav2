/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aluraconverter;

/**
 *
 * @author bryan
 */
public class Masa {
    private static String[] valores = { "kg", "lb", "g", "oz", "Ton metrica", "Ton corta" };

    public static String[] getValores() {
        return valores;
    }

    public static double convertir(Double amount, String fromUnit, String toUnit) {
        double convertedAmount = 0.0;
        // Convertir la cantidad a gramos como unidad base
        double grams;
        switch (fromUnit.toLowerCase()) {
            case "kg" -> grams = amount * 1000;
            case "g" -> grams = amount;
            case "lb" -> grams = amount * 453.59237;
            case "ton metrica" -> grams = amount * Math.pow(10, 6);
            case "ton corta" -> grams = amount * 907185;
            case "oz" -> grams = amount * 28.3495;
            default -> {
                // System.out.println("Unidad de masa no reconocida: " + fromUnit);
                return convertedAmount;
            }
        }

        // Convertir los gramos a la unidad de destino
        switch (toUnit.toLowerCase()) {
            case "kg" -> convertedAmount = grams / 1000;
            case "g" -> convertedAmount = grams;
            case "lb" -> convertedAmount = grams / 453.59237;
            case "ton metrica" -> convertedAmount = grams / Math.pow(10, 6);
            case "ton corta" -> convertedAmount = grams / 907185;
            case "oz" -> convertedAmount = grams / 28.3495;
            default -> {
                // System.out.println("Unidad de masa no reconocida: " + toUnit);
                return convertedAmount;
            }
        }

        return convertedAmount;
    }
}

