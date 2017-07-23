package br.com.damasceno.hackthon_cielo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by damasceno on 21/07/17.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "fidelidade.db";
    public static final int VERSION = 4;

    public static final String TBL_CLIENTE = "cliente";
    public static final String CLIENTE_ID = "_id";
    public static final String CLIENTE_CPF = "cpf";
    public static final String CLIENTE_EMAIL = "email";
    public static final String CLIENTE_NOME = "nome";
    public static final String CLIENTE_PONTOS = "pontos";
    public static final String CLIENTE_CHECKS = "checks";

    public static final String TBL_CARTAO = "cartao";
    public static final String CARTAO_ID = "_id";
    public static final String CARTAO_NUM_CHECKS = "num_checks";
    public static final String CARTAO_PREMIO = "premio";

    private static final String CARTAO_CREATE_TABLE = "CREATE TABLE "
            + TBL_CARTAO + " ("
            + CARTAO_ID + " INTEGER PRIMARY KEY, "
            + CARTAO_NUM_CHECKS + " INTEGER NOT NULL, "
            + CARTAO_PREMIO + "TEXT NULL);";

    private static final String CLIENTE_CREATE_TABLE = "CREATE TABLE "
            + TBL_CLIENTE + " ("
            + CLIENTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CLIENTE_CPF + " TEXT NOT NULL UNIQUE, "
            + CLIENTE_EMAIL + " TEXT NOT NULL, "
            + CLIENTE_NOME + " TEXT NOT NULL, "
            + CLIENTE_CHECKS + " INTEGER NULL, "
            + CLIENTE_PONTOS + " INTEGER NULL);";

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CARTAO_CREATE_TABLE);
        db.execSQL(CLIENTE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_CARTAO);
        onCreate(db);
    }
}
