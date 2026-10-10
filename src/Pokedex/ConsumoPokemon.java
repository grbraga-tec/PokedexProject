// Import dos pacotes e bibliotecas


package Pokedex;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;
import java.io.IOException;


public class ConsumoPokemon {
    // Essa classe é onde iremos receber os dados da pokeapi, de acordo com o pokemon que fora passado como parametro em acharPokemon
    public void acharPokemon(String namePokemon) throws IOException, InterruptedException {
        ConsumoAPI consumoTeste = new ConsumoAPI();

        // Essa url pega o string para iniciar a função, e retorna os dados json do pokemon

        String url = "https://pokeapi.co/api/v2/pokemon/" + namePokemon;
        // Aqui temos a descrição do pokemon
        String urlDescricao = "https://pokeapi.co/api/v2/pokemon-species/"+ namePokemon;


        // Aqui colocarmos e formatamos a descrição de acoerdo com a função gerarAPI que criamos anteriormente.
        String urlDescicaoFormat = consumoTeste.gerarAPI(urlDescricao);
        String urlFormatada = consumoTeste.gerarAPI(url);



        Gson gsonPrincipal = new Gson();


        Pokemon pkmnDados = gsonPrincipal.fromJson(urlFormatada ,Pokemon.class);

        Pokemon pkmnDescript = gsonPrincipal.fromJson(urlDescicaoFormat, Pokemon.class);

        // Pegando a descrição do pokemon

        JsonObject pokemonDescricaoJson = JsonParser.parseString(urlDescicaoFormat).getAsJsonObject();

        JsonArray descricaoPokemon = pokemonDescricaoJson.getAsJsonArray("flavor_text_entries");

        // percorrendo todos os itens

        for(int i=0; i<descricaoPokemon.size(); i++){
            JsonObject descricaoObject = descricaoPokemon.get(i).getAsJsonObject();



            JsonObject language = descricaoObject.getAsJsonObject("language");
            String nomeIdioma = language.get("name").getAsString();




            if(nomeIdioma.equals("en")){
                String descricao =  descricaoObject.get("flavor_text").getAsString();

                TraducaoAPI traducao = new TraducaoAPI();
                String descricaoTraduzida  = traducao.chamarTraducao(descricao);

                pkmnDados.setDescription(descricaoTraduzida);



                // não irá mais percorrer a lista

                break;

            }



        }





        //Transformando o json em objetos para acessar o array type.
        JsonObject pokemonJson = JsonParser.parseString(urlFormatada).getAsJsonObject();

        JsonArray tiposPkmns = pokemonJson.getAsJsonArray("types");

        //percorrendo todos os itens existens

        for(int i=0; i< tiposPkmns.size(); i++ ){
            JsonObject tiposObject = tiposPkmns.get(i).getAsJsonObject();

            JsonObject tipo = tiposObject.getAsJsonObject("type");

            String nomeTipo = tipo.get("name").getAsString();

            if(i==0){
                pkmnDados.setType1(nomeTipo);
            }
            if(i==1){
                pkmnDados.setType2(nomeTipo);
            }
        }

        // Transformando o json em objetos para acessar o array habilidades
        JsonObject pokemonHabidadeJson = JsonParser.parseString(urlFormatada).getAsJsonObject();

        JsonArray habilidadesPokemon = pokemonHabidadeJson.getAsJsonArray("abilities");


        // percorrendo todos os itens existentes
        List<String> listaHabilidades = new ArrayList<>();

        for(int i=0; i<habilidadesPokemon.size(); i++){
            JsonObject habilidadesObject = habilidadesPokemon.get(i).getAsJsonObject();

            JsonObject habilidade = habilidadesObject.getAsJsonObject("ability");

            String habilidadeVista = habilidade.get("name").getAsString();

            listaHabilidades.add(habilidadeVista);


            pkmnDados.setAbilities(listaHabilidades);

        }

        pkmnDados.MenuPokemon();




    }

    public void testeAPI(String pokemon) throws IOException, InterruptedException {

        ConsumoAPI consumoTeste = new ConsumoAPI();

        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

        String urlFormatada = consumoTeste.gerarAPI(url);


    }



}
