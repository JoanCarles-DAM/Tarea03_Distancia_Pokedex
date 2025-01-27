package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Path;

public interface PokemonApi {
    // Petición para obtener la lista de Pokémon (con los parámetros 'offset' y 'limit')
    @GET("pokemon?offset=0&limit=150")
    Call<PokemonResponse> getPokemonList();

    // Petición para obtener los detalles de un Pokémon específico (usando su nombre)
    @GET("pokemon/{pokemonName}")
    Call<PokemonList> getPokemonDetails(@Path("pokemonName") String pokemonName);
}
