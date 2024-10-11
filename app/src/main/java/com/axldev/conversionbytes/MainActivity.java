package com.axldev.conversionbytes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Variables para los elementos de la interfaz
    private EditText editTextValor;
    private Spinner spinnerOrigen, spinnerDestino;
    private Button btnConvertir;
    private TextView textViewResultado;

    // Unidades de datos
    private String[] unidades = {
            "bit", "Byte", "Kilobyte", "Kibibyte", "Megabyte", "Mebibyte",
            "Gigabyte", "Gibibyte", "Terabyte", "Tebibyte", "Petabyte", "Pebibyte"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        editTextValor = findViewById(R.id.editTextValor);
        spinnerOrigen = findViewById(R.id.spinnerOrigen);
        spinnerDestino = findViewById(R.id.spinnerDestino);
        btnConvertir = findViewById(R.id.btnConvertir);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Crear un adaptador para los spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, unidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador a los spinners
        spinnerOrigen.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);

        // Configurar el botón para hacer la conversión
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversion();
            }
        });
    }

    // Método para realizar la conversión
    private void realizarConversion() {
        double valor = Double.parseDouble(editTextValor.getText().toString());
        String unidadOrigen = spinnerOrigen.getSelectedItem().toString();
        String unidadDestino = spinnerDestino.getSelectedItem().toString();

        // Aquí puedes definir las tasas de conversión para cada unidad
        double valorEnBits = convertirABytes(valor, unidadOrigen);
        double resultado = convertirDesdeBytes(valorEnBits, unidadDestino);

        // Mostrar el resultado
        textViewResultado.setText("Resultado: " + resultado + " " + unidadDestino);
    }

    // Método para convertir la unidad origen a bits
    private double convertirABytes(double valor, String unidadOrigen) {
        switch (unidadOrigen) {
            case "bit":
                return valor;
            case "Byte":
                return valor * 8;
            case "Kilobyte":
                return valor * 8 * 1000;
            case "Kibibyte":
                return valor * 8 * 1024;
            case "Megabyte":
                return valor * 8 * 1000 * 1000;
            case "Mebibyte":
                return valor * 8 * 1024 * 1024;
            case "Gigabyte":
                return valor * 8 * 1000 * 1000 * 1000;
            case "Gibibyte":
                return valor * 8 * 1024 * 1024 * 1024;
            case "Terabyte":
                return valor * 8 * 1000 * 1000 * 1000 * 1000;
            case "Tebibyte":
                return valor * 8 * 1024 * 1024 * 1024 * 1024;
            case "Petabyte":
                return valor * 8 * 1000 * 1000 * 1000 * 1000 * 1000;
            case "Pebibyte":
                return valor * 8 * 1024 * 1024 * 1024 * 1024 * 1024;
            default:
                return valor;
        }
    }

    // Método para convertir bits a la unidad destino
    private double convertirDesdeBytes(double valorEnBits, String unidadDestino) {
        switch (unidadDestino) {
            case "bit":
                return valorEnBits;
            case "Byte":
                return valorEnBits / 8;
            case "Kilobyte":
                return valorEnBits / (8 * 1000);
            case "Kibibyte":
                return valorEnBits / (8 * 1024);
            case "Megabyte":
                return valorEnBits / (8 * 1000 * 1000);
            case "Mebibyte":
                return valorEnBits / (8 * 1024 * 1024);
            case "Gigabyte":
                return valorEnBits / (8 * 1000 * 1000 * 1000);
            case "Gibibyte":
                return valorEnBits / (8 * 1024 * 1024 * 1024);
            case "Terabyte":
                return valorEnBits / (8 * 1000 * 1000 * 1000 * 1000);
            case "Tebibyte":
                return valorEnBits / (8 * 1024 * 1024 * 1024 * 1024);
            case "Petabyte":
                return valorEnBits / (8 * 1000 * 1000 * 1000 * 1000 * 1000);
            case "Pebibyte":
                return valorEnBits / (8 * 1024 * 1024 * 1024 * 1024 * 1024);
            default:
                return valorEnBits;
        }
    }
}
