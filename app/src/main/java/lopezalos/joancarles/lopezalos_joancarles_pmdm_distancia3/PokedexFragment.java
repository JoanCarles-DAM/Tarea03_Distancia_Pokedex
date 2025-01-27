package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.FragmentPokedexBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokedexFragment extends Fragment implements PokedexAdapter.OnPokemonClickListener {

    private FragmentPokedexBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPokedexBinding.inflate(inflater, container, false);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        // Configurar el RecyclerView
        PokedexAdapter adapter = new PokedexAdapter(new ArrayList<>(), getContext(), this);
        binding.recyclerViewPokedex.setAdapter(adapter);
        loadPokemonList(adapter);
    }

    private void loadPokemonList(PokedexAdapter adapter) {
        //Petición a la API
        PokemonApi pokemonApi = RetrofitClient.getRetrofitInstance().create(PokemonApi.class);

        pokemonApi.getPokemonList().enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    // Aquí obtenemos la lista de Pokémon desde la respuesta
                    PokemonResponse pokemonResponse = response.body();
                    if (pokemonResponse != null) {
                        ArrayList<PokemonList> pokemonList = (ArrayList<PokemonList>) pokemonResponse.getResults();  // Asegúrate de que PokemonResponse tenga el método getResults()
                        // Pasamos la lista al adapter para que la muestre
                        adapter.setData(pokemonList);
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("Error", "Error al cargar los Pokémon: " + t.getMessage());
            }
        });
    }

    public void onPokemonClick(PokemonList pokemon) {
        pokemon.capturarPokemon();
        binding.recyclerViewPokedex.getAdapter().notifyDataSetChanged();
        // Mostrar un mensaje al usuario (opcional)
        Toast.makeText(getContext(), pokemon.getNombre() + " capturado!", Toast.LENGTH_SHORT).show();

        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).addPokemonToCapturedList(pokemon);
        }

    }

}