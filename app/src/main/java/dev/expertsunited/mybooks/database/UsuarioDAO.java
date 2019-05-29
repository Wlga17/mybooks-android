package dev.expertsunited.mybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import dev.expertsunited.mybooks.RegraDeNegocio.UsuarioNegocio;
import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

    private SQLiteDatabase db;
    private SQLiteDatabase dbQuery;
    private UsuarioNegocio regra;

    public UsuarioDAO(Context context) {
        DbHelper dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
        dbQuery = dbHelper.getReadableDatabase();
        regra = new UsuarioNegocio();
    }

    @Override
    public boolean cadastrar(Usuario usuario) {

        String email = usuario.getEmail();
        regra.validarEmailFormato(email);

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
        String email = usuario.getEmail();
        regra.validarEmailFormato(email);

        String sql = "SELECT * FROM usuarios WHERE _id=?;";
        Cursor c = dbQuery.rawQuery(sql, new String[] {usuario.getId().toString()});
        if (c.getCount() > 0){
            ContentValues cv = new ContentValues();
            cv.put("nome", usuario.getNome());
            cv.put("email", usuario.getEmail());
            cv.put("login", usuario.getLogin());
            cv.put("senha", usuario.getSenha());

            String[] dados = {usuario.getId().toString()};
            db.update("usuarios", cv, "_id=?", dados);
            c.close();
            return true;
        }else {
            return false;
        }
    }


    @Override
    public String validarLogin(String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE login=? AND senha=?;";
        Cursor c = dbQuery.rawQuery(sql, new String[] {login, senha});
        if (c.getCount() > 0) {
            return "OK";
        }
        c.close();
        return "ERRO";
    }


    @Override
    public String pegarId(String login, String senha) {
        String sql = "SELECT _id FROM usuarios WHERE login=? AND senha=?;";
        Cursor c = dbQuery.rawQuery(sql, new String[] {login, senha});
        String result = c.toString();
        c.close();
        return result;
    }
}
