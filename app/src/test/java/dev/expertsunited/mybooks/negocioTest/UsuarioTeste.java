package dev.expertsunited.mybooks.negocioTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dev.expertsunited.mybooks.RegraDeNegocio.UsuarioNegocio;
import dev.expertsunited.mybooks.model.Usuario;

public class UsuarioTeste {

    private Usuario usuario;
    private UsuarioNegocio regra;

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
}
