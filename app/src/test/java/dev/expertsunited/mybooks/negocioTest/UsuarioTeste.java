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
    public void nomeTamanho3Test() {
        //Arranjar
        String nome = "abc";

        //Agir
        boolean result = regra.validarNomeFormato(nome);

        //Afirmar
        Assert.assertFalse(result);
    }

    @After
    public void destruirObjetos() {
        usuario = null;
        regra = null;
    }
}
