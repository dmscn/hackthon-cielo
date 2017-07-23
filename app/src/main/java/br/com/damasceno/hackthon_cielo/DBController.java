package br.com.damasceno.hackthon_cielo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

/**
 * Created by damasceno on 22/07/17.
 */

public class DBController {
    private static SQLiteDatabase db;
    private static SQLiteOpenHelper dbHelper;

    public DBController (Context context) {
        dbHelper = new DBOpenHelper(context);
    }

    public boolean cpfCadastrado(String cpf) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String [] fields = {DBOpenHelper.CLIENTE_CPF};
        String where = DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "'";
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, where, null, null, null, null, null);

        // cursor.moveToFirst();

        if(cursor.moveToNext()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void cadastra(String cpf, String email, String nome) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("INSERT INTO " + DBOpenHelper.TBL_CLIENTE + "(" + DBOpenHelper.CLIENTE_CPF + ", " +  DBOpenHelper.CLIENTE_EMAIL + ", " + DBOpenHelper.CLIENTE_NOME + ") values ('" + cpf + "', '" + email + "', '" + nome + "');");
    }

    public int showChecks(String cpf) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String [] fields = {DBOpenHelper.CLIENTE_CHECKS};
        String where = DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "'";
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, where, null, null, null, null, null);
        return Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.CLIENTE_CHECKS)));
    }

    public void zerarChecks(String cpf) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_CHECKS + " = 0"
                + " WHERE " + DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "';");
    }

    public void addCheck(String cpf) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_CHECKS + " = " + DBOpenHelper.CLIENTE_CHECKS + " + 1"
                + " WHERE " + DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "';");
    }

    public int showPontos(String cpf) {
        Cursor cursor;
        db = dbHelper.getWritableDatabase();
        String [] fields = {DBOpenHelper.CLIENTE_PONTOS};
        String where = DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "'";
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, where, null, null, null, null, null);
        return Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.CLIENTE_PONTOS)));
    }

    public void addPontos(String cpf, int pontos) {
        Cursor cursor;
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_PONTOS + " = " + DBOpenHelper.CLIENTE_PONTOS + " + " + pontos
                + " WHERE " + DBOpenHelper.CLIENTE_CPF + " = '" + cpf + "';");
    }

    public void dropData() {
        db = dbHelper.getWritableDatabase();
        db.execSQL("DROP TABLE cliente;");
        db.execSQL("DROP TABLE cartao;");
    }
}
