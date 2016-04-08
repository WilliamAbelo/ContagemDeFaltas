package com.example.william.mapas.Alarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.william.mapas.Bancos.ManipulacaoBancos;

/**
 * Created by william on 16/03/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    public String domingo;
    public String segunda;
    public String terca;
    public String quarta;
    public String quinta;
    public String sexta;
    public String sabado;

    @Override
    public void onReceive(Context context, Intent intent) {
        salvarFaltasBanco(context);
        Toast.makeText(context, "Contador de Faltas Ativo", Toast.LENGTH_SHORT).show();
    }


    public void salvarFaltasBanco(Context context) {
        VariaveisDaTabFaltas variaveisDaTabFaltas = new VariaveisDaTabFaltas();
        String diaSemana = variaveisDaTabFaltas.pegarDiaDaSemana();
        int idConfig = variaveisDaTabFaltas.carregaDados(context).getInt(0);
        String data = variaveisDaTabFaltas.pegarData();
        String localSalvo = variaveisDaTabFaltas.pegarLocalSalvo(context);
        String localAtual = String.valueOf(variaveisDaTabFaltas.pegarLocalAtual());
        String obs = variaveisDaTabFaltas.carregaDados(context).getString(4);

        switch (diaSemana) {
            case "Domingo": {
                domingo = variaveisDaTabFaltas.falta(context);
                segunda = "x";
                terca = "x";
                quarta = "x";
                quinta = "x";
                sexta = "x";
                sabado = "x";

                break;
            }
            case "Segunda": {
                domingo = "x";
                segunda = variaveisDaTabFaltas.falta(context);
                terca = "x";
                quarta = "x";
                quinta = "x";
                sexta = "x";
                sabado = "x";

                break;
            }
            case "Terça": {
                domingo = "x";
                segunda = "x";
                terca = variaveisDaTabFaltas.falta(context);
                quarta = "x";
                quinta = "x";
                sexta = "x";
                sabado = "x";

                break;
            }
            case "Quarta": {
                domingo = "x";
                segunda = "x";
                terca = "x";
                quarta = variaveisDaTabFaltas.falta(context);
                quinta = "x";
                sexta = "x";
                sabado = "x";

                break;
            }
            case "Quinta": {
                domingo = "x";
                segunda = "x";
                terca = "x";
                quarta = "x";
                quinta = variaveisDaTabFaltas.falta(context);
                sexta = "x";
                sabado = "x";

                break;
            }
            case "Sexta": {
                domingo = "x";
                segunda = "x";
                terca = "x";
                quarta = "x";
                quinta = "x";
                sexta = variaveisDaTabFaltas.falta(context);
                sabado = "x";

                break;
            }
            case "Sábado": {
                domingo = "x";
                segunda = "x";
                terca = "x";
                quarta = "x";
                quinta = "x";
                sexta = "x";
                sabado = variaveisDaTabFaltas.falta(context);

                break;
            }
        }

        ManipulacaoBancos manipulacaoBancos = new ManipulacaoBancos();
        manipulacaoBancos.salvarTabFaltas(context, idConfig, domingo, segunda, terca, quarta, quinta, sexta, sabado, data, localSalvo, localAtual, obs);
    }
}
