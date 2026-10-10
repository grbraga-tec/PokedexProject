package Pokedex;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu{
    public void menu() throws IOException, InterruptedException {

        // Criação de um Scanner

        Scanner teclado = new Scanner(System.in);

        // Criação de um String centralizado, para "embelezar" nossos código.
        String titulo = "Pokedex";
        String tituloCentralizado = String.format("%-12s", String.format("%12s", titulo));

        // Criação do layout de título

        System.out.printf("====================\n%s\n====================\n", tituloCentralizado);
        while(true){
            System.out.println("Opções\n[1] - Escolher Pokémon\n[2] - Sair do Programa\n\nSua escolha:");
            int chosed = ValidarNumero.ValidarNumerosInt(teclado,"");

            // Verificação de escolha correta do usuário, não podendo escolher números maiores que 2 e menores que 1
            while(chosed<1 || chosed>2){
                System.out.println("Impossível ! Apenas duas opções disponíveis !");
                chosed = ValidarNumero.ValidarNumerosInt(teclado, "Informe a opção desejada:");
            }
            // Validação da escolha correta
            if(chosed==1){
                teclado.nextLine();
                ConsumoPokemon pkmn =  new ConsumoPokemon();
                System.out.println("Informe o nome do pokemon: ");
                String pkmnEscolhido = teclado.nextLine();

                pkmn.acharPokemon(pkmnEscolhido);




            } else if (chosed==2) {
                System.out.println("Programa será finalizado ! Obrigado e volte sempre.");
                break;

            }

        }


    }


}