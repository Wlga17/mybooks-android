package dev.expertsunited.mybooks.RegraDeNegocio;

import android.content.Context;

import dev.expertsunited.mybooks.database.ILivroDAO;
import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

public class LivroNegocio {

    private ILivroDAO dao;

    public LivroNegocio(Context  context) {
        dao = new LivroDAO(context);
    }

    public void validarNuloCadastro(Livro livro) throws Exception{
        if (livro == null){
            throw new Exception("Null! ");
        }
        if (livro.getTitulo().equals("") || livro.getTitulo() == null) {
            throw new Exception("Informe o titulo do livro! ");
        }
        if (livro.getAutor().equals("") || livro.getAutor() == null){
            throw new Exception("Informe o autor do livro! ");
        }
        if (!livro.getEditora().matches("[A-Za-z]")) {
            throw new Exception("Editora invalida! ");
        }
        if (!livro.getIndicacao().matches("[A-Za-z]")) {
            throw new Exception("Nome invalido! ");
        }
    }

    public void validarValorLivro(Livro livro) throws Exception{
        if (livro.getValor().isNaN()){
            throw new Exception("Valor invalido! ");
        }
    }

    public void validarTituloDuplo(String titulo) throws Exception{
        if (dao.consultarTitulo(titulo)){
            throw new Exception("Esse titulo ja existe! ");
        }
    }

}
