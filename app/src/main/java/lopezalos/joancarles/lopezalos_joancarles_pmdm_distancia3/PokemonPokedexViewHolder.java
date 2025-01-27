package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import androidx.recyclerview.widget.RecyclerView;
import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.PokemonPokedexItemBinding;

public class PokemonPokedexViewHolder extends RecyclerView.ViewHolder {

    private final PokemonPokedexItemBinding binding;

    public PokemonPokedexViewHolder(PokemonPokedexItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PokemonList pokemon){
        binding.pokemonName.setText(pokemon.getNombre());
        //Si el booleano isCaptured es true, significa que ha sido capturado y lo indicamos con una Pokeball. Si no, la imagen se queda vacía y no se ve nada.
        if (pokemon.isCaptured()){
            binding.pokemonStatusIcon.setImageResource(R.drawable.capturado);
        }else {
            binding.pokemonStatusIcon.setImageResource(R.drawable.sin_capturar);
        }
    }
}

