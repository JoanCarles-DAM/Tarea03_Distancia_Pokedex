package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.PokemonPokedexItemBinding;

public class PokedexAdapter extends RecyclerView.Adapter<PokemonPokedexViewHolder> {

    private ArrayList<PokemonList> mData;
    private Context context;
    private OnPokemonClickListener listener; // Listener para capturar Pokémon

    // Constructor del Adapter
    public PokedexAdapter(ArrayList<PokemonList> itemList, Context context, OnPokemonClickListener listener) {
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonPokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos la vista del card para la Pokédex
        PokemonPokedexItemBinding binding = PokemonPokedexItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PokemonPokedexViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PokemonPokedexViewHolder holder, int position) {
        PokemonList pokemon = mData.get(position);
        holder.bind(pokemon);  // Llamamos al método bind para asociar los datos

        // Establecer el comportamiento de captura al hacer clic en el ítem
        holder.itemView.setOnClickListener(v -> {
            pokemon.capturarPokemon();  // Actualizamos el estado del Pokémon a "capturado"
            listener.onPokemonClick(pokemon);  // Notificamos al listener que un Pokémon ha sido capturado
        });
    }

    public void setData(ArrayList<PokemonList> newPokemonList) {
        this.mData = newPokemonList;
        notifyDataSetChanged();  // Notificamos al RecyclerView que los datos han cambiado
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Interface para escuchar los clics en la Pokédex
    public interface OnPokemonClickListener {
        void onPokemonClick(PokemonList pokemon);
    }
}
