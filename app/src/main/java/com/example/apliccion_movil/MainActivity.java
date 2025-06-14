package com.example.apliccion_movil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDia, spinnerMes, spinnerAnio;
    private AutoCompleteTextView autoCompleteTextViewDocumentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajuste de padding para Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los componentes UI
        spinnerDia = findViewById(R.id.spinnerDia);
        spinnerMes = findViewById(R.id.spinnerMes);
        spinnerAnio = findViewById(R.id.spinnerAnio);
        autoCompleteTextViewDocumentType = findViewById(R.id.autoCompleteTextViewDocumentType);

        // Configurar adaptador para spinner de días
        ArrayAdapter<CharSequence> adapterDias = ArrayAdapter.createFromResource(
                this, R.array.dias, android.R.layout.simple_spinner_item);
        adapterDias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDia.setAdapter(adapterDias);

        // Configurar adaptador para spinner de meses
        ArrayAdapter<CharSequence> adapterMeses = ArrayAdapter.createFromResource(
                this, R.array.meses, android.R.layout.simple_spinner_item);
        adapterMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapterMeses);

        // Configurar adaptador para spinner de años
        List<String> listaAnios = new ArrayList<>();
        for (int i = 2025; i >= 1930; i--) {
            listaAnios.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapterAnios = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, listaAnios);
        adapterAnios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnio.setAdapter(adapterAnios);

        // Configurar adaptador para AutoCompleteTextView (tipo de documento)
        ArrayAdapter<CharSequence> adapterTiposDocumento = ArrayAdapter.createFromResource(
                this, R.array.tipos_documento, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextViewDocumentType.setAdapter(adapterTiposDocumento);
    }
}
