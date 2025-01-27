package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import java.util.List;

public class PokemonResponse {
    private List<PokemonList> results;  // Esta lista contiene todos los Pokémon

    public List<PokemonList> getResults() {
        return results;
    }

    public void setResults(List<PokemonList> results) {
        this.results = results;
    }
}
