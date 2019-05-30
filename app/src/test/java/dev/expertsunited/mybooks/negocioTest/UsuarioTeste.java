package dev.expertsunited.mybooks.negocioTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dev.expertsunited.mybooks.RegraDeNegocio.UsuarioNegocio;

public class UsuarioTeste {

    private UsuarioNegocio regra;
    private Boolean result;

    //Arranjar
    //Agir
    //Afirmar

    @Before
    public void iniciarObjetos(){
        regra = new UsuarioNegocio();
        result = true;
    }

    @Test
    public void validarEmailCorretoTest(){
        //Arranjar
        String email_valido = "abc100@gmail.com";

        //Agir
        result = regra.validarEmailFormato(email_valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEmailIncorretoTest(){
        //Arranjar
        String email_invalido = "abc.com";

        //Agir
        result = regra.validarEmailFormato(email_invalido);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEmailNaoNuloTest(){
        //Arranjar
        String email_nao_nulo = "gabrielksi@gmail.com";

        //Agir
        result = regra.validarEmailNulo(email_nao_nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEmailNuloTest(){
        //Arranjar
        String email_nulo = "";

        //Agir
        result = regra.validarEmailNulo(email_nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarNomeNaoNuloTest(){
        //Arranjar
        String nome = "gabriel";

        //Agir
        result = regra.validarNomeNulo(nome);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarNomeFormatoCorretoTest(){
        //Arranjar
        String nome = "gabriel";

        //Agir
        result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarNomeNuloTest(){
        //Arranjar
        String nome = "";

        //Agir
        result = regra.validarNomeNulo(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeCurtoTest() {
        //Arranjar
        String nome = "abc";

        //Agir
        result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeExcedenteTest() {
        //Arranjar
        String nome = "William Luiz Gonçalves de Araujo";

        //Agir
        result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeComNumeroTest(){
        //Arranjar
        String nome = "william10";

        //Agir
        result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeComCaracteresEspeciaisTest(){
        //Arranjar
        String nome = "william$$$";

        //Agir
        result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginNaoNuloTest(){
        //Arranjar
        String login = "loginUsuario";

        //Agir
        result = regra.validarLoginNulo(login);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginNuloTest(){
        //Arranjar
        String login = "";

        //Agir
        result = regra.validarLoginNulo(login);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginFormatoCorretoTest(){
        //Arranjar
        String loginFormatoValido = "Avohai";

        //Agir
        result = regra.validarLoginFormato(loginFormatoValido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginCurtoTest(){
        //Arranjar
        String login5Caracteres = "avoha";

        //Agir
        result = regra.validarLoginFormato(login5Caracteres);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarLoginExcedenteTest(){
        //Arranjar
        String login13Caracteres = "avohaiTexeira";

        //Agir
        result = regra.validarLoginFormato(login13Caracteres);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarLoginComCaracteresEspeciaisTest(){
        //Arranjar
        String loginComCaracEspecial = "@avohai";

        //Agir
        result = regra.validarLoginFormato(loginComCaracEspecial);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginComNumeroTest(){
        //Arranjar
        String loginComNumero = "avohai10";

        //Agir
        result = regra.validarLoginFormato(loginComNumero);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaNulaTest(){
        //Arranjar
        String senhaNula = " ";

        //Agir
        result = regra.validarSenhaNulo(senhaNula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarSenhaNaoNulaTest(){
        //Arranjar
        String senhaNaoNula = "1234567";

        //Agir
        result = regra.validarSenhaNulo(senhaNaoNula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaCurtaTest(){
        //Arranjar
        String senhaCurta = "12345";

        //Agir
        result = regra.validarSenhaFormato(senhaCurta);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaExcedenteTest(){
        //Arranjar
        String senhaExcedente = "avohai1234567";

        //Agir
        result = regra.validarSenhaFormato(senhaExcedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarSenhaComLetraMinusculaTest(){
        //Arranjar
        String senhaLetraMinuscula = "abcdefhg";

        //Agir
        result = regra.validarSenhaFormato(senhaLetraMinuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarSenhaComLetraMaiusculaTest(){
        //Arranjar
        String senhaLetraMaiuscula = "ABCDEFGHIJ";

        //Agir
        result = regra.validarSenhaFormato(senhaLetraMaiuscula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarSenhaComNumeroELetraTest(){
        //Arranjar
        String senhaNumeroLetra = "start123";

        //Agir
        result = regra.validarSenhaFormato(senhaNumeroLetra);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarSenhaComCaracteresEspeciaisValidoTest(){
        //Arranjar
        String senhaCaracValido = "@senha@";

        //Agir
        result = regra.validarSenhaFormato(senhaCaracValido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaComCaracteresEspeciaisInvalidoTest(){
        //Arranjar
        String senhaCaracInvalido = "senha***";

        //Agir
        result = regra.validarSenhaFormato(senhaCaracInvalido);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarLoginSenhaEqualsTest() {
        //Arranjar
        String senha = "abc123";
        String login = "abc123";
        //Agir
        result = regra.validarIgualdadeLoginSenha(login,senha);
        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginSenhaNotEqualsTest() {
        //Arranjar
        String senha = "abc123";
        String login = "abc1234";
        //Agir
        result = regra.validarIgualdadeLoginSenha(login,senha);
        //Afirmar
        Assert.assertTrue(result);
    }

    @After
    public void destruirObjetos() {
        regra = null;
        result = null;
    }
}
