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
        String autor_NaoNulo = "Eu que fiz";

        //Agir
        result = regra.validarAutorNulo(autor_NaoNulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarAutorNuloTest(){
        //Arranjar
        String autor_Nulo = "";

        //Agir
        result = regra.validarAutorNulo(autor_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEdicaoFormatoTest(){
        //Arranjar
        String edicao_Valida = "Luxo 123";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Valida);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoNumeroTest(){
        //Arranjar
        String edicao_So_Numero = "123456";

        //Agir
        result = regra.validarEdicaoFormato(edicao_So_Numero);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoLetraMinusculaTest(){
        //Arranjar
        String edicao_So_Letras_Minuscula = "edicao barata";

        //Agir
        result = regra.validarEdicaoFormato(edicao_So_Letras_Minuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoSoLetraMaiusculaTest(){
        //Arranjar
        String edicao_So_Letras_Maiuscula = "EDICAO CARA";

        //Agir
        result = regra.validarEdicaoFormato(edicao_So_Letras_Maiuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoFormatoLetraNumeroTest(){
        //Arranjar
        String edicao_Letras_Numeros = "123 Edicao";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Letras_Numeros);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEdicaoNuloTest(){
        //Arranjar
        String edicao_Nulo = "";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEdicaoCurtaTest(){
        //Arranjar
        String edicao_Curta = "e";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Curta);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEdicaoExcedenteTest(){
        //Arranjar
        String edicao_Excedente = "minhanadamolevidapassandodoslimites";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEdicaoNuloTest(){
        //Arranjar
        String edicao_Nulo = "edicao";

        //Agir
        result = regra.validarEdicaoNulo(edicao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }


    @Test
    public void validarEditoraFormatoCorretoTest(){
        //Arranjar
        String editora_Valido = "Editora luz e vida";

        //Agir
        result = regra.validarEditoraFormato(editora_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEditoraSoLetraMinusculaTest(){
        //Arranjar
        String editora_So_Letras_Minusculas = "editora do bem";

        //Agir
        result = regra.validarEditoraFormato(editora_So_Letras_Minusculas);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEditoraSoLetraMaiusculaTest(){
        //Arranjar
        String editora_So_Letras_Maiusculas = "EDITORA DO MAL";

        //Agir
        result = regra.validarEditoraFormato(editora_So_Letras_Maiusculas);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEditoraCurtaTest(){
        //Arranjar
        String editora_Curta = "edi";

        //Agir
        result = regra.validarEditoraFormato(editora_Curta);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraExcedenteTest(){
        //Arranjar
        String editora_Excedente = "editoraquenaopassapelavalidacaodenumeromaximo";

        //Agir
        result = regra.validarEditoraFormato(editora_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraSemLetraTest(){
        //Arranjar
        String editora_Sem_Letras = "12345";

        //Agir
        result = regra.validarEditoraFormato(editora_Sem_Letras);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEditoraLetraNumeroTest(){
        //Arranjar
        String editora_Com_Numeros = "12345naoVale";

        //Agir
        result = regra.validarEditoraFormato(editora_Com_Numeros);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEditoraNaoNuloTest(){
        //Arranjar
        String editora_Nao_Nulo = "editora aprovada";

        //Agir
        result = regra.validarEditoraNulo(editora_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEditoraNuloTest(){
        //Arranjar
        String editora_Nulo = "";

        //Agir
        result = regra.validarEditoraNulo(editora_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarIndicacaoFormatoCorretoTest(){
        //Arranjar
        String indicacao_Valida = "Gabriel Carvalho";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Valida);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarIndicacoSoMinusculaTest(){
        //Arranjar
        String indicacao_So_Minusculas = "indicacao minuscula";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_So_Minusculas);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarIndicacoSoMaiusculaTest(){
        //Arranjar
        String indicacao_So_Maiusculas = "IDICACAO MAIUSCULA";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_So_Maiusculas);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarIndicacaoSoNumeroTest(){
        //Arranjar
        String indicacao_So_Numero = "123456";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_So_Numero);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarIndicacaoNumeroLetraTest(){
        //Arranjar
        String indicacao_Numero_Letra = "testando123456";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Numero_Letra);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarIndicacaoNaoNuloTest(){
        //Arranjar
        String indicacao_Nao_Nulo = "Indicacao valida";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarIndicacaoNuloTest(){
        //Arranjar
        String indicacao_Nulo = "";

        //Agir
        result = regra.validarIndicacaoNulo(indicacao_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @After
    public void destruirObjetos(){
        regra = null;
        result = null;
    }


}
