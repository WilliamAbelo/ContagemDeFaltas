package com.example.william.mapas.Alarme;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import com.example.william.mapas.Bancos.BancoControllerConfig;
import com.example.william.mapas.Mapas.CalculoDeDistancia;
import com.example.william.mapas.Mapas.GPSBackground;

import java.util.regex.Pattern;

/**
 * Created by william on 31/03/2016.
 */
public class VariaveisDaTabFaltas extends AppCompatActivity {
    public Cursor cursor;

    public static String pegarDiaDaSemana(){
        Data data = new Data();
        return data.diaDaSemana();
    }

    public static String pegarData(){
        Data data = new Data();
        return data.dataAtual();
    }

    public String falta(Context contextBase){
        String posicaoAtual = pegarLocalAtual();
        String posicaoSalva = carregaDados(contextBase).getString(3);
        String falta;
        String latLongAtual[]         = posicaoAtual.split(Pattern.quote(" "));
        String latLongSalva[]         = posicaoSalva.split(Pattern.quote(" "));
        double latAtual = Double.valueOf(latLongAtual[0]);
        double lonAtual = Double.valueOf(latLongAtual[1]);
        double latSalva = Double.valueOf(latLongSalva[0]);
        double lonSalva = Double.valueOf(latLongSalva[1]);

        CalculoDeDistancia calculoDeDistancia = new CalculoDeDistancia();
        double distancia = calculoDeDistancia.distanciaEntrePontos(latSalva,lonSalva, latAtual, lonAtual);

        if(distancia <= 200){
            falta = "P";
        }else {
            falta = "F";
        }
        return falta;
    }

    public Cursor carregaDados(Context contextBase){
        BancoControllerConfig crud = new BancoControllerConfig(contextBase);
        cursor = crud.carregaDados();
        return cursor;
    }

    public String pegarLocalSalvo(Context contextBase){

        return carregaDados(contextBase).getString(3);
    }

    public static String pegarLocalAtual(){

        return String.valueOf(GPSBackground.getLatitude())+" "+String.valueOf(GPSBackground.getLongitude());
    }

}
