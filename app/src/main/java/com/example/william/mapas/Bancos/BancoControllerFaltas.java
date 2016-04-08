package com.example.william.mapas.Bancos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by william on 18/03/2016.
 */
public class BancoControllerFaltas {
    private SQLiteDatabase dbFaltas;
    private CriaBanco bancoFaltas;

    public BancoControllerFaltas(Context context){
        bancoFaltas = new CriaBanco(context);
    }

    public String insereDado(int    id2,
                             String domingo,
                             String segunda,
                             String terca,
                             String quarta,
                             String quinta,
                             String sexta,
                             String sabado,
                             String data,
                             String localizacao1,
                             String localizacao2,
                             String observacao){
        ContentValues valores;
        long resultado;

        dbFaltas = bancoFaltas.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.ID_CONFIG,    String.valueOf(id2));
        valores.put(CriaBanco.DOMINGO,      domingo);
        valores.put(CriaBanco.SEGUNDA,      segunda);
        valores.put(CriaBanco.TERCA,        terca);
        valores.put(CriaBanco.QUARTA,       quarta);
        valores.put(CriaBanco.QUINTA,       quinta);
        valores.put(CriaBanco.SEXTA,        sexta);
        valores.put(CriaBanco.SABADO,       sabado);
        valores.put(CriaBanco.DATA,         data);
        valores.put(CriaBanco.LOCALIZACAO1, localizacao1);
        valores.put(CriaBanco.LOCALIZACAO2, localizacao2);
        valores.put(CriaBanco.OBSERVACAO,   observacao);

        resultado = dbFaltas.insert(CriaBanco.TAB_FALTAS, null, valores);
        dbFaltas.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";


    }

    public Cursor carregaDados(int posicao){
        Cursor cursor;
        String[] campos = { bancoFaltas.IDFALTAS,
                            bancoFaltas.ID_CONFIG,
                            bancoFaltas.DOMINGO,
                            bancoFaltas.SEGUNDA,
                            bancoFaltas.TERCA,
                            bancoFaltas.QUARTA,
                            bancoFaltas.QUINTA,
                            bancoFaltas.SEXTA,
                            bancoFaltas.SABADO,
                            bancoFaltas.LOCALIZACAO1,
                            bancoFaltas.LOCALIZACAO2,
                            bancoFaltas.OBSERVACAO };
        dbFaltas = bancoFaltas.getReadableDatabase();
        cursor = dbFaltas.query(CriaBanco.TAB_FALTAS, campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToPosition(posicao);
        }
        dbFaltas.close();
        return cursor;
    }
    public Cursor ultimoRegistroID(){
        Cursor cursor;
        dbFaltas = bancoFaltas.getReadableDatabase();
        cursor = dbFaltas.query(CriaBanco.TAB_FALTAS, null, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToLast();
        }
        dbFaltas.close();
        return cursor;
    }

}

