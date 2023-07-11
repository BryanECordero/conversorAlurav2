/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aluraconverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author bryan
 */
public class Monedas {
    private static final String[] valores = { "USD", "BRL", "CAD", "CHF", "CNY", "EUR", "HKD", "INR", "JPY", "KRW", "MXN", "RUB", "TRY", "GBP" };
    private static HashMap<String, Double> tasas = new HashMap<String, Double>();
    private static final double[] tasasDefault = { 1.0, 4.8414067082, 1.3225068815,
            0.8968464954, 7.2145132785, 0.9188009699,
            7.8314651747, 82.0074951476, 144.4092295751, 1296.5017208432,
            17.050523726, 90.0001652524, 25.9801450207, 0.7863409533};
    private static LocalDateTime fechaActualizacion = LocalDateTime.of(2023, 7, 4,0,0,0);

    public static String[] getValores() {
        return valores;
    }

    public static LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public static void actulizarTasas() {
        try {
            URL url = new URL(
                    "https://api.freecurrencyapi.com/v1/latest?apikey=cuThdOaD5cyVvq61kq8kCov2rmRCoHlnh2fZB33p&currencies=EUR%2CCAD%2CJPY%2CGBP%2CCHF%2CRUB%2CTRY%2CBRL%2CCNY%2CHKD%2CINR%2CKRW%2CMXN");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // Verificar el código de respuesta
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta de la API
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                String json = response.toString();
                JSONObject obj = new JSONObject(json);
                JSONObject tasasActualizadas = obj.getJSONObject("data");
                for (int i = 1; i < valores.length; i++) {
                    tasas.put(valores[i], tasasActualizadas.getDouble(valores[i]));
                }
                tasas.put("USD", 1.0);
                fechaActualizacion = LocalDateTime.now();
            } else {
                // Código de respuesta HTTP diferente a 200 (OK), establecer el valor por
                // defecto
                // System.out.println("Error al obtener las tasas de cambio. Código de
                // respuesta: " + responseCode);
                setTasasPorDefercto();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            setTasasPorDefercto();
            // System.out.println("poniendo tasas por defecto");
        }
    }

    private static void setTasasPorDefercto() {
        for (int i = 0; i < valores.length; i++) {
            tasas.put(valores[i], tasasDefault[i]);
        }
    }

    public static double convertir(Double amount, String fromUnit, String toUnit) {
        if (tasas.isEmpty()) {
            setTasasPorDefercto();
        }
        double convertedAmount;
        double dolares;
        dolares = amount / tasas.get(fromUnit);
        convertedAmount = dolares * tasas.get(toUnit);
        return convertedAmount;
    }
}

