package dev.expertsunited.mybooks.negocioTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dev.expertsunited.mybooks.RegraDeNegocio.UsuarioNegocio;
import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioTeste {

    private Usuario usuario;
    private UsuarioNegocio regra;

    //Arranjar
    //Agir
    //Afirmar

    @Before
    public void iniciarObjetos(){
        usuario = new Usuario();
        regra = new UsuarioNegocio();
    }

    @Test
    public void emailValidoTest(){
        //Arranjar
        String email_valido = "abc100@gmail.com";

        //Agir
        boolean result = regra.validarEmailFormato(email_valido);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void emailInvalidoTest(){
        //Arranjar
        String email_invalido = "abc.com";

        //Agir
        boolean result = regra.validarEmailFormato(email_invalido);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void emailNaoNuloTest(){
        //Arranjar
        String email_nao_nulo = "gabrielksi@gmail.com";

        //Agir
        boolean result = regra.validarEmailNulo(email_nao_nulo);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void emailNuloTest(){
        //Arranjar
        String email_nulo = "";

        //Agir
        boolean result = regra.validarEmailNulo(email_nulo);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void nomeNaoNuloTest(){
        //Arranjar
        String nome = "gabriel";

        //Agir
        boolean result = regra.validarNomeNulo(nome);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void nomeNuloTest(){
        //Arranjar
        String nome = "";

        //Agir
        boolean result = regra.validarNomeNulo(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void nomeTamanho3Test() {
        //Arranjar
        String nome = "abc";

        //Agir
        boolean result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void loginNaoNulo(){
        //Arranjar
        String login = "loginUsuario";

        //Agir
        boolean result = regra.validarLoginNulo(login);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void loginNulo(){
        //Arranjar
        String login = "";

        //Agir
        boolean result = regra.validarLoginNulo(login);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarFormatoLogin(){

    }

    @After
    public void destruirObjetos() {
        usuario = null;
        regra = null;
    }
}
