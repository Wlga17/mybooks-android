package dev.expertsunited.mybooks.daoTeste;

import android.content.Context;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import dev.expertsunited.mybooks.database.UsuarioDAO;
import dev.expertsunited.mybooks.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest{

    @Mock
    private Context context;
    @Mock
    private UsuarioDAO dao;

    private Usuario u;

    @Before
    public void iniciarObjetos(){
        dao = new UsuarioDAO(context);
        u = new Usuario();
    }

    @Test(expected = RuntimeException.class)
    public void invalidarCadastroUsuarioTest(){
        //Arrumar
        u.setNome("abc");
        u.setEmail("williammail.com");
        u.setLogin("abc");
        u.setSenha("12345");

        //Agir
        boolean result = dao.cadastrar(u);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void validarCadastroUsuarioTest() {
        //Arrumar
        u.setNome("william");
        u.setEmail("william@gmail.com");
        u.setLogin("william10");
        u.setSenha("Wil100%");

        //Agir
        boolean result = dao.cadastrar(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void invalidarCadastroUsuarioNullTest(){
        //Arrumar
        u = null;

        //Agir
        boolean result = dao.cadastrar(u);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void invalidarCadastroUsuarioSemValoresTest(){
        //Arrumar
        u.setNome("");
        u.setEmail("");
        u.setLogin("");
        u.setSenha("");

        //Agir
        boolean result = dao.cadastrar(u);

        //Afirmar
        Assert.assertFalse(result);
    }

    @After
    public void destruirObjetos(){
        dao = null;
        u = null;
    }
}
