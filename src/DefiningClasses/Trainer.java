package DefiningClasses;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name, Pokemon pokemon){
        this.name = name;
        this.pokemons.add(pokemon);
    }

    public void checkForElement(String element){
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)){
                this.badges++;
                return;
            }
        }

        pokemons.removeIf(p -> !p.reduceHealth());
    }

    public int getBadges() {
        return badges;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString(){
        return this.name + " " + this.badges + " " + this.pokemons.size();
    }
}
