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
    public void validarTituloTamanhoMinimoTest(){
        //Arranjar
        String titulo_Minimo_Valido = "1982";

        //Agir
        result = regra.validarTituloFormato(titulo_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarTituloTamanhoMaximoTest(){
        //Arranjar
        String titulo_Maximo_Valido = "O Curioso Caso de Benjamin Button na Olx";

        //Agir
        result = regra.validarTituloFormato(titulo_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
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
    public void invalidarAutorSoNumeroTest(){
        //Arranjar
        String autor_So_Numeros = "123456";

        //Agir
        result = regra.validarAutorFormato(autor_So_Numeros);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarAutorCurtoTest(){
        //Arranjar
        String autor_Curto = "Ico";

        //Agir
        result = regra.validarAutorFormato(autor_Curto);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarAutorExcedenteTest(){
        //Arranjar
        String autor_Excedente = "Dagoberto Roberto Roberval Sosy";

        //Agir
        result = regra.validarAutorFormato(autor_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarAutorTamanhoMinimoTest(){
        //Arranjar
        String autor_Minimo_Valido = "Icón";

        //Agir
        result = regra.validarAutorFormato(autor_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarAutorTamanhoMaximoTest(){
        //Arranjar
        String autor_Maximo_Valido = "Dagoberto Roberto Roberval Sós";

        //Agir
        result = regra.validarAutorFormato(autor_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarAutorNaoNuloTest(){
        //Arranjar
        String autor_Nao_Nulo = "Eu que fiz";

        //Agir
        result = regra.validarAutorNulo(autor_Nao_Nulo);

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
        String edicao_Excedente = "minha nada mole vida passando dos limites";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEdicaoTamanhoMinimoTest(){
        //Arranjar
        String edicao_Minimo_Valido = "E1";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoTamanhoMaximoTest(){
        //Arranjar
        String edicao_Maximo_Valido = "Edição de Luxo Luxuosa xXx 12B";

        //Agir
        result = regra.validarEdicaoFormato(edicao_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEdicaoNaoNuloTest(){
        //Arranjar
        String edicao_Nao_Nulo = "edicao";

        //Agir
        result = regra.validarEdicaoNulo(edicao_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEdicaoNuloTest(){
        //Arranjar
        String edicao_Nulo = "";

        //Agir
        result = regra.validarEdicaoNulo(edicao_Nulo);

        //Afirmar
        Assert.assertFalse(result);
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
    public void validarEditoraTamanhoMinimoTest(){
        //Arranjar
        String editora_Minimo_valido = "Edit";

        //Agir
        result = regra.validarEditoraFormato(editora_Minimo_valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarEditoraTamanhoMaximoTest(){
        //Arranjar
        String editora_Maximo_valido = "Editoras Fantardigas";

        //Agir
        result = regra.validarEditoraFormato(editora_Maximo_valido);

        //Afirmar
        Assert.assertTrue(result);
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
        String indicacao_So_Maiusculas = "INDICACAO MAIUSCULA";

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
    public void invalidarIndicacaoCurtaTest(){
        //Arranjar
        String indicacao_Curta = "Ind";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Curta);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarIndicacaoExcedenteTest(){
        //Arranjar
        String indicacao_Excedente = "Roberval Dagoberto Teixeira Sós";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarIndicacaoTamanhoMinimoTest(){
        //Arranjar
        String indicacao_Minimo_Valido = "Robs";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarIndicacaoTamanhoMaximoTest(){
        //Arranjar
        String indicacao_Maximo_Valido = "Roberval Dagoberto Teixeira Só";

        //Agir
        result = regra.validarIndicacaoFormato(indicacao_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
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

    @Test
    public void validarPrecoZeroTest(){
        //Arranjar
        String precoZero = "0";

        //Agir
        result = regra.validarPrecoFormato(precoZero);

        //Afirmar
        Assert.assertTrue(result);
    }


    @Test
    public void invalidarPrecoNegativoTest(){
        //Arranjar
        String precoNegativo = "-1";

        //Agir
        result = regra.validarPrecoFormato(precoNegativo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarPrecoExcedenteTest(){
        //Arranjar
        String precoExcedente = "10000";

        //Agir
        result = regra.validarPrecoFormato(precoExcedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarPrecoTamanhoMinimoTest(){
        //Arranjar
        String preco_Minimo_Valido = "1";

        //Agir
        result = regra.validarPrecoFormato(preco_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarPrecoTamanhoMaximoTest(){
        //Arranjar
        String preco_Maximo_Valido = "9999.99";

        //Agir
        result = regra.validarPrecoFormato(preco_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarPrecoComVirgulaTest(){
        //Arranjar
        String precoComVirgula = "10,02";

        //Agir
        result = regra.validarPrecoFormato(precoComVirgula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarPrecoComPontoTest(){
        //Arranjar
        String precoComPonto = "10.02";

        //Agir
        result = regra.validarPrecoFormato(precoComPonto);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarPrecoComPonto_E_VirgulaTest(){
        //Arranjar
        String precoComPonto_E_Virgula = "1000.5,2";

        //Agir
        result = regra.validarPrecoFormato(precoComPonto_E_Virgula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarPrecoNuloTest(){
        //Arranjar
        String precoNulo = "";

        //Agir
        result = regra.validarPrecoNulo(precoNulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarPrecoNaoNuloTest(){
        //Arranjar
        String precoNaoNulo = "10";

        //Agir
        result = regra.validarPrecoNulo(precoNaoNulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarPrecoComEspacoTest(){
        //Arranjar
        String precoComEspaco = "10 30";

        //Agir
        result = regra.validarPrecoFormato(precoComEspaco);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarPrecoComLetraTest(){
        //Arranjar
        String precoComLetra = "10a30";

        //Agir
        result = regra.validarPrecoFormato(precoComLetra);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarPrecoComCaracterEspecialTest(){
        //Arranjar
        String precoComCaracterEspecial = "10@$";

        //Agir
        result = regra.validarPrecoFormato(precoComCaracterEspecial);

        //Afirmar
        Assert.assertFalse(result);
    }



    @After
    public void destruirObjetos(){
        regra = null;
        result = null;
    }


}
