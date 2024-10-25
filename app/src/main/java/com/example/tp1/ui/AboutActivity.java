package com.example.tp1.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp1.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // CONFIGURAR EL BOTÓN "BACK"
        Button buttonBack = findViewById(R.id.buttonBack);

        // MANEJAR EL EVENTO DEL BOTÓN PARA CERRAR LA ACTIVIDAD
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FINALIZAR LA ACTIVIDAD Y VOLVER A LA ANTERIOR
                finish();
            }
        });
    }
}
