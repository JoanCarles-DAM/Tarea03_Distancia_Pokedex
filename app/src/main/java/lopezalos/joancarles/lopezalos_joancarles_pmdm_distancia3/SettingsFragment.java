package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.FragmentPokedexBinding;
import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        //Inicializamos los botones
        binding.iconArrowAbout.setOnClickListener(this::MostrarDialogoAcercaDe);
        binding.iconArrowLanguage.setOnClickListener(this::CambiarIdiomaApp);
        binding.iconArrowLogout.setOnClickListener(this::CerrarSesion);

        return binding.getRoot();
    }

    private void CerrarSesion(View view) {
    }

    private void CambiarIdiomaApp(View view) {
    }

    private void MostrarDialogoAcercaDe(View view) {
        new android.app.AlertDialog.Builder(getContext())
                .setTitle("Acerca de...")
                .setMessage("Desarrollado por: Joan Carles López Alós\nVersión: 1.0.0")
                .setPositiveButton("Got it", (dialog, which) -> dialog.dismiss())
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Limpiar el binding cuando la vista se destruya
        binding = null;
    }
}