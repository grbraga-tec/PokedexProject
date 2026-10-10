package Pokedex;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TraducaoAPI {

    public String chamarTraducao(String texto) throws IOException, InterruptedException {

        String textoFormatado = URLEncoder.encode(texto, StandardCharsets.UTF_8);

        // Idioma de origem - idioma de destino

        String langPair = URLEncoder.encode("en|pt-BR", StandardCharsets.UTF_8);

        // Montando a url da api

        String url = "https://api.mymemory.translated.net/get"
                + "?q=" + textoFormatado
                + "&langpair=" + langPair;


        // criando o json que será enviado para a API
        JsonObject jsonTraducao = new JsonObject();

        //Consumindo a api
        ConsumoAPI consumoAPI = new ConsumoAPI();

        String respostaJson = consumoAPI.gerarAPI(url);

        // transformando a resposta em json

        JsonObject respostaObjeto = JsonParser.parseString(respostaJson).getAsJsonObject();

        //Entrando em responseData
        JsonObject reponseData =  respostaObjeto.getAsJsonObject("responseData");

        // pegando a tradução

        String traducao = reponseData.get("translatedText").getAsString();




        return traducao;
    }
        }
