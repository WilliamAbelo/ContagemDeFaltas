package com.example.william.mapas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.william.mapas.Alarme.ConfigurarAlarme;
import com.example.william.mapas.Bancos.ListaActivity;

public class BoasVindas extends AppCompatActivity implements View.OnClickListener{

    private Button btnHistorico;
    private Button btnConfigAlarm;
    private Button btnCaregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfigAlarm = (Button) findViewById(R.id.btnConfigAlarm);
        btnCaregar = (Button) findViewById(R.id.btnCarregar);
        btnHistorico = (Button) findViewById(R.id.btnHistorico);

        btnConfigAlarm.setOnClickListener(this);
        btnCaregar.setOnClickListener(this);
        btnHistorico.setOnClickListener(this);
    }

    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfigAlarm:
                Intent intent = new Intent(this, ConfigurarAlarme.class);
                startActivity(intent);
                break;
            case R.id.btnCarregar:
                Intent intent2 = new Intent(this, ListaActivity.class);
                startActivity(intent2);
                break;
        }
    }




}
