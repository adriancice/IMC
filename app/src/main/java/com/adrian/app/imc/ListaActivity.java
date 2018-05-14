package com.adrian.app.imc;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.adrian.app.imc.adapters.RangoAdapters;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.fila, generarLista());
        ListView lv = findViewById(R.id.lista_rangos);
        //lv.setAdapter(listAdapter);

        RangoAdapters rangoAdapters = new RangoAdapters(this);
        lv.setAdapter(rangoAdapters);

    }

    private String[] generarLista(){
        String[] array = new String[20];
        for (int i = 0; i < 20; i++){
            array[i] = "Elemento " + (i+1);
        }
        return array;
    }
}
