package com.example.william.mapas.Bancos;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.william.mapas.R;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    ListView listTabFaltas;
    ArrayAdapter<String> adaptador;


    public static class dias {
        public static List<String> idFaltas     = new ArrayList<>();
        public static List<Integer> id_Config   = new ArrayList<>();
        public static List<String> domingo      = new ArrayList<>();
        public static List<String> segunda      = new ArrayList<>();
        public static List<String> terca        = new ArrayList<>();
        public static List<String> quarta       = new ArrayList<>();
        public static List<String> quinta       = new ArrayList<>();
        public static List<String> sexta        = new ArrayList<>();
        public static List<String> sabado       = new ArrayList<>();
        public static List<String> datas        = new ArrayList<>();
        public static List<String> local1       = new ArrayList<>();
        public static List<String> local2       = new ArrayList<>();
        public static List<String> obs          = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listTabFaltas = (ListView) findViewById(R.id.lstTabFaltas);
        carregaDados();
    }

    public Cursor carregaDados() {
        Cursor cursor = null;
        BancoControllerFaltas faltas = new BancoControllerFaltas(getBaseContext());
        int numeroLinhas = faltas.ultimoRegistroID().getCount();
        Log.e("", "");/*
        for (int cont = 0; cont <=57; cont++) {
            dias.idFaltas.add(String.valueOf(faltas.carregaDados(cont)));
        }
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dias.idFaltas);
        listTabFaltas.setAdapter(adaptador);*/
        return cursor;
    }


}
