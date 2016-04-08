package com.example.william.mapas.Bancos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by william on 18/03/2016.
 */
public class BancoControllerConfig {
    private SQLiteDatabase dbConfig;
    private CriaBanco bancoConfig;

    public BancoControllerConfig(Context context){
        bancoConfig = new CriaBanco(context);
    }

    public String insereDado(String ativo,
                             String horario,
                             String local,
                             String observacao){
        ContentValues valores;
        long resultado;

        dbConfig = bancoConfig.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.ATIVO,        ativo);
        valores.put(CriaBanco.HORARIO,      horario);
        valores.put(CriaBanco.LOCAL,        local);
        valores.put(CriaBanco.OBSERVACAO,   observacao);

        resultado = dbConfig.insert(CriaBanco.TAB_CONFIG, null, valores);
        dbConfig.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";


    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = { CriaBanco.IDCONFIG,
                            CriaBanco.ATIVO,
                            CriaBanco.HORARIO,
                            CriaBanco.LOCAL,
                            CriaBanco.OBSERVACAO};
        dbConfig = bancoConfig.getReadableDatabase();
        cursor = dbConfig.query(CriaBanco.TAB_CONFIG, campos, null, null, null, null, null, null);
        if(cursor!=null){ cursor.moveToLast();
        }
        dbConfig.close();
        return cursor;
    }

}

