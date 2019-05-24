package dev.expertsunited.mybooks.database;

import java.util.List;

import dev.expertsunited.mybooks.model.Livro;

public interface ILivroDAO {
    boolean cadastrar(Livro livro) throws Exception;
    boolean alterar(Livro livro) throws Exception;
    void deletar (String mTitulo);
    List<Livro> listaDeBiblioteca();
    List<Livro> listaDeDesejos();
    boolean consultarTitulo(String titulo);
}
