package com.edwartlc.currencychange.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultaConversion {
    public Conversion conversionMoneda(int opcionElegida) {
        String monedaBase = "";
        String monedaObjetivo = "";

        if (opcionElegida == 1) {
            monedaBase = "USD";
            monedaObjetivo = "COP";
        } else if (opcionElegida == 2) {
            monedaBase = "COP";
            monedaObjetivo = "USD";
        } else if (opcionElegida == 3) {
            monedaBase = "USD";
            monedaObjetivo = "BRL";
        } else if (opcionElegida == 4) {
            monedaBase = "BRL";
            monedaObjetivo = "USD";
        } else if (opcionElegida == 5) {
            monedaBase = "USD";
            monedaObjetivo = "CLP";
        } else if (opcionElegida == 6) {
            monedaBase = "CLP";
            monedaObjetivo = "USD";
        } else if (opcionElegida == 7) {
            monedaBase = "USD";
            monedaObjetivo = "ARS";
        } else {
            monedaBase = "ARS";
            monedaObjetivo = "USD";
        }

        URI direccion = URI
                .create("https://v6.exchangerate-api.com/v6/098d546e7f98a58ab711c465/pair/" +
                        monedaBase + "/" + monedaObjetivo);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}