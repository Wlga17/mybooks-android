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

    @Before
    public void iniciarObjetos(){
        regra = new UsuarioNegocio();
        result = true;
    }

    @Test
    public void validarEmailCorretoTest(){
        //Arranjar
        String email_Valido = "abc100@gmail.com";

        //Agir
        result = regra.validarEmailFormato(email_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEmailSemArrobaTest(){
        //Arranjar
        String email_Invalido_SemArroba = "abc100gmail.com";

        //Agir
        result = regra.validarEmailFormato(email_Invalido_SemArroba);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEmailSemPontoTest(){
        //Arranjar
        String email_Invalido_SemPonto = "abc100@gmailcombr";

        //Agir
        result = regra.validarEmailFormato(email_Invalido_SemPonto);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEmailIncorretoTest(){
        //Arranjar
        String email_Invalido = "abc.com";

        //Agir
        result = regra.validarEmailFormato(email_Invalido);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarEmailComLetraMaiusculaTest(){
        //Arranjar
        String email_Invalido_ComLetraMaiuscula = "abc100@Gmail.com.br";

        //Agir
        result = regra.validarEmailFormato(email_Invalido_ComLetraMaiuscula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarEmailNaoNuloTest(){
        //Arranjar
        String email_Nao_Nulo = "gabrielksi@gmail.com";

        //Agir
        result = regra.validarEmailNulo(email_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarEmailNuloTest(){
        //Arranjar
        String email_Nulo = "";

        //Agir
        result = regra.validarEmailNulo(email_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarNomeNaoNuloTest(){
        //Arranjar
        String nome_Nao_Nulo = "gabriel";

        //Agir
        result = regra.validarNomeNulo(nome_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarNomeFormatoCorretoTest(){
        //Arranjar
        String nome_Valido = "Gabriel Carvalho de Sá";

        //Agir
        result = regra.validarNomeFormato(nome_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarNomeNuloTest(){
        //Arranjar
        String nome_Nulo = "";

        //Agir
        result = regra.validarNomeNulo(nome_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeCurtoTest() {
        //Arranjar
        String nome_Curto = "abc";

        //Agir
        result = regra.validarNomeFormato(nome_Curto);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeExcedenteTest() {
        //Arranjar
        String nome_Excedente = "William Luiz Gonçalves de Araujo";

        //Agir
        result = regra.validarNomeFormato(nome_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarNomeTamanhoMinimoTest() {
        //Arranjar
        String nome_Minimo_Valido = "Bill";

        //Agir
        result = regra.validarNomeFormato(nome_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarNomeTamanhoMaximoTest() {
        //Arranjar
        String nome_Maximo_Valido = "Bill Clinton da Silva Neto Sas";

        //Agir
        result = regra.validarNomeFormato(nome_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarNomeComNumeroTest(){
        //Arranjar
        String nome_Com_Numero = "william10";

        //Agir
        result = regra.validarNomeFormato(nome_Com_Numero);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarNomeComCaracteresEspeciaisTest(){
        //Arranjar
        String nome_Caracter_Especial = "william$$$";

        //Agir
        result = regra.validarNomeFormato(nome_Caracter_Especial);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginNaoNuloTest(){
        //Arranjar
        String login_Nao_Nulo = "loginUsuario";

        //Agir
        result = regra.validarLoginNulo(login_Nao_Nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginNuloTest(){
        //Arranjar
        String login_Nulo = "";

        //Agir
        result = regra.validarLoginNulo(login_Nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginFormatoCorretoTest(){
        //Arranjar
        String login_Formato_Valido = "Avohai";

        //Agir
        result = regra.validarLoginFormato(login_Formato_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginCurtoTest(){
        //Arranjar
        String login_Curto = "avoha";

        //Agir
        result = regra.validarLoginFormato(login_Curto);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarLoginExcedenteTest(){
        //Arranjar
        String login_Excedente = "avohaiTexeira";

        //Agir
        result = regra.validarLoginFormato(login_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginTamanhoMinimoTest(){
        //Arranjar
        String login_Minimo_Valido = "Avovoh";

        //Agir
        result = regra.validarLoginFormato(login_Minimo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarLoginTamanhoMaximoTest(){
        //Arranjar
        String login_Maximo_Valido = "Avohai_Tex12";

        //Agir
        result = regra.validarLoginFormato(login_Maximo_Valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginComCaracteresEspeciaisInvalidosTest(){
        //Arranjar
        String login_Caracter_Especial = "*avohai";

        //Agir
        result = regra.validarLoginFormato(login_Caracter_Especial);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginComNumeroTest(){
        //Arranjar
        String login_Com_Numero = "avohai10";

        //Agir
        result = regra.validarLoginFormato(login_Com_Numero);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaNulaTest(){
        //Arranjar
        String senha_Nula = " ";

        //Agir
        result = regra.validarSenhaNulo(senha_Nula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarSenhaNaoNulaTest(){
        //Arranjar
        String senha_Nao_Nula = "@Bcd22";

        //Agir
        result = regra.validarSenhaNulo(senha_Nao_Nula);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaCurtaTest(){
        //Arranjar
        String senha_Curta = "Do@5";

        //Agir
        result = regra.validarSenhaFormato(senha_Curta);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaExcedenteTest(){
        //Arranjar
        String senha_Excedente = "@Vohai1234567";

        //Agir
        result = regra.validarSenhaFormato(senha_Excedente);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarSenhaTamanhoMinimoTest(){
        //Arranjar
        String senha_Minimo_Vlaido = "Do@122";

        //Agir
        result = regra.validarSenhaFormato(senha_Minimo_Vlaido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarSenhaTamanhoMaximoTest(){
        //Arranjar
        String senha_Maximo_Vlaido = "Dr4g@oF0rceX";

        //Agir
        result = regra.validarSenhaFormato(senha_Maximo_Vlaido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarSenhaSoComLetraMinusculaTest(){
        //Arranjar
        String senha_Letra_Minuscula = "abcdefhg";

        //Agir
        result = regra.validarSenhaFormato(senha_Letra_Minuscula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSoComLetraMaiusculaTest(){
        //Arranjar
        String senha_Letra_Maiuscula = "ABCDEFGHIJ";

        //Agir
        result = regra.validarSenhaFormato(senha_Letra_Maiuscula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSoComNumeroTest(){
        //Arranjar
        String senha_Numero = "123456";

        //Agir
        result = regra.validarSenhaFormato(senha_Numero);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSoComCaracteresEspeciaisTest(){
        //Arranjar
        String senha_Caracter_Especial = "@$%#*&@";

        //Agir
        result = regra.validarSenhaFormato(senha_Caracter_Especial);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSemCaracteresEspeciaisTest(){
        //Arranjar
        String senha_Sem_Caracter_Especial = "Boav1d4";

        //Agir
        result = regra.validarSenhaFormato(senha_Sem_Caracter_Especial);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSemNumeroTest(){
        //Arranjar
        String senha_Sem_Numero = "Bo@vid@";

        //Agir
        result = regra.validarSenhaFormato(senha_Sem_Numero);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSemLetrasTest(){
        //Arranjar
        String senha_Sem_Letras = "123@%$";

        //Agir
        result = regra.validarSenhaFormato(senha_Sem_Letras);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSemLetraMaiusculaTest(){
        //Arranjar
        String senha_Sem_Letra_Maiuscula = "boav1d@";

        //Agir
        result = regra.validarSenhaFormato(senha_Sem_Letra_Maiuscula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void invalidarSenhaSemLetraMinusculaTest(){
        //Arranjar
        String senha_Sem_Letra_Minuscula = "BOAV1D@";

        //Agir
        result = regra.validarSenhaFormato(senha_Sem_Letra_Minuscula);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarSenhaFormatoCorretoTest(){
        //Arranjar
        String senha_Formato_Correto = "Bo@v1da";

        //Agir
        result = regra.validarSenhaFormato(senha_Formato_Correto);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void invalidarLoginSenhaEqualsTest() {
        //Arranjar
        String senha = "Dr@d0nForce";
        String login = "Dr@d0nForce";
        //Agir
        result = regra.validarIgualdadeLoginSenha(login,senha);
        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarLoginSenhaNotEqualsTest() {
        //Arranjar
        String senha = "Dr@d0nForce";
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
