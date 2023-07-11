/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aluraconverter;

/**
 *
 * @author bryan
 */
public class Temperatura {
    private static final String[] valores = { "°C", "K", "°F" };

    public static String[] getValores() {
        return valores;
    }

    public static double convertir(Double amount, String fromUnit, String toUnit) {
        double convertedAmount = 0.0;
        double gradosC;
        // Converitr a la unidad base C
        switch (fromUnit) {
            case "°C" -> gradosC = amount;
            case "K" -> gradosC = amount - 273.15;
            case "°F" -> gradosC = (amount - 32) / 1.8;
            default -> {
                // System.out.println("Unidad de masa no reconocida: " + fromUnit);
                return convertedAmount;
            }
        }

        // Convertir los grado centigrados a la unidad de destino
        switch (toUnit) {
            case "°C" -> convertedAmount = gradosC;
            case "K" -> convertedAmount = gradosC + 273.15;
            case "°F" -> convertedAmount = (gradosC * 1.8) + 32;
            default -> {
                // System.out.println("Unidad de masa no reconocida: " + toUnit);
                return convertedAmount;
            }
        }

        return convertedAmount;
    }
}
