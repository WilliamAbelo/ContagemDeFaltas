package com.example.william.mapas.Alarme;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Created by william on 31/03/2016.
 */
public class Data {

    public String data(){
        String diaSemana = null;
        Date dataAtual = new Date();
        dataAtual.getTime();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataEhoraFormatada = dt.format(dataAtual);

        String dataHora[]         = dataEhoraFormatada.split(Pattern.quote(" "));
        String dataSeparada[]     = dataHora[0].split(Pattern.quote("/"));

        Calendar calendario = new GregorianCalendar(Integer.valueOf(dataSeparada[2]), Integer.valueOf(dataSeparada[1]) - 1, Integer.valueOf(dataSeparada[0]));
        int _diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        switch (_diaSemana)
        {

            case 1:
            {
                diaSemana = "Domingo";
                break;
            }
            case 2:
            {
                diaSemana = "Segunda";
                break;
            }
            case 3:
            {
                diaSemana = "Terça";
                break;
            }
            case 4:
            {
                diaSemana = "Quarta";
                break;
            }
            case 5:
            {
                diaSemana = "Quinta";
                break;
            }
            case 6:
            {
                diaSemana = "Sexta";
                break;
            }
            case 7:
            {
                diaSemana = "Sábado";
                break;
            }

        }
        Log.e("cursor", "Dia da Semana: " + diaSemana);
        return dataEhoraFormatada;
    }

    public String dataAtual(){
        Date dataAtual = new Date();
        dataAtual.getTime();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = dt.format(dataAtual);

        String dataHora[] = dataFormatada.split(Pattern.quote(" "));

        return dataHora[0];
    }

    public String diaDaSemana(){
        String diaSemana = null;
        Date dataAtual = new Date();
        dataAtual.getTime();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = dt.format(dataAtual);

        String dataHora[]         = dataFormatada.split(Pattern.quote(" "));
        String dataSeparada[]     = dataHora[0].split(Pattern.quote("/"));

        Calendar calendario = new GregorianCalendar(Integer.valueOf(dataSeparada[2]), Integer.valueOf(dataSeparada[1]) - 1, Integer.valueOf(dataSeparada[0]));
        int _diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        switch (_diaSemana)
        {

            case 1:
            {
                diaSemana = "Domingo";
                break;
            }
            case 2:
            {
                diaSemana = "Segunda";
                break;
            }
            case 3:
            {
                diaSemana = "Terça";
                break;
            }
            case 4:
            {
                diaSemana = "Quarta";
                break;
            }
            case 5:
            {
                diaSemana = "Quinta";
                break;
            }
            case 6:
            {
                diaSemana = "Sexta";
                break;
            }
            case 7:
            {
                diaSemana = "Sábado";
                break;
            }

        }
        return diaSemana;
    }

    public String horaAtual(){
        Date dataAtual = new Date();
        dataAtual.getTime();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = dt.format(dataAtual);

        String dataHora[]         = dataFormatada.split(Pattern.quote(" "));
        String horaSeparada[]     = dataHora[1].split(Pattern.quote(":"));

        return horaSeparada[0];
    }

    public String minutoAtual(){
        Date dataAtual = new Date();
        dataAtual.getTime();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataFormatada = dt.format(dataAtual);;

        String dataHora[]         = dataFormatada.split(Pattern.quote(" "));
        String horaSeparada[]     = dataHora[1].split(Pattern.quote(":"));

        return horaSeparada[1];
    }
}
