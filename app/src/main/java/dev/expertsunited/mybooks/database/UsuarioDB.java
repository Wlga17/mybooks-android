package dev.expertsunited.mybooks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDB extends SQLiteOpenHelper {

    private static final String DATABASE = "usuarioDB";
    private static final int VERSION = 1;

    public UsuarioDB(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelaUsuario = "CREATE TABLE usuario(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                                                     "nome VARCHAR NOT NULL, " +
                                                     "email VARCHAR NOT NULL, " +
                                                     "login VARCHAR NOT NULL, " +
                                                     "senha VARCHAR NOT NULL);";
        db.execSQL(tabelaUsuario);
    }

    public void onUpgrade(SQLiteDatabase db, int versao, int novaVersao) {
        String tabelaUsuario = "DROP TABLE IF EXISTS usuario";

        db.execSQL(tabelaUsuario);
    }
}
