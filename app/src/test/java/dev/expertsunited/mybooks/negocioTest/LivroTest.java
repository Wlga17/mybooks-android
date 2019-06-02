package dev.expertsunited.mybooks.negocioTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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

    @Test
    public void invalidarAutorFormatoCorretoTest(){
        //Arranjar
        String autor_Invalido = "123456";

        //Agir
        result = regra.validarAutorFormato(autor_Invalido);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarAutorNuloTest(){
        //Arranjar
        String autor_naoNulo = "Eu que fiz";

        //Agir
        result = regra.validarAutorNulo(autor_naoNulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarAutorNuloTest(){
        //Arranjar
        String autor_nulo = "";

        //Agir
        result = regra.validarAutorNulo(autor_nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEdicaoFormatoTest(){
        //Arranjar
        String edicao = "Luxo 123";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoNumeroTest(){
        //Arranjar
        String edicao = "123456";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoLetraMinusculaTest(){
        //Arranjar
        String edicao = "edicao barata";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoLetraMaiuscula(){
        //Arranjar
        String edicao = "EDICAO CARA";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoLetraNumero(){
        //Arranjar
        String edicao = "Edicao 123";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEdicaoNulo(){
        //Arranjar
        String edicao = "";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEdicaoCurtaTest(){
        //Arranjar
        String edicao = "e";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEdicaoExcedente(){
        //Arranjar
        String edicao = "minhanadamolevidapassandodoslimites";

        //Agir
        result = regra.validarEdicaoFormato(edicao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEdicaoNuloTest(){
        //Arranjar
        String edicao = "edicao";

        //Agir
        result = regra.validarEdicaoNulo(edicao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEdicaoNuloTest(){
        //Arranjar
        String edicao = "";

        //Agir
        result = regra.validarEdicaoNulo(edicao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEditoraFormatoCorreto(){
        //Arranjar
        String editora = "Editora luz e vida";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEditoraSoLetraMinuscula(){
        //Arranjar
        String editora = "editora do bem";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEditoraSoLetraMaiuscula(){
        //Arranjar
        String editora = "EDITORA DO MAL";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEditoraNumeroMinimo(){
        //Arranjar
        String editora = "edi";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraNumeroMaximo(){
        //Arranjar
        String editora = "editoraquenaopassapelavalidacaodenumeromaximo";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraLetra(){
        //Arranjar
        String editora = "12345";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraLetraNumero(){
        //Arranjar
        String editora = "12345naoVale";

        //Agir
        result = regra.validarEditoraFormato(editora);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEditoraNulo(){
        //Arranjar
        String editora = "editora aprovada";

        //Agir
        result = regra.validarEditoraNulo(editora);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEditoraNulo(){
        //Arranjar
        String editora = "";

        //Agir
        result = regra.validarEditoraNulo(editora);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarIndicacaoFormatoCorretoTest(){
        //Arranjar
        String indicacao = "Indicacao aprovada";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarIndicacoSoMinuscula(){
        //Arranjar
        String indicacao = "indicacao minuscula";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarIndicacoSoMaiuscula(){
        //Arranjar
        String indicacao = "IDICACAO MAIUSCULA";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarIndicacaoNumero(){
        //Arranjar
        String indicacao = "123456";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarIndicacaoNumeroLetra(){
        //Arranjar
        String indicacao = "testando123456";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarIndicacaoNulo(){
        //Arranjar
        String indicacao = "Indicacao valida";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarIndicacaoNulo(){
        //Arranjar
        String indicacao = "";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao);

        //Afirmar
        Assert.assertFalse(result);
    }

    @After
    public void destruirObjetos(){
        regra = null;
        result = null;
    }


}
