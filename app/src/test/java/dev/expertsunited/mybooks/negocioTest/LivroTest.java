package dev.expertsunited.mybooks.negocioTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dev.expertsunited.mybooks.RegraDeNegocio.LivroNegocio;
import dev.expertsunited.mybooks.model.Livro;

public class LivroTest {

    private Livro livro;
    private LivroNegocio regra;

    private String tituloSoNumero;
    private String tituloValidoSoLetraMinuscula;
    private String tituloInvalidoSoLetraMinuscula;
    private String tituloValidoSoLetraMaiuscula = "HARRY DAVIDSON";

    @Before
    public void iniciarObjeto(){
        livro = new Livro();
        regra = new LivroNegocio();
    }

    @Test
    public void validarTituloSoNumero(){
        //Arranjar
        String titulo = "123456";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validatarTituloSoLetraMinuscula(){
        //Arranjar
        String titulo = "asdfsd";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarTituloSoLetraMaisucula(){
        //Arranjar
        String titulo = "MAODEDEUS";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarTituloCurtoTest(){
        //Arranjar
        String titulo = "nos";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarTituloExcedenteTest(){
        //Arranjar
        String titulo = "O Curioso Caso de Benjaminho Botao das neves";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertFalse(result);
    }
    @Test
    public void validarTituloFormatoCorreto(){
        //Arranjar
        String titulo = "O Ano 1";

        //Agir
        boolean result = regra.validarTituloFormato(titulo);

        //Afirmar
        Assert.assertFalse(result);
    }


    @After
    public void destruirObjetos(){
        livro = null;
        regra = null;
    }


}
