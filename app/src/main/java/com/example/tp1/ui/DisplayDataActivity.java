/*
 * Nombre del proyecto: Mboriaju
 * Autores: Leonardo Duarte, Lucas Baruja, Ezequiel Arce, Ivan Samudio
 * Descripción: Esta clase muestra los datos ingresados por el usuario en una nueva pantalla.
 * Fecha de creación: 23/10/2024
 * Forma de utilizar: Esta actividad se invoca desde MainActivity una vez que el usuario ha ingresado sus datos.
 */

package com.example.tp1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tp1.R;

public class DisplayDataActivity extends AppCompatActivity {

    // DECLARAR LOS ELEMENTOS DE LA INTERFAZ
    private TextView textViewData;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        // CONECTAR LOS ELEMENTOS DE LA INTERFAZ CON EL CÓDIGO JAVA
        textViewData = findViewById(R.id.textViewData);
        buttonBack = findViewById(R.id.buttonBack);

        // OBTENER LOS DATOS ENVIADOS DESDE "HOMEFRAGMENT"
        Intent intent = getIntent();
        String nombreApellido = intent.getStringExtra("nombreApellido");
        String edad = intent.getStringExtra("edad");
        String entrenamientoSeleccionado = intent.getStringExtra("entrenamientoSeleccionado");
        String sedeSeleccionada = intent.getStringExtra("sedeSeleccionada");
        boolean isAgreed = intent.getBooleanExtra("isAgreed", false);

        // FORMATEAR LOS DATOS PARA MOSTRARLOS
        String datosMostrados = "Nombre y Apellido: " + nombreApellido + "\n" +
                "Edad: " + edad + "\n" +
                "Entrenamiento: " + entrenamientoSeleccionado + "\n" +
                "Sede: " + sedeSeleccionada + "\n" +
                "Listo para el cambio: " + (isAgreed ? "Sí" : "No");

        // MOSTRAR LOS DATOS EN EL TEXTVIEW
        textViewData.setText(datosMostrados);

        // CONFIGURAR EL BOTÓN PARA REGRESAR A LA PANTALLA INICIAL (SPLASHACTIVITY)
        buttonBack.setOnClickListener(v -> {
            // INICIAR LA SPLASHACTIVITY Y FINALIZAR LA ACTIVIDAD ACTUAL
            Intent intent1 = new Intent(DisplayDataActivity.this, SplashActivity.class);
            startActivity(intent1);
            finish(); // FINALIZA LA ACTIVIDAD ACTUAL
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }
}
