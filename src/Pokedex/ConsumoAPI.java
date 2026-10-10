package Pokedex;


// Imports dos pacotes https

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsumoAPI {
    public String gerarAPI(String url) throws IOException, InterruptedException {
        // Aqui estamos criando o "cliente" que entrará em contato com o servidor para puxar os dados
        HttpClient client = HttpClient.newHttpClient();

        // Aqui criamos a requisição para a API que será enviada
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        // Aqui guardamos a responde dentro do responde.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        // Aqui temos o retornos da estrutura do código. Consideramos esse body como os dados estruturados.
        return response.body();


    }
}
