package models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Esta clase retorna el JSON con los resultados de la peticion
public class PeticionAPI {

    public Moneda buscarMoneda(String monedaBase, String monedaFinal) {
        final String APIURL = "https://v6.exchangerate-api.com/v6/c0dbc111ddfa1aa122f937a9/pair/" +
                monedaBase + "/" + monedaFinal;

        //Cliente http
        HttpClient client = HttpClient.newHttpClient();

        //Solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL))
                .build();

        try {
            HttpResponse<String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (IOException e) {
            System.out.println("Se encontró un error I/O durante la solicitud: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("La solicitud fue interrumpida: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
