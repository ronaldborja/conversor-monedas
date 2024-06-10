package models;

import java.util.Scanner;

public class ProcesarMoneda {


    public static void convertir(String monedaBase, String monedaFinal, PeticionAPI consulta) {
        double cantidad;
        double resultado;

        Scanner teclado = new Scanner(System.in);

        Moneda moneda = consulta.buscarMoneda(monedaBase, monedaFinal);
        System.out.println("Ingrese la cantidad a convertir de: " + monedaBase);
        cantidad = Double.valueOf(teclado.nextLine());
        resultado = cantidad * Double.valueOf(moneda.conversion_rate());

        //Conversión:
        System.out.println(cantidad + " " + monedaBase + " = " + resultado + " " + moneda.target_code());
    }

}
