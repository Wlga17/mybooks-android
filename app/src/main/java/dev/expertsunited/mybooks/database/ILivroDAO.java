package dev.expertsunited.mybooks.database;

import java.util.List;

import dev.expertsunited.mybooks.model.Livro;

public interface ILivroDAO {
    public boolean cadastrar(Livro livro);
    public boolean alterar(Livro livro);
    public void deletar (String mTitulo);
    public List<Livro> listaDeBiblioteca();
    public List<Livro> listaDeDesejos();
}
