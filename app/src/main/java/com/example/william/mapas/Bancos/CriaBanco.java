package com.example.william.mapas.Bancos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by william on 18/03/2016.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO   = "banco.db";
    public static final int VERSAO = 1;

    public static final String TAB_CONFIG   = "tabConfig";
    public static final String IDCONFIG     = "_id";
    public static final String ATIVO        = "ativo";
    public static final String HORARIO      = "horario";
    public static final String LOCAL        = "local";
    public static final String OBSERVACAO   = "observacao";


    public static final String TAB_FALTAS   = "tabFaltas";
    public static final String IDFALTAS     = "_id";
    public static final String ID_CONFIG    = "idConfig";
    public static final String SEGUNDA      = "segunda";
    public static final String TERCA        = "terca";
    public static final String QUARTA       = "quarta";
    public static final String QUINTA       = "quinta";
    public static final String SEXTA        = "sexta";
    public static final String SABADO       = "sabaddo";
    public static final String DOMINGO      = "domingo";
    public static final String DATA         = "data";
    public static final String LOCALIZACAO1 = "localizacao1";
    public static final String LOCALIZACAO2 = "localizacao2";

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabConfig(db);
        criarTabFaltas(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TAB_CONFIG);
        onCreate(db);
    }

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    public void criarTabConfig(SQLiteDatabase db){
        String sql = "CREATE TABLE "
                + TAB_CONFIG
                +"("
                + IDCONFIG      + " integer primary key autoincrement,"
                + ATIVO         + " text,"
                + HORARIO       + " text,"
                + LOCAL         + " text,"
                + OBSERVACAO    + " text"
                +")";
        db.execSQL(sql);
    }

    public void criarTabFaltas(SQLiteDatabase db){
        String sql = "CREATE TABLE "
                + TAB_FALTAS
                +"("
                + IDFALTAS      + " integer primary key autoincrement,"
                + ID_CONFIG     + " integer,"
                + DOMINGO       + " text,"
                + SEGUNDA       + " text,"
                + TERCA         + " text,"
                + QUARTA        + " text,"
                + QUINTA        + " text,"
                + SEXTA         + " text,"
                + SABADO        + " text,"
                + DATA          + " text,"
                + LOCALIZACAO1  + " text,"
                + LOCALIZACAO2  + " text,"
                + OBSERVACAO    + " text"
                +")";
        db.execSQL(sql);
    }

}