/*
 * Nombre del proyecto: Mboriaju
 * Autores: Leonardo Duarte, Lucas Baruja, Ezequiel Arce, Ivan Samudio
 * Descripción: Este fragmento permite el ingreso de datos del usuario, incluyendo nombre, edad, entrenamiento preferido, y sede.
 *              Valida los campos y, si están completos, envía los datos a la actividad DisplayDataActivity.
 * Fecha de creación: 23/10/2024
 * Forma de utilizar: Este fragmento se utiliza dentro de la actividad principal y actúa como el formulario de registro para el usuario.
 *                    Tras completar los campos, el usuario puede enviar los datos para visualizarlos en la siguiente actividad.
 */


package com.example.tp1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.tp1.R;
import com.example.tp1.ui.DisplayDataActivity;
import android.widget.ArrayAdapter;


public class HomeFragment extends Fragment {

    private EditText editTextName;
    private EditText editTextAge;
    private RadioGroup radioGroupTraining;
    private Spinner spinnerBranch;
    private CheckBox checkBoxAgreement;
    private Button buttonSubmit;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Conectar los elementos de la interfaz con el código Java
        editTextName = root.findViewById(R.id.editTextName);
        editTextAge = root.findViewById(R.id.editTextAge);
        radioGroupTraining = root.findViewById(R.id.radioGroupTraining);
        spinnerBranch = root.findViewById(R.id.spinnerBranch);
        checkBoxAgreement = root.findViewById(R.id.checkBoxAgreement);
        buttonSubmit = root.findViewById(R.id.buttonSubmit);

        // Configurar el Spinner con las opciones de las sedes
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.branches_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(adapter);

        // Configurar el evento del botón Submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar que todos los campos estén completos

                // Validar Nombre y Apellido
                String nombreApellido = editTextName.getText().toString();
                if (nombreApellido.isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, ingrese su nombre y apellido", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar Edad
                String edad = editTextAge.getText().toString();
                if (edad.isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, ingrese su edad", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que se haya seleccionado una opción de entrenamiento
                int selectedRadioButtonId = radioGroupTraining.getCheckedRadioButtonId();
                if (selectedRadioButtonId == -1) { // -1 significa que no hay nada seleccionado
                    Toast.makeText(getContext(), "Por favor, seleccione un entrenamiento", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton selectedRadioButton = root.findViewById(selectedRadioButtonId);
                String entrenamientoSeleccionado = selectedRadioButton.getText().toString();

                // Validar que se haya seleccionado una sede del Spinner
                String sedeSeleccionada = spinnerBranch.getSelectedItem().toString();
                if (sedeSeleccionada.isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, seleccione una sede", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar que el CheckBox esté seleccionado
                if (!checkBoxAgreement.isChecked()) {
                    Toast.makeText(getContext(), "Debe aceptar los términos para continuar", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Si todas las validaciones pasan, crea el Intent para pasar los datos a la siguiente actividad
                Intent intent = new Intent(getActivity(), DisplayDataActivity.class);
                intent.putExtra("nombreApellido", nombreApellido);
                intent.putExtra("edad", edad);
                intent.putExtra("entrenamientoSeleccionado", entrenamientoSeleccionado);
                intent.putExtra("sedeSeleccionada", sedeSeleccionada);
                intent.putExtra("isAgreed", true);  // Ya sabemos que está chequeado porque pasamos la validación
                startActivity(intent);
            }
        });

        return root;
    }
}
