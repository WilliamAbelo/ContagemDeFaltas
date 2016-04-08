package com.example.william.mapas.Alarme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.mapas.Bancos.ManipulacaoBancos;
import com.example.william.mapas.Mapas.GPSBackground;
import com.example.william.mapas.R;

import java.util.Calendar;

public class ConfigurarAlarme extends AppCompatActivity implements View.OnClickListener{

    private TextView        txtValorLat;
    private TextView        txtValorLong;
    private Button          btnOk;
    private Button          btnLocalizacao;
    private Button          btnCancel;
    private EditText        edtHora;
    private EditText        edtMin;
    private CheckBox        ckbAtivo;
    private CheckBox        ckbDiario;
    private EditText        edtObservacao;
    private PendingIntent   pendingIntent;
    private static double   latitude;
    private static double   longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        txtValorLat     = (TextView) findViewById(R.id.txtValorLat);
        txtValorLong    = (TextView) findViewById(R.id.txtValorLong);
        btnOk           = (Button)   findViewById(R.id.btnOk);
        btnLocalizacao  = (Button)   findViewById(R.id.btnLocalizar);
        btnCancel       = (Button)   findViewById(R.id.btnCancel);
        edtHora         = (EditText) findViewById(R.id.edtValorHora);
        edtMin          = (EditText) findViewById(R.id.edtValorMin);
        edtObservacao   = (EditText) findViewById(R.id.edtObservacao);
        ckbAtivo        = (CheckBox) findViewById(R.id.ckbAtiva);
        ckbDiario       = (CheckBox) findViewById(R.id.ckbDiaria);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnLocalizacao.setOnClickListener(this);

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
    }

    protected void onResume(){
        super.onResume();
        startServiceGPS();
        latitude = GPSBackground.getLatitude();
        longitude = GPSBackground.getLongitude();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk:
                startAlarm();
                salvarConfigAlarmeBanco();
                break;

            case R.id.btnLocalizar:
                localizar();
                break;

            case R.id.btnCancel:
                cancel();
                break;
        }

    }

    public void startAlarm(){
        int intervalo = 10;
        if(ckbDiario.isChecked()){
            intervalo = 60;//*60*24;
        }
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int hora = Integer.valueOf(String.valueOf(edtHora.getText()));
        int minutos = Integer.valueOf(String.valueOf(edtMin.getText()));
        int interval = 1000 * intervalo;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minutos);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);
    }

    public void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        Toast.makeText(this, "Contagem Cancelada", Toast.LENGTH_SHORT).show();
    }

    public void localizar() {
        onResume();
        txtValorLat.setText(String.valueOf(latitude));
        txtValorLong.setText(String.valueOf(longitude));
    }

    public void salvarConfigAlarmeBanco(){
        String ativo;
        if(ckbAtivo.isChecked()){
            ativo = "s";
        } else {
            ativo = "n";
        }
        String local    = String.valueOf(GPSBackground.getLatitude()+" "+GPSBackground.getLongitude());
        String horario  = String.valueOf(edtHora.getText()+":"+edtMin.getText());
        String obs      = String.valueOf(edtObservacao.getText());

        ManipulacaoBancos manipulacaoBancos = new ManipulacaoBancos();
        manipulacaoBancos.salvarTabConfig(getBaseContext(), ativo, local, horario, obs);
    }

    public void startServiceGPS(){
        Intent intent = new Intent(this, GPSBackground.class);
        startService(intent);
    }
}
