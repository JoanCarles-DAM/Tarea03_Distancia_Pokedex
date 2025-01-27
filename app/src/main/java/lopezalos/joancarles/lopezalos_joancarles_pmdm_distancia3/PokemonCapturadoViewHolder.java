package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import androidx.recyclerview.widget.RecyclerView;
import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.PokemonCapturadoCardviewBinding;
import com.squareup.picasso.Picasso;

public class PokemonCapturadoViewHolder extends RecyclerView.ViewHolder {

    private final PokemonCapturadoCardviewBinding binding;

    public PokemonCapturadoViewHolder(PokemonCapturadoCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(PokemonList pokemon) {
        binding.PokemonCapturadoName.setText(pokemon.getNombre()); //Bindeamos el nombre
        binding.PokemonType.setText(pokemon.getTipo()); //Binedamos el tipo
        Picasso.get() //usamos librería Picasso para coger la foto de la API
                .load(pokemon.getImage())
                .into(binding.PokemonPicture);
        binding.executePendingBindings(); //asegura que se aplique los cambios de inmediato */
    }
}
