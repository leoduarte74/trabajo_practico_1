package com.example.tp1;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp1.ui.AboutActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // VARIABLE PARA VINCULAR LOS ELEMENTOS DEL LAYOUT
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // INFLAR EL LAYOUT USANDO VIEW BINDING
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // CONFIGURAR LA BARRA DE NAVEGACIÓN INFERIOR
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // CONFIGURACIÓN DE LOS DESTINOS EN LA NAVEGACIÓN
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_about)
                .build();

        // CONTROLADOR DE NAVEGACIÓN
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // MANEJAR LOS EVENTOS DE SELECCIÓN EN LA BARRA DE NAVEGACIÓN
        navView.setOnNavigationItemSelectedListener(item -> {
            // SI SE SELECCIONA "ABOUT", SE ABRE LA ACTIVIDAD "ABOUTACTIVITY"
            if (item.getItemId() == R.id.navigation_about) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
            }
            // MANTENER LA NAVEGACIÓN ENTRE FRAGMENTOS
            return NavigationUI.onNavDestinationSelected(item, navController)
                    || super.onOptionsItemSelected(item);
        });
    }
}
