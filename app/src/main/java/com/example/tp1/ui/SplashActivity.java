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
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // NAVEGAR A LA ACTIVIDAD PRINCIPAL (MAINACTIVITY) CUANDO EL USUARIO PRESIONE "EMPEZAR"
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // FINALIZAR LA ACTIVIDAD PARA EVITAR VOLVER AL SPLASH SCREEN
            }
        });
    }
}
