package lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import lopezalos.joancarles.lopezalos_joancarles_pmdm_distancia3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;
    private ArrayList<PokemonList> capturedPokemonList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
            NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);
            NavigationUI.setupActionBarWithNavController(this, navController);
        }

        binding.bottomNavigationView.setOnItemSelectedListener(this::onMenuSelected);
        setContentView(binding.getRoot());
    }


    public void addPokemonToCapturedList(PokemonList pokemon) {
        capturedPokemonList.add(pokemon);

        ListaFragment fragment = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.listaFragment);
        if (fragment != null) {
            fragment.updateCapturedList(capturedPokemonList);
        }
    }
    //Según el id del botón al que pulso, lo llevo a un fragment u a otro.
    private boolean onMenuSelected(MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.pokedex_menu_home) {
            navController.navigate(R.id.pokedexFragment);
        }
        if (menuItem.getItemId() == R.id.lista_menu_item) {
            navController.navigate(R.id.listaFragment);
        }
        if (menuItem.getItemId() == R.id.settings_menu_item){
            navController.navigate(R.id.settingsFragment);
        }
        return true;
    }
}