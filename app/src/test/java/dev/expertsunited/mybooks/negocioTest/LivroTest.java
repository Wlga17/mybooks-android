package dev.expertsunited.mybooks.negocioTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dev.expertsunited.mybooks.RegraDeNegocio.LivroNegocio;
import dev.expertsunited.mybooks.model.Livro;

public class LivroTest {


    private LivroNegocio regra;
    private Boolean result;


    @Before
    public void iniciarObjeto(){

        regra = new LivroNegocio();
        result = true;
    }

    @Test
    public void validarTituloSoNumeroTest(){
        //Arranjar
        String titulo_So_Numero = "123456";

        //Agir
        result = regra.validarTituloFormato(titulo_So_Numero);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validatarTituloSoLetraMinusculaTest(){
        //Arranjar
        String titulo_So_Minuscula = "asdfsd";

        //Agir
        result = regra.validarTituloFormato(titulo_So_Minuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarTituloSoLetraMaisuculaTest(){
        //Arranjar
        String titulo_So_Maiuscula = "MAODEDEUS";

        //Agir
        result = regra.validarTituloFormato(titulo_So_Maiuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarTituloCurtoTest(){
        //Arranjar
        String titulo_Curto = "nos";

        //Agir
        result = regra.validarTituloFormato(titulo_Curto);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarTituloExcedenteTest(){
        //Arranjar
        String titulo_Excedente = "O Curioso Caso de Benjaminho Botao das neves";

        //Agir
        result = regra.validarTituloFormato(titulo_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarTituloFormatoCorretoTest(){
        //Arranjar
        String titulo_Valido = "O Ano é 1";

        //Agir
        result = regra.validarTituloFormato(titulo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarTituloNaoNuloTest(){
        //Arranjar
        String titulo_Nao_Nulo = "ABC Facil";

        //Agir
        result = regra.validarTituloNulo(titulo_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarTituloNuloTest(){
        //Arranjar
        String titulo_Nulo = "";

        //Agir
        result = regra.validarTituloNulo(titulo_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarAutorFormatoCorretoTest(){
        //Arranjar
        String autor_Valido = "Roberval Antônio de Melo";

        //Agir
        result = regra.validarAutorFormato(autor_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }




    @After
    public void destruirObjetos(){
        regra = null;
        result = null;
    }


}
