package dev.expertsunited.mybooks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static String DATABASE = "mybooks";
    private static int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableUser = "CREATE TABLE IF NOT EXISTS usuarios " +
                              " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                              " nome TEXT NOT NULL, " +
                              " email TEXT NOT NULL UNIQUE, " +
                              " login TEXT NOT NULL UNIQUE, " +
                              " senha TEXT NOT NULL ); ";

        String tableBook =    "CREATE TABLE IF NOT EXISTS livros " +
                                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                " titulo TEXT UNIQUE NOT NULL, " +
                                " autor TEXT NOT NULL, " +
                                " editora TEXT, " +
                                " edicao TEXT, " +
                                " indicacao TEXT, " +
                                " preco TEXT, " +
                                " capa BLOB ); ";
        try {
            db.execSQL( tableUser );
            db.execSQL( tableBook );
            Log.i("info DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("info DB", "Erro ao criar a tabela" + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS usuarios ;";

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("info DB", "Sucesso ao atualizar a tabela" );
        }catch (Exception e){
            Log.i("info DB", "Erro ao atualizar a tabela" + e.getMessage() );
        }
    }
}
