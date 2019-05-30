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
        Assert.assertFalse(result);
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



    @After
    public void destruirObjetos(){
        livro = null;
        regra = null;
    }


}
