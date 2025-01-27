package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaFragment extends Fragment {

    private ListaCapturadosAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        // Obtener referencia al RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewLista);

        // Configurar el RecyclerView (GridLayoutManager o LinearLayoutManager)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear el adapter
        adapter = new ListaCapturadosAdapter(new ArrayList<>(), getContext());

        // Establecer el adapter al RecyclerView
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void updateCapturedList(ArrayList<PokemonList> capturedPokemonList) {
        adapter.setData(capturedPokemonList);
        adapter.notifyDataSetChanged();
    }
}