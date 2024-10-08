package com.edwartlc.currencychange;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        int salir = 0;
        while (salir != 7) {
            System.out.println("***********************************************");
            System.out.println("¡Bienvenido(a) al conversor de moneda!");
            System.out.println("1) Dólar =>> Peso colombiano");
            System.out.println("2) Peso colombiano =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso argentino");
            System.out.println("6) Peso argentino =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("***********************************************");
            int entrada = lectura.nextInt();

            if (entrada == 1) {
                System.out.println("Ingrese el valor que desea convertir: ");
                double valor = lectura.nextDouble();
                //El valor 'valor' 'moneda' corresponde a: 'valor convertido' 'moneda'
            }
        }

        System.out.println("Finalizó la ejecución del programa.");
    }
}
