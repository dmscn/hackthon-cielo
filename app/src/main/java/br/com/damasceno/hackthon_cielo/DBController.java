package br.com.damasceno.hackthon_cielo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by damasceno on 22/07/17.
 */

public class DBController {
    private static SQLiteDatabase db;
    private static SQLiteOpenHelper dbHelper;

    public DBController (Context context) {
        dbHelper = new DBOpenHelper(context);
    }

    private boolean emailCadastrado(String email) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String[] fields = {DBOpenHelper.TBL_CLIENTE};
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, null, null, null, null, null, null);

        if(cursor != null) {
            return true;
        }

        return false;
    }

    private int contarChecks(String email) {
        Cursor cursor;
        db = dbHelper.getReadableDatabase();
        String[] fields = {DBOpenHelper.CLIENTE_CHECKS};
        cursor = db.query(DBOpenHelper.TBL_CLIENTE, fields, null, null, null, null, null, null);
    }

    private void zerarChecks(String email) {
        db = dbHelper.getWritableDatabase();
        db.execSQL("UPDATE " + DBOpenHelper.TBL_CLIENTE
                + " SET " + DBOpenHelper.CLIENTE_CHECKS + " =0 " +
                "WHERE " + DBOpenHelper.CLIENTE_EMAIL + " = " + email + ";");
    }

    private void deletarCartao(int idCartao) {
        // TODO
        // deletar do banco de dados also
    }

    private void addCheck(String email, int idCartao) {
        // TODO
    }
}
