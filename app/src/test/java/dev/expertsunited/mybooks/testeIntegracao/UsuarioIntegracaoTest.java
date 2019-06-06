package dev.expertsunited.mybooks.testeIntegracao;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import dev.expertsunited.mybooks.database.UsuarioDAO;
import dev.expertsunited.mybooks.fachada.Fachada;
import dev.expertsunited.mybooks.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioIntegracaoTest {

    @Mock
    private Fachada fachada;

    private Usuario u;

    @Before
    public void iniciarObjetos(){
        u = new Usuario();
        fachada = new Fachada();
    }

    @Test
    public void validarCadastroUsuarioFormatoCorretoTest(){
        //Arrumar
        u.setNome("william");
        u.setEmail("william@gmail.com");
        u.setLogin("william10");
        u.setSenha("Wil100%");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test
    public void validarCadastroUsuarioFormatoInvalidoTest(){
        //Arrumar
        u.setNome("abc");
        u.setEmail("williammail.com");
        u.setLogin("abc");
        u.setSenha("12345");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }
    

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioNullTest(){
        //Arrumar
        u = null;

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertFalse(result);
    }

    @Test
    public void validarCadastroUsuarioSemValoresTest(){
        //Arrumar
        u.setNome("");
        u.setEmail("");
        u.setLogin("");
        u.setSenha("");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioSoPassandoNomeTest(){
        //Arrumar
        u.setNome("mariaJose");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioSoPassandoEmailTest(){
        //Arrumar
        u.setEmail("abc100@gmail.com");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioSoPassandoSenhaTest(){
        //Arrumar
        u.setSenha("Wil10%");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioSoPassandoLoginTest(){
        //Arrumar
        u.setLogin("will100");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void validarCadastroUsuarioSoPassandoLoginSenhaTest(){
        //Arrumar
        u.setLogin("will100");
        u.setSenha("Wil10%");

        //Agir
        boolean result = fachada.cadastrarUsuario(u);

        //Afirmar
        Assert.assertTrue(result);
    }

    @After
    public void destruirObjetos(){
        u = null;
        fachada = null;
    }
}
