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

    public boolean emailCadastrado(String email) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String [] fields = {DBOpenHelper.TBL_CLIENTE};
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, null, null, null, null, null, null);

        if(cursor != null) return true;

        return false;
    }

    public int showChecks(String email) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String [] fields = {DBOpenHelper.CLIENTE_CHECKS};
        String where = DBOpenHelper.CLIENTE_EMAIL + " = " + email;
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, where, null, null, null, null, null);
        return Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.CLIENTE_CHECKS)));
    }

    public void zerarChecks(String email) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_CHECKS + " = 0"
                + " WHERE " + DBOpenHelper.CLIENTE_EMAIL + " = " + email + ";");
    }

    public void addCheck(String email) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_CHECKS + " = " + DBOpenHelper.CLIENTE_CHECKS + " + 1"
                + " WHERE " + DBOpenHelper.CLIENTE_EMAIL + " = " + email + ";");
    }

    public int showPontos(String email) {
        Cursor cursor;
        db = dbHelper.getWritableDatabase();
        String [] fields = {DBOpenHelper.CLIENTE_PONTOS};
        String where = DBOpenHelper.CLIENTE_EMAIL + " = " + email;
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, where, null, null, null, null, null);
        return Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.CLIENTE_PONTOS)));
    }

    public void addPontos(String email, String pontos) {
        Cursor cursor;
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_PONTOS + " = " + DBOpenHelper.CLIENTE_PONTOS + " + " + pontos
                + " WHERE " + DBOpenHelper.CLIENTE_EMAIL + " = " + email + ";");
    }
}
