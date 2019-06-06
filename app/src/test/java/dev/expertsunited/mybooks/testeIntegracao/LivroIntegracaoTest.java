package dev.expertsunited.mybooks.testeIntegracao;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import dev.expertsunited.mybooks.fachada.Fachada;
import dev.expertsunited.mybooks.model.Livro;

@RunWith(MockitoJUnitRunner.class)
public class LivroIntegracaoTest {

    @Mock
    private Fachada fachada;

    private Livro livro;

    @Before
    public void iniciarObjetos() {
        fachada = new Fachada();
        livro = new Livro();
    }

    @Test
    public void validaCadastroLivroTest() {
        //Arrumat
        livro.setTitulo("titulo1");
        livro.setAutor("anamaria");
        livro.setEdicao("edicao1");
        livro.setEditora("joaomaria");
        livro.setIndicacao("ricardo");
        livro.setValor(50.0);

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSemTodosOsAtributosTest() {
        //Arrumat
        livro.setTitulo("titulo1");
        livro.setAutor("abc");
        livro.setValor(20.0);

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test(expected = NullPointerException.class)
    public void validaCadastroLivroNuloTest() {
        //Arrumat
        livro = null;

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarCadastroLivroSemValorTest() {
        //Arrumat
        livro.setTitulo("");
        livro.setAutor("");
        livro.setEdicao("");
        livro.setEditora("");
        livro.setIndicacao("");
        livro.setValor(0.0);

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarCadastroLivroFormatoIncorretoTest() {
        //Arrumat
        livro.setTitulo("aed");
        livro.setAutor("da");
        livro.setEdicao("b");
        livro.setEditora("a");
        livro.setIndicacao("al");
        livro.setValor(10982.0);

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoTituloTest() {
        //Arrumat
        livro.setTitulo("aedkdfay");

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoAutorTest() {
        //Arrumat
        livro.setAutor("joaomario");

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoEdicaoTest() {
        //Arrumat
        livro.setEdicao("edicao1");

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoEditoraTest() {
        //Arrumat
        livro.setEditora("mariajoao");

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoIndicacaoTest() {
        //Arrumat
        livro.setIndicacao("marioJose");

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroLivroSoPassandoPrecoTest() {
        //Arrumat
        livro.setValor(100.0);

        //Agir
        boolean result = fachada.cadatrarLivro(livro);

        //Afirmar
        Assert.assertTrue(result);
    }

    @After
    public void destruirObjetos(){
        fachada = null;
        livro = null;
    }

}
