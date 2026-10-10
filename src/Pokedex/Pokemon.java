package Pokedex;

import java.util.List;

public class Pokemon {

    // atributos
    private String name;
    private String id;
    private String height;
    private String weight;
    private String type1;
    private String type2;
    private String description;

    // transient faz o gson ignorar esse campo
    private transient List<String> abilities;


    // private List<String> abilities;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getType1() {
        return type1;

    }

    public void setType1(String type1){
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void MenuPokemon(){

        // calculo para o valor real da altura e o peso do pokemon

        double pesoParaDouble = Double.parseDouble(getWeight());
        double pesoReal = pesoParaDouble/10;

        double alturaParaDouble  = Double.parseDouble(getHeight());
        double alturaReal = alturaParaDouble/10;

        // menu com a pokedex do pokemon solicitado
        System.out.printf("====================\nPokedex\n====================\nPokemon: %s\nN° na Pokedex: %s\n\nDescrição: %s\n\nTipo: %s / %s\n", getName(), getId(), getDescription(),getType1(),getType2() );
        System.out.println("\nHabilidades:\n");
        for(int i=0; i<getAbilities().size(); i++){
            System.out.printf("- %s\n",getAbilities().get(i));

        }
        System.out.printf("\nAltura: %.2f M\nPeso: %.1f\n", alturaReal, pesoReal);
        System.out.println("==============================\n");

    }
}
