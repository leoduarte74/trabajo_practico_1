/*
 * Nombre del proyecto: Mboriaju
 * Autores: Leonardo Duarte, Lucas Baruja, Ezequiel Arce, Ivan Samudio
 * Descripción: Esta clase maneja la pantalla de inicio (Splash Screen) de la aplicación.
 * Fecha de creación: 23/10/2024
 * Forma de utilizar: Esta actividad se muestra al iniciar la aplicación y navega automáticamente a MainActivity.
 */

package com.example.tp1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tp1.R;
import com.example.tp1.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // CONECTAR EL BOTÓN "EMPEZAR"
        Button buttonStart = findViewById(R.id.buttonStart);

        // CONFIGURAR EL EVENTO CLICK PARA EL BOTÓN
        buttonStart.setOnClickListener(v -> {
            // NAVEGAR A LA ACTIVIDAD PRINCIPAL (MAINACTIVITY) CUANDO EL USUARIO PRESIONE "EMPEZAR"
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // FINALIZAR LA ACTIVIDAD PARA EVITAR VOLVER AL SPLASH SCREEN
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
