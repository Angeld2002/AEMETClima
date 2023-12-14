package com.politecnicomalaga.aemet.View;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.aemet.Control.CSVReader;
import com.politecnicomalaga.aemet.Control.JornadaAdapter;
import com.politecnicomalaga.aemet.Control.MainController;
import com.politecnicomalaga.aemet.Control.MapaLocalidad;
import com.politecnicomalaga.aemet.Model.Clima;
import com.politecnicomalaga.aemet.Model.Localidades;
import com.politecnicomalaga.aemet.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Clima> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private JornadaAdapter mAdapter;
    private HashMap<String,String> mapaLocalidad;
    private static MainActivity myActiveActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_clima);
        mAdapter = new JornadaAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainController.setURL();
        MainActivity.myActiveActivity = this;
        MainController.setActivity(this);
        List<Localidades> csvData = CSVReader.readCSV(this, R.raw.codmun);
        List<String> elementosSpinner = new ArrayList<>();
        EditText busqueda =findViewById(R.id.editTextNombre);

        Spinner spinnerLocalidad =findViewById(R.id.spLocalidad);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocalidad.setAdapter(adapter);

        mapaLocalidad = new MapaLocalidad(csvData).getMapa();

        busqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() >= 3) {
                    for (Map.Entry<String, String> map: mapaLocalidad.entrySet()
                         ) {
                        String nombre = map.getKey();
                        if (nombre.startsWith(busqueda.getText().toString().toUpperCase())) {
                            elementosSpinner.add(nombre);
                        }

                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinnerLocalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedElement = elementosSpinner.get(position);
                MainController.setCodigo(mapaLocalidad.get(selectedElement));
                MainController.getSingleton().requestDataFromAemet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Este método se llama cuando no hay ningún elemento seleccionado
            }
        });
    }
    public void accessData() {
        List<Clima> nuevaLista = MainController.getSingleton().getDataFromAemet();
        mList.clear();
        for (Clima item:nuevaLista) {
            mList.add(item);
        }
        mAdapter.notifyDataSetChanged();
        TextView tv = (TextView) findViewById(R.id.textView);
    }
    public void errorData(String error) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(error);
    }
}