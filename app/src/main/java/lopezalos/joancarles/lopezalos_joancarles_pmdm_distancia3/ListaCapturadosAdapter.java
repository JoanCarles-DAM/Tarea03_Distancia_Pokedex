package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.PokemonCapturadoCardviewBinding;

public class ListaCapturadosAdapter extends RecyclerView.Adapter<PokemonCapturadoViewHolder> {

    private ArrayList<PokemonList> mCapturedPokemon;  // Lista de Pokémon capturados
    private Context context;

    // Constructor del Adapter
    public ListaCapturadosAdapter(ArrayList<PokemonList> capturedPokemon, Context context) {
        this.mCapturedPokemon = capturedPokemon;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonCapturadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout del card para la lista de capturados
        PokemonCapturadoCardviewBinding binding = PokemonCapturadoCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PokemonCapturadoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull PokemonCapturadoViewHolder holder, int position) {
        PokemonList pokemon =mCapturedPokemon.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return mCapturedPokemon.size();
    }


    public void setData(ArrayList<PokemonList> capturedPokemonList) {
        this.mCapturedPokemon = capturedPokemonList;
        notifyDataSetChanged();  // Notificamos al RecyclerView que los datos han cambiado
    }
}
