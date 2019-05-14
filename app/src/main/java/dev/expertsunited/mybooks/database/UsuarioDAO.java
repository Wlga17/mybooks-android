package dev.expertsunited.mybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

    private SQLiteDatabase db;
    private SQLiteDatabase dbQuery;

    public UsuarioDAO(Context context) {
        DbHelper dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
        dbQuery = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean cadastrar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("login", usuario.getLogin());
        cv.put("senha", usuario.getSenha());

        try {
            db.insert("usuarios", null, cv);
            Log.e("INFO", "Cadastrado com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao cadastrar usuario " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        return false;
    }


    @Override
    public String validarLogin(String login, String senha) {
        Cursor c = dbQuery.rawQuery("SELECT * FROM usuarios WHERE login=? AND senha=?", new String[] {login, senha});
        if (c.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }

    @Override
    public String pegarId(String login, String senha) {
        Cursor c = dbQuery.rawQuery("SELECT _id FROM usuarios WHERE login=? AND senha=?", new String[] {login, senha});
        return c.toString();
    }
}
