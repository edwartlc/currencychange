package com.edwartlc.currencychange;

import com.edwartlc.currencychange.modelos.ConsultaConversion;
import com.edwartlc.currencychange.modelos.Conversion;
import com.edwartlc.currencychange.modelos.GuardaConversion;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();
        GuardaConversion registro = new GuardaConversion();

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
                    Conversion conversion = consulta.conversionMoneda(opcionElegida);
                    registro.guardarConversion(conversion);
                    System.out.println("El valor: $" +  String.format("%.2f", valorAConvertir) +
                            " " + conversion.base_code() + " corresponde a: $" +
                            String.format("%.2f", conversion.conversion_rate() * valorAConvertir) +
                            " " + conversion.target_code());
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

        System.out.println("*******************************************************************\n");
        System.out.println("Conversiones realizadas: \n");
        for (String conversion : registro.getListaDeConversiones()) {
            System.out.println(conversion);
        }
        System.out.println("\n*******************************************************************");

        System.out.println("\nFinalizó la ejecución del conversor de monedas.");
    }
}
