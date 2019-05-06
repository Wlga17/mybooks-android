package dev.expertsunited.mybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import dev.expertsunited.mybooks.model.Livro;

public class LivroDAO implements ILivroDAO{

    private SQLiteDatabase db;
    private SQLiteDatabase dbQuery;

    public LivroDAO(Context context) {
        DbHelper dbHelper = new DbHelper( context );
        db = dbHelper.getWritableDatabase();
        dbQuery = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean cadastrar(Livro livro) {

        ContentValues cv = new ContentValues();
        cv.put("titulo", livro.getTitulo());
        cv.put("autor", livro.getAutor());
        cv.put("editora", livro.getEditora());
        cv.put("edicao", livro.getEdicao());
        cv.put("indicacao", livro.getIndicacao());
        cv.put("preco", livro.getValor());
        cv.put("capa", livro.getCapa());
//        cv.put("isBiblioteca", livro.isBiblioteca());
//        cv.put("isDesejo", livro.isDesejo());
//        cv.put("isLidos", livro.isLidos());

        try {
            db.insert("livros", null, cv);
            Log.e("INFO", "Cadastrado com sucesso!");
        }catch(Exception e) {
            Log.e("INFO", "Erro ao cadastrar livro! " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean alterar(Livro livro) {
        return false;
    }

    @Override
    public boolean deletar(Livro livro) {
        return false;
    }

    @Override
    public List<Livro> listar() {
        return null;
    }
}
