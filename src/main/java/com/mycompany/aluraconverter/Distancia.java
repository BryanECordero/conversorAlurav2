/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aluraconverter;

/**
 *
 * @author bryan
 */
public class Distancia {
    private static final String[] valores = { "m", "km", "cm", "mm", "in", "ft", "yd", "mi" };

    public static String[] getValores() {
        return valores;
    }

    public static double convertir(Double amount, String fromUnit, String toUnit) {
        double convertedAmount = 0.0;
        // Convertir la cantidad a metros como unidad base
        double metros;
        switch (fromUnit) {
            case "m" -> metros = amount;
            case "km" -> metros = amount * 1000;
            case "cm" -> metros = amount * 0.01;
            case "in" -> metros = amount * 0.0254;
            case "ft" -> metros = amount * 0.3048;
            case "yd" -> metros = amount * 0.9144;
            case "mi" -> metros = amount * 1609.34;
            case "mm" -> metros = amount * 0.001;
            default -> {
                // System.out.println("Unidad de masa no reconocida: " + fromUnit);
                return convertedAmount;
            }
        }

        // Convertir los metros a la unidad de destino
        switch (toUnit) {
            case "m":
                convertedAmount = metros;
                break;
            case "km":
                convertedAmount = metros / 1000;
                break;
            case "cm":
                convertedAmount = metros / 0.01;
                break;
            case "in":
                convertedAmount = metros / 0.0254;
                break;
            case "ft":
                convertedAmount = metros / 0.3048;
                break;
            case "yd":
                convertedAmount = metros / 0.9144;
                break;
            case "mi":
                convertedAmount = metros / 1609.34;
                break;
            case "mm":
                convertedAmount = metros / 0.001;
            default:
                // System.out.println("Unidad de masa no reconocida: " + toUnit);
                return convertedAmount;
        }

        return convertedAmount;
    }
}

