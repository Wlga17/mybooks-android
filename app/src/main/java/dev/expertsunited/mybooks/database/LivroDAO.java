package dev.expertsunited.mybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
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
        cv.put("isBiblioteca", livro.isBiblioteca());
        cv.put("isDesejo", livro.isDesejo());
        cv.put("isLidos", livro.isLidos());

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


        ContentValues cv = new ContentValues();
        cv.put("titulo", livro.getTitulo());
        cv.put("autor", livro.getAutor());
        cv.put("edicao", livro.getEdicao());
        cv.put("editora", livro.getEditora());
//        cv.put("indicacao", livro.getIndicacao());
        cv.put("preco", livro.getValor());
//        cv.put("_id", livro.getId());
//        cv.put("capa", livro.getCapa());
//        cv.put("isBiblioteca", livro.isBiblioteca());
//        cv.put("isDesejo", livro.isDesejo());
//        cv.put("isLidos", livro.isLidos());

        try {
            String[] dados = {livro.getId().toString()};
            db.update("livros", cv, "_id=?", dados);

        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public void deletar(String mTitulo) {
        String[] dados = {mTitulo};
        db.delete("livros", "titulo = ?", dados);
    }

    @Override
    public List<Livro> listaDeBiblioteca() {
        List<Livro> lista = new ArrayList<>();

        String sql = "SELECT _id,titulo,capa,autor,edicao,editora,preco FROM livros WHERE isBiblioteca=1;";

        Cursor c = dbQuery.rawQuery(sql, null);

        while(c.moveToNext()){

            Livro livro = new Livro();
            Integer id = c.getInt(c.getColumnIndex("_id"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String edicao = c.getString(c.getColumnIndex("edicao"));
            String editora = c.getString(c.getColumnIndex("editora"));
            Double preco = c.getDouble(c.getColumnIndex("preco"));
            byte[] capa = c.getBlob(c.getColumnIndex("capa"));

            livro.setId(id);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setEdicao(edicao);
            livro.setEditora(editora);
            livro.setValor(preco);
            livro.setCapa(capa);
            lista.add(livro);

        }

        return lista;

    }

    @Override
    public List<Livro> listaDeDesejos() {

        List<Livro> lista = new ArrayList<>();

        String sql = "SELECT _id,titulo,capa,autor,edicao,editora,preco FROM livros WHERE isDesejo=1;";

        Cursor c = dbQuery.rawQuery(sql, null);

        while(c.moveToNext()){

            Livro livro = new Livro();
            Integer id = c.getInt(c.getColumnIndex("_id"));
            String titulo = c.getString(c.getColumnIndex("titulo"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String edicao = c.getString(c.getColumnIndex("edicao"));
            String editora = c.getString(c.getColumnIndex("editora"));
            Double preco = c.getDouble(c.getColumnIndex("preco"));
            byte[] capa = c.getBlob(c.getColumnIndex("capa"));

            livro.setId(id);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setEdicao(edicao);
            livro.setEditora(editora);
            livro.setValor(preco);
            livro.setCapa(capa);
            lista.add(livro);

        }

        return lista;

    }
}
