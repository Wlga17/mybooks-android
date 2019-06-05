package dev.expertsunited.mybooks.daoTeste;

import android.content.Context;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import dev.expertsunited.mybooks.database.LivroDAO;
import dev.expertsunited.mybooks.model.Livro;

@RunWith(MockitoJUnitRunner.class)
public class LivroDAOTest {

    @Mock
    private Context context;
    @Mock
    private LivroDAO dao;

    private Livro livro;

    @Before
    public void iniciarObjetos() {
        dao = new LivroDAO(context);
        livro = new Livro();
    }

    @Test(expected = RuntimeException.class)
    public void invalidaCadastroLivroTest() {
        //Arrumat
        livro.setTitulo("");
        livro.setAutor("");

        //Agir
        boolean result = dao.cadastrar(livro);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void validaCadastroLivroTest() {
        //Arrumat
        livro.setTitulo("titulo1");
        livro.setAutor("abc");
        livro.setValor(20.0);

        //Agir
        boolean result = dao.cadastrar(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void invalidaCadastroLivroNuloTest() {
        //Arrumat
        livro = null;

        //Agir
        boolean result = dao.cadastrar(livro);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void invalidarAtualizarLivroTest() {
        //Arrumat
        livro.setTitulo("cd");
        livro.setAutor("a");

        //Agir
        boolean result = dao.alterar(livro);

        //Afirmar
        Assert.assertFalse(result);
    }

    @After
    public void destruirObjetos(){
        dao = null;
        livro = null;
    }

}
