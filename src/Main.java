import models.PeticionAPI;
import models.ProcesarMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PeticionAPI consulta = new PeticionAPI();


        boolean ejecutar = true;

        while(ejecutar) {
            menu();
            Scanner teclado = new Scanner(System.in);
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    ProcesarMoneda.convertir("USD", "ARS", consulta);
                    break;

                case 2:
                    ProcesarMoneda.convertir("ARS", "USD", consulta);
                    break;

                case 3:
                    ProcesarMoneda.convertir("USD", "BRL", consulta);
                    break;

                case 4:
                    ProcesarMoneda.convertir("BRL", "USD", consulta);
                    break;

                case 5:
                    ProcesarMoneda.convertir("USD", "COP", consulta);
                    break;

                case 6:
                    ProcesarMoneda.convertir("COP", "USD", consulta);

                case 7:
                    System.out.println("Saliendo de la aplicación...");
                    ejecutar = false;
            }
        }
    }


    //Menu
    public static void menu() {
        System.out.print("************************************\n");
        System.out.println("Bienvenidos - Conversor de Monedas");
        System.out.println("1. Dolar a Pesos Argentinos");
        System.out.println("2. Peso Argentino a Dolar");
        System.out.println("3. Dolar a Real Brasilero");
        System.out.println("4. Real Brasilero a Dolar");
        System.out.println("5. Dolar a Pesos Colombianos");
        System.out.println("6. Peso Colombiano a Dolar");
        System.out.println("7. Salir");
    }
}