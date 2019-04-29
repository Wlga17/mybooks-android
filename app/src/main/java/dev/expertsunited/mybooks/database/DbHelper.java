package dev.expertsunited.mybooks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "mybooks";
    private static final int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableUser = "CREATE TABLE IF NOT EXISTS usuarios (" +
                              "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "nome VARCHAR NOT NULL, " +
                              "email VARCHAR NOT NULL, " +
                              "login VARCHAR NOT NULL, " +
                              "senha VARCHAR NOT NULL); ";

        String tableBook =    "CREATE TABLE IF NOT EXISTS livros (" +
                              "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              "titulo VARCHAR NOT NULL, " +
                              "autor VARCHAR NOT NULL, " +
                              "editora VARCHAR, " +
                              "edicao VARCHAR, " +
                              "indicacao VARCHAR, " +
                              "preco VARCHAR, " +
                              "capa BYTE);";

        db.execSQL(tableUser);
        db.execSQL(tableBook);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
