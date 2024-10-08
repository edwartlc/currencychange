package com.edwartlc.currencychange;

import com.edwartlc.currencychange.modelos.ConsultaCambio;
import com.edwartlc.currencychange.modelos.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaCambio consulta = new ConsultaCambio();

        int salir = 0;
        while (salir != 9) {
            System.out.println("***********************************************");
            System.out.println("¡Bienvenido(a) al conversor de monedas!\n");
            System.out.println("1) Dólar =>> Peso colombiano");
            System.out.println("2) Peso colombiano =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso chileno");
            System.out.println("6) Peso chileno =>> Dólar");
            System.out.println("7) Dólar =>> Peso argentino");
            System.out.println("8) Peso argentino =>> Dólar\n");

            System.out.println("Digite el número de la conversión que desea realizar o 9 para salir: ");
            try {
                var opcionElegida = Integer.valueOf(lectura.nextLine());
                if (opcionElegida == 9) {
                    salir = 9;
                    break;
                } else if (opcionElegida > 0 && opcionElegida < 9) {
                    System.out.println("Ingrese el valor que desea convertir: ");
                    var valorAConvertir = Double.valueOf(lectura.nextLine());
                    Moneda moneda = consulta.conversion(opcionElegida);
                    System.out.println("El valor: $" +  valorAConvertir + " " +
                            moneda.base_code() + " corresponde a: $" +
                            Math.round(moneda.conversion_rate() *
                            valorAConvertir * 100) / 100.00 + " " +
                            moneda.target_code());
                } else {
                    System.out.println("¡Debe ingresar una opción válida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("¡Debe ingresar una opción válida!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }

        System.out.println("Finalizó la ejecución del conversor de monedas.");
    }
}
